package com.gluonapplication;



public class DataSetTitane extends DataSet {

   public DataSetTitane(String name) {
      super();

      String[] attributes = name.split(":"); // Expect 2 attributes
      String channelPrefix = "VAC_" + attributes[0];
      System.out.println("Creating DataSetTitane : " + channelPrefix);
      
      // Status Titane
      list.addElement(new DataElement("Status",Type.LABEL_TITANE_STATUS_STRING, 
                                         channelPrefix + TITANE_CHANNELS.get("Status" + attributes[1])));
      // Status Filament
      list.addElement(new DataElement("StatusFilament",Type.LABEL_TITANE_FILAMENT_STATUS_STRING,
                                         channelPrefix + TITANE_CHANNELS.get("StatusFilament" + attributes[1])));
      // Status Controller
      list.addElement(new DataElement("StatusController",Type.LABEL_TITANE_CONTROLLER_STATUS_STRING,
                                         channelPrefix + TITANE_CHANNELS.get("StatusController" + attributes[1])));
      // Status Recover
      list.addElement(new DataElement("StatusRecover",Type.LABEL_TITANE_RECOVER_STATUS_STRING,
                                         channelPrefix + TITANE_CHANNELS.get("StatusRecover" + attributes[1])));
      // Status Autostart
      list.addElement(new DataElement("StatusAutostart",Type.LABEL_TITANE_AUTOSTART_STATUS_STRING,
                                         channelPrefix + TITANE_CHANNELS.get("StatusAutostart" + attributes[1])));
      // Operating Mode
      list.addElement(new DataElement("OperatingMode",Type.LABEL_TITANE_OPERATING_MODE_STRING,
                                         channelPrefix + TITANE_CHANNELS.get("OperatingMode" + attributes[1])));
      // Filament Used
      list.addElement(new DataElement("FilamentUsed",Type.LABEL_VALUE_STRING,
                                         channelPrefix + TITANE_CHANNELS.get("FilamentUsed" + attributes[1])));
      // Absorbed Voltage
      list.addElement(new DataElement("AbsorbedVoltage",Type.LABEL_VALUE_STRING,
                                         channelPrefix + TITANE_CHANNELS.get("AbsorbedVoltage" + attributes[1]),"Volt"));
      // Filament Used
      list.addElement(new DataElement("AbsorbedCurrent",Type.LABEL_VALUE_STRING,
                                         channelPrefix + TITANE_CHANNELS.get("AbsorbedCurrent" + attributes[1]),"Amp"));
      // Sublimation Current
      list.addElement(new DataElement("SublimationCurrent",Type.LABEL_VALUE_STRING,
                                         channelPrefix + TITANE_CHANNELS.get("SublimationCurrent" + attributes[1]),"Amp"));
      // Sublimation Time
      list.addElement(new DataElement("SublimationTime",Type.LABEL_VALUE_STRING,
                                         channelPrefix + TITANE_CHANNELS.get("SublimationTime" + attributes[1]),"1/10mn"));
      // Sublimation Period
      list.addElement(new DataElement("SublimationPeriod",Type.LABEL_VALUE_STRING,
                                         channelPrefix + TITANE_CHANNELS.get("SublimationPeriod" + attributes[1]),"1/10mn"));

      // Init
      Init();
   }
}




