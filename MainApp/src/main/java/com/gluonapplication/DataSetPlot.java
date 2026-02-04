package com.gluonapplication;

import java.util.Vector;


public class DataSetPlot extends DataSet {

   public DataSetPlot(String name) {
      super();

      String[] attributes = name.split(":"); // Expect 2 attributes
      System.out.println("Creating DataSetPlot : " + name);
      // Plot Data
      if ( attributes[0].contains("LAL") && attributes[0].contains("TUBE"))
         list.addElement(new DataElement("Data",Type.PLOT_DATA,"VAC_" + attributes[0] + PLOT_TUBE_LAL_CHANNELS.get(attributes[1])));
      else if ( attributes[0].contains("TUBE"))
         list.addElement(new DataElement("Data",Type.PLOT_DATA,"VAC_" + attributes[0] + PLOT_TUBE_EGO_CHANNELS.get(attributes[1])));
      else if ( attributes[0].contains("LINKPR")) {
         if (attributes[1].startsWith("PlotG")) // Gauge case
            list.addElement(new DataElement("Data",Type.PLOT_DATA,"VAC_" + attributes[0].replace("PR","") + PLOT_LINKPR_CHANNELS.get(attributes[1])));
         else
            list.addElement(new DataElement("Data",Type.PLOT_DATA,"VAC_" + attributes[0].replace("PR","_PR") + PLOT_LINKPR_CHANNELS.get(attributes[1])));
      }
      else if ( attributes[0].contains("LINKSR")) {
         if (attributes[1].startsWith("PlotG")) // Gauge case 
            list.addElement(new DataElement("Data",Type.PLOT_DATA,"VAC_" + attributes[0].replace("SR","") + PLOT_LINKSR_CHANNELS.get(attributes[1])));
         else
            list.addElement(new DataElement("Data",Type.PLOT_DATA,"VAC_" + attributes[0].replace("SR","_SR") + PLOT_LINKSR_CHANNELS.get(attributes[1])));
      }
      else if ( attributes[0].equals("CRYOLINKDET")) {
         if (attributes[1].startsWith("PlotG2")) // Gauge case
            list.addElement(new DataElement("Data",Type.PLOT_DATA,"VAC_" + attributes[0].replace("DET","") + PLOT_CRYOLINK_CHANNELS.get(attributes[1])));
         else if (attributes[1].equals("PlotP21")) // Turbo Speed case
            list.addElement(new DataElement("Data",Type.PLOT_DATA,"VAC_" + attributes[0].replace("DET","_DET") + PLOT_CRYOLINK_CHANNELS.get(attributes[1])));
         else // All other cases
            list.addElement(new DataElement("Data",Type.PLOT_DATA,"VAC_" + attributes[0] + PLOT_CRYOLINK_CHANNELS.get(attributes[1])));
      }
      else if ( attributes[0].equals("CRYOLINKIB")) {
         if (attributes[1].startsWith("PlotG2")) // Gauge case
            list.addElement(new DataElement("Data",Type.PLOT_DATA,"VAC_" + attributes[0].replace("IB","") + PLOT_CRYOLINK_CHANNELS.get(attributes[1])));
         else if (attributes[1].equals("PlotP21")) // Turbo Speed case
            list.addElement(new DataElement("Data",Type.PLOT_DATA,"VAC_" + attributes[0].replace("IB","_IB") + PLOT_CRYOLINK_CHANNELS.get(attributes[1])));
         else // All other cases
            list.addElement(new DataElement("Data",Type.PLOT_DATA,"VAC_" + attributes[0] + PLOT_CRYOLINK_CHANNELS.get(attributes[1])));
      }
      else if ( attributes[0].contains("SQZ") ||
                attributes[0].contains("TILTMETER")) {
         // Special case GMid
         if ( attributes[1].equals("PlotGMid"))
            list.addElement(new DataElement("Data",Type.PLOT_DATA,"VAC_SQZ100N" + PLOT_SQZ_CHANNELS.get(attributes[1])));
         else
            list.addElement(new DataElement("Data",Type.PLOT_DATA,"VAC_" + attributes[0] + PLOT_SQZ_CHANNELS.get(attributes[1])));
      }
      else if ( attributes[0].contains("CRYOLINK"))
         list.addElement(new DataElement("Data",Type.PLOT_DATA,"VAC_" + attributes[0] + PLOT_CRYOLINK_CHANNELS.get(attributes[1])));
      else if ( attributes[0].contains("CRYO") ) {
         if (attributes[1].contains("LN2"))
            list.addElement(new DataElement("Data",Type.PLOT_DATA,"VAC_" + attributes[0].replace("CRYO","LN2") + PLOT_CRYO_CHANNELS.get(attributes[1])));
         if (attributes[1].contains("VALVEBIG"))
            list.addElement(new DataElement("Data",Type.PLOT_DATA,"VAC_" + attributes[0].replace("CRYO","VALVEBIG") + PLOT_CRYO_CHANNELS.get(attributes[1])));
         else
            list.addElement(new DataElement("Data",Type.PLOT_DATA,"VAC_" + attributes[0] + PLOT_CRYO_CHANNELS.get(attributes[1])));
      }
      else if (attributes[0].contains("TOWERIB") ||
               attributes[0].contains("TOWERDET") ||
               attributes[0].contains("TOWERMC")  ) {
         list.addElement(new DataElement("Data",Type.PLOT_DATA,"VAC_" + attributes[0] + PLOT_BENCHTOWER_CHANNELS.get(attributes[1])));
      }
      else
      list.addElement(new DataElement("Data",Type.PLOT_DATA,"VAC_" + attributes[0] + PLOT_CHANNELS.get(attributes[1])));
    
      // Init
      Init(); 
   }
}




