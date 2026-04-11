package com.gluonapplication;



public class DataSetIonic extends DataSet {

   public DataSetIonic(String name) {
      super();

      String[] attributes = name.split(":"); // Expect 2 attributes
      String channelPrefix = "VAC_" + attributes[0];
      System.out.println("Creating DataSetIONIC : " + channelPrefix);
      
      // Status IONIC
      list.addElement(new DataElement("Status",Type.LABEL_IONIC_STATUS_STRING, 
                                         channelPrefix + IONIC_CHANNELS.get("Status" + attributes[1])));
      // Status Comm
      list.addElement(new DataElement("StatusComm",Type.LABEL_IONIC_COMM_STATUS_STRING, 
                                         channelPrefix + IONIC_CHANNELS.get("StatusComm" + attributes[1])));
      // Status Error
      list.addElement(new DataElement("StatusError",Type.LABEL_IONIC_STATUS_ERROR_STRING, 
                                         channelPrefix + IONIC_CHANNELS.get("StatusError" + attributes[1])));
      // Operating Mode
      list.addElement(new DataElement("OperatingMode",Type.LABEL_IONIC_OPERATING_MODE_STRING, 
                                         channelPrefix + IONIC_CHANNELS.get("OperatingMode" + attributes[1])));
      // Voltage Mode
      list.addElement(new DataElement("VoltageMode",Type.LABEL_IONIC_VOLTAGE_MODE_STRING,
                                         channelPrefix + IONIC_CHANNELS.get("VoltageMode" + attributes[1])));
      // Protect Current
      list.addElement(new DataElement("ProtectCurrent",Type.LABEL_VALUE_STRING,
                                         channelPrefix + IONIC_CHANNELS.get("ProtectCurrent" + attributes[1]),"mA"));
      // Pressure
      list.addElement(new DataElement("Pressure",Type.LABEL_VALUE_STRING,
                                         channelPrefix + IONIC_CHANNELS.get("Pressure" + attributes[1]),"Torr"));
      // Absorbed Current
      list.addElement(new DataElement("AbsorbedCurrent",Type.LABEL_VALUE_STRING,
                                         channelPrefix + IONIC_CHANNELS.get("AbsorbedCurrent" + attributes[1]),"Amp"));
      // Absorbed Voltage
      list.addElement(new DataElement("AbsorbedVoltage",Type.LABEL_VALUE_STRING,
                                         channelPrefix + IONIC_CHANNELS.get("AbsorbedVoltage" + attributes[1]),"Volt"));
      // Max Current
      list.addElement(new DataElement("MaxCurrent",Type.LABEL_VALUE_STRING,
                                         channelPrefix + IONIC_CHANNELS.get("MaxCurrent" + attributes[1]),"mA"));
      // Max Voltage
      list.addElement(new DataElement("MaxVoltage",Type.LABEL_VALUE_STRING,
                                         channelPrefix + IONIC_CHANNELS.get("MaxVoltage" + attributes[1]),"Volt"));
      // Max Power
      list.addElement(new DataElement("MaxPower",Type.LABEL_VALUE_STRING,
                                         channelPrefix + IONIC_CHANNELS.get("MaxPower" + attributes[1]),"Watt"));
      // First Step Voltage
      list.addElement(new DataElement("FirstStepVoltage",Type.LABEL_VALUE_STRING,
                                         channelPrefix + IONIC_CHANNELS.get("FirstStepVoltage" + attributes[1]),"Volt"));
      // Second Step Voltage
      list.addElement(new DataElement("SecondStepVoltage",Type.LABEL_VALUE_STRING,
                                         channelPrefix + IONIC_CHANNELS.get("SecondStepVoltage" + attributes[1]),"Volt"));
      // First Step Current
      list.addElement(new DataElement("FirstStepCurrent",Type.LABEL_VALUE_STRING,
                                         channelPrefix + IONIC_CHANNELS.get("FirstStepCurrent" + attributes[1]),"Amp"));
      // Second Step Current
      list.addElement(new DataElement("SecondStepCurrent",Type.LABEL_VALUE_STRING,
                                         channelPrefix + IONIC_CHANNELS.get("SecondStepCurrent" + attributes[1]),"Amp"));
      
      // Init
      Init();
   }
}




