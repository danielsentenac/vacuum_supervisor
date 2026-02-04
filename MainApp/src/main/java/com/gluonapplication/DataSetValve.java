package com.gluonapplication;



public class DataSetValve extends DataSet {

   public DataSetValve(String name) {
      super();

      String[] attributes = name.split(":"); // Expect 2 attributes
      String channelPrefix = "VAC_" + attributes[0];
      System.out.println("Creating DataSetValve : " + channelPrefix + ":" +  attributes[1]);
      // Status Valves
      // TUBEN and TUBEW cases
      if (attributes[1].equals("-") && channelPrefix.contains("V21")) 
         list.addElement(new DataElement("Status",Type.LABEL_VALVE_STATUS_STRING, channelPrefix + "ST"));
      else if (attributes[1].equals("-") && channelPrefix.contains("V31"))
         list.addElement(new DataElement("Status",Type.LABEL_VALVE_STATUS_STRING, channelPrefix + "ST"));
      else if (attributes[1].equals("-") && channelPrefix.contains("VP")) 
         list.addElement(new DataElement("Status",Type.LABEL_VALVE_STATUS_STRING, channelPrefix + "ST"));
      else if (attributes[1].equals("-") && channelPrefix.contains("VALVEBIG"))
         list.addElement(new DataElement("Status",Type.LABEL_VALVE_STATUS_STRING, channelPrefix + "_ST"));
      // GLOBAL (LN2 TANK) case
      else if (attributes[1].equals("-") && channelPrefix.contains("LN2TANKVALVE") && !channelPrefix.contains("WI"))
         list.addElement(new DataElement("Status",Type.LABEL_VALVE_STATUS_STRING, "VAC_VALVEBIG" + attributes[0],""));
      else if (attributes[1].equals("-") && channelPrefix.contains("LN2TANKVALVE_WI"))
         list.addElement(new DataElement("Status",Type.LABEL_VALVE_STATUS_STRING, "VAC_VALVEBIGNI_" + attributes[0],""));
      // END BUILDING cases
      else if (attributes[1].equals("-") && channelPrefix.contains("VCRYO"))
         list.addElement(new DataElement("Status",Type.LABEL_VALVE_STATUS_STRING,  channelPrefix + "ST"));
      // CENTRAL BUILDING cases
      else if (attributes[1].equals("-") && channelPrefix.contains("VALVECENTRAL"))
         list.addElement(new DataElement("Status",Type.LABEL_VALVE_STATUS_STRING,  channelPrefix + "ST"));
      else if (attributes[1].equals("-") && channelPrefix.contains("CRYOLINK"))
         list.addElement(new DataElement("Status",Type.LABEL_VALVE_2_STATUS_STRING,  channelPrefix));
      else if (attributes[1].equals("-") && channelPrefix.contains("VENTINGVALVE"))
         list.addElement(new DataElement("Status",Type.LABEL_VALVE_STATUS_STRING,  channelPrefix + "ST"));
      else if (attributes[0].contains("TUBE"))
         list.addElement(new DataElement("Status",Type.LABEL_VALVE_STATUS_STRING, channelPrefix + TUBESTATION_VALVE_CHANNELS.get("Status"+attributes[1])));
      else if (attributes[0].contains("LINKPR"))
         list.addElement(new DataElement("Status",Type.LABEL_VALVE_STATUS_STRING, channelPrefix.replace("PR","") + "_PR" + LINK_VALVE_CHANNELS.get("Status"+attributes[1])));
      else if (attributes[0].contains("LINKSR"))
         list.addElement(new DataElement("Status",Type.LABEL_VALVE_STATUS_STRING, channelPrefix.replace("SR","") + "_SR" + LINK_VALVE_CHANNELS.get("Status"+attributes[1])));
      else if (attributes[0].contains("CRYOLINKDET") && (attributes[1].contains("V21") || attributes[1].contains("V22")))  // V21 & V22 Valves
         list.addElement(new DataElement("Status",Type.LABEL_VALVE_STATUS_STRING, channelPrefix.replace("DET","") + "_DET" + CRYOLINK_VALVE_CHANNELS.get("Status"+attributes[1])));
      else if (attributes[0].contains("CRYOLINKIB") && (attributes[1].contains("V21")|| attributes[1].contains("V22")) )  // V21 & V22 Valves
         list.addElement(new DataElement("Status",Type.LABEL_VALVE_STATUS_STRING, channelPrefix.replace("IB","") + "_IB" + CRYOLINK_VALVE_CHANNELS.get("Status"+attributes[1])));
      else if (attributes[0].contains("SQZ") ||
               attributes[0].contains("TILTMETER")) {
         if (attributes[1].equals("Vrem") && attributes[0].contains("SQZDET2")) // Special case for Vrem
             list.addElement(new DataElement("Status",Type.LABEL_VALVE_STATUS_STRING, "VAC_SQZDET1" + SQZ_VALVE_CHANNELS.get("Status"+attributes[1])));
         else
            list.addElement(new DataElement("Status",Type.LABEL_VALVE_STATUS_STRING, channelPrefix + SQZ_VALVE_CHANNELS.get("Status"+attributes[1])));
      }
      else if (attributes[0].contains("TOWER"))
         list.addElement(new DataElement("Status",Type.LABEL_VALVE_STATUS_STRING, channelPrefix + TOWER_VALVE_CHANNELS.get("Status"+attributes[1])));
      else if (attributes[0].contains("CRYO") && !attributes[0].contains("LINK"))
         list.addElement(new DataElement("Status",Type.LABEL_VALVE_STATUS_STRING, channelPrefix + CRYO_VALVE_CHANNELS.get("Status"+attributes[1])));
      else if (attributes[0].contains("REMOTESCROLL"))
         list.addElement(new DataElement("Status",Type.LABEL_VALVE_STATUS_STRING, channelPrefix + REMOTEPUMPS_VALVE_CHANNELS.get("Status"+attributes[1])));
      else if (attributes[0].contains("CRYOLINK") && attributes[1].contains("Vs")) {
         list.addElement(new DataElement("Status",Type.LABEL_VALVE_2_STATUS_STRING, channelPrefix + CRYOLINK_VALVE_CHANNELS.get("Status"+attributes[1])));
         System.out.println("CREATE DATAELEMENT: " + channelPrefix + CRYOLINK_VALVE_CHANNELS.get("Status"+attributes[1]));
      }
      else if (attributes[0].contains("CRYOLINK") && attributes[1].contains("CV1"))
         list.addElement(new DataElement("Status",Type.LABEL_VALVE_3_STATUS_STRING, channelPrefix + CRYOLINK_VALVE_CHANNELS.get("Status"+attributes[1]),3));
      else if (attributes[0].contains("CRYOLINK") && attributes[1].contains("CV2"))
         list.addElement(new DataElement("Status",Type.LABEL_VALVE_3_STATUS_STRING, channelPrefix + CRYOLINK_VALVE_CHANNELS.get("Status"+attributes[1]),2));
         

      // Init
      Init();
   }
}




