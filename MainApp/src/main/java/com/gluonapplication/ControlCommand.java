package com.gluonapplication;

import com.gluonhq.charm.glisten.application.MobileApplication;
import java.net.URLConnection; //for url management 
import java.net.URL;
import java.io.ObjectInputStream; //for stream management
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Vector;
import java.net.ConnectException;

public class ControlCommand implements Runnable {   
   
   // SIMULATION FLAG
   private boolean isSimulation = false;

   private boolean hasMastership = false;
   private boolean hasPrivilegeAccess = false;
   private String queryType = "";
   private String status = null;
   private String askedValue = "";
   private Vector<String> commandVect;
   private int pause;

   private ControlCommand() {
      Main main = (Main) MobileApplication.getInstance();
      if (main.command_success_layer == null) {
         main.command_success_layer = new LayerMessage("INFORMATION", "Command sent successfully", true);
         main.addLayerFactory("COMMAND_SUCCESS", () -> { return main.command_success_layer;});
      }
      if (main.command_failure_layer == null) {
         main.command_failure_layer = new LayerMessage("INFORMATION", "Command sending failure", true);
         main.addLayerFactory("COMMAND_FAILURE", () -> { return main.command_failure_layer;});
      }
      if (main.command_simulation_layer == null) {
         main.command_simulation_layer = new LayerMessage("INFORMATION", "Simulation mode", true);
         main.addLayerFactory("COMMAND_SIMULATION", () -> { return main.command_simulation_layer;});
      }
   } 
    
   private static final ControlCommand INSTANCE = new ControlCommand();
     
   public static ControlCommand getInstance() {return INSTANCE;}

   private Vector<String> newCommand(String... items) {
      Vector<String> command = new Vector<String>();
      for (String item : items) {
         command.addElement(item);
      }
      return command;
   }

   /**
       A connection method called every time a connection to the servlet is needed. 
       The servlet path points to "jchv" which contains the main servlet 
       for channel visualization.
    */
    protected URLConnection getServerConnection(String url)
            throws MalformedURLException, IOException {
        //System.out.println(getCodeBase() + " " + getDocumentBase());
        URL urlServlet = new URL(url);
        URLConnection con = urlServlet.openConnection();
        con.setConnectTimeout(5000);
        con.setDoInput(true);
        con.setDoOutput(true);
        con.setUseCaches(false);
        con.setRequestProperty("Content-Type", "application/x-java-serialized-object");
        return con;
    }

   public void getMastership(String query) {
      try {
         hasMastership = false;            
         hasPrivilegeAccess = false;
         // send query to the servlet
         URLConnection con = getServerConnection("http://online-data-provider.example:8081/jmaster/jmaster");
         OutputStream outstream = con.getOutputStream();
         ObjectOutputStream oos = new ObjectOutputStream(outstream);
         oos.writeObject(query);
         oos.flush();
         oos.close();
         // receive result from servlet
         InputStream instr = con.getInputStream();
         ObjectInputStream inputFromServlet = new ObjectInputStream(instr);
         String status = (String) inputFromServlet.readObject();
         inputFromServlet.close();
         instr.close();
         System.out.println("getMastership status: " + status + " query: " + query);
         if (status.startsWith("Password"))
           askPassword(query); 
         else if (status.equals("Accept") && queryType.equals("Authorize")) 
           hasMastership = true;
         else if (status.equals("AcceptPrivilege") && queryType.equals("PrivilegeAccess"))
           hasPrivilegeAccess = true;
         else
           tellRefused(status);

        } catch (ConnectException ex) {
            ex.printStackTrace();
            MobileApplication.getInstance().showLayer("SERVER_KO");
        } catch (IOException ex) {
            ex.printStackTrace();
            MobileApplication.getInstance().showLayer("NETWORK_ERROR");
        } catch (Exception ex) {}
    }

    private void askPassword(String query) {
       new DialogAskMastership(query);
    }
   
    private void tellRefused(String status) {
       if (status.equals("Refused") || queryType.equals("PrivilegeAccess"))
          new DialogRefusedMastership();
       else 
          new DialogOverTakeMastership(status);
    }

    public void setAskedValue(String _askedValue) {
       askedValue = _askedValue;
    }

    public String setCommand(String msgServer, String msgType, String msgStation, String msgChannel, 
                             String value, int delay, boolean askMastership, String query, boolean showAlert) {
       queryType = "";
       if (askMastership) {
          queryType = query; // First passage, time query is same as queryType (Authorize | PrivilegeAccess)
          getMastership(query);
          System.out.println("Mastership: " + hasMastership);
       }
       String status = null;
       Vector<String> command = null;
       switch (msgType) {
          case "SETREGISTER": 
                if (hasMastership || !askMastership) {
                   if (!value.equals("")) {
                      command = newCommand(
                              msgServer, msgType, "-t", msgStation, "-t", msgChannel, "-d", value
                      );
                   }
                   else {
                      askedValue = "";
                      new DialogAskValue(msgChannel); // Ask user for value to be used
                      if (!askedValue.equals("")) {
                         command = newCommand(
                                 msgServer, msgType, "-t", msgStation, "-t", msgChannel, "-d", askedValue
                         );
                      }
                   }
                }
                break;
          case "SETVALVEGAUGESAFECHANNEL": 
                if (hasMastership) { 
                   command = newCommand(msgServer, msgType, "-t", msgChannel, "-d", value);
                }
                break;
          case "SETVALVETURBOSAFECHANNEL": 
                if (hasMastership) { 
                   command = newCommand(msgServer, msgType, "-t", msgChannel, "-d", value);
                }
                break;
          case "SETEMERGENCYVALVECHANNEL": 
                if (hasPrivilegeAccess) { 
                   command = newCommand(msgServer, msgType, "-t", msgChannel, "-d", value);
                }
                break;
       }
       if (!isSimulation) {
          if ( command != null ) {
             System.out.println("COMMAND SENT : " + command );
             status = sendCommand(command,delay);
          }
          else
             System.out.println("COMMAND NOT SENT : " + command + " ( REAL )");
       }
       else {
          status = "SIMULATION";
          System.out.println("COMMAND NOT SENT : " + command + " ( SIMULATION )");  
       }
       if (status == null) {
          if ( command != null )
             MobileApplication.getInstance().showLayer("SERVER_KO");
       }
       else if (showAlert) {
          if (status.equals("SUCCESS"))
             MobileApplication.getInstance().showLayer("COMMAND_SUCCESS");
          else if (status.equals("SIMULATION"))
             MobileApplication.getInstance().showLayer("COMMAND_SIMULATION");
          else
             MobileApplication.getInstance().showLayer("COMMAND_FAILURE");
       }   
       return status;
    }

    private String sendCommand(Vector<String> _commandVect, int _pause) {
       status = null;
       commandVect = _commandVect;
       pause = _pause;
       Thread thread = new Thread(this);
       thread.start();
       try { 
          thread.join(); 
       } catch (InterruptedException e) {}
       return status;
    }

    public void run() {
       try {
          // send data to the servlet
	  URLConnection con = getServerConnection("http://online-data-provider.example:9081/jcmd/jcmd");
	  OutputStream outstream = con.getOutputStream();
	  ObjectOutputStream oos = new ObjectOutputStream(outstream);
	  oos.writeObject(commandVect);
	  oos.flush();
	  oos.close();
	    
	  // receive result from servlet
	  InputStream instr = con.getInputStream();
	  ObjectInputStream inputFromServlet = new ObjectInputStream(instr);
	  status = (String) inputFromServlet.readObject();
	  inputFromServlet.close();
	  instr.close();
          Thread.sleep(pause);
	  System.out.println("Response from jcmd servlet: " + status);
	    
       } catch (ConnectException ex) {
            ex.printStackTrace();
            MobileApplication.getInstance().showLayer("SERVER_KO");
        } catch (IOException ex) {
            ex.printStackTrace();
            MobileApplication.getInstance().showLayer("NETWORK_ERROR");
        } catch (Exception ex) {}
    }
}

