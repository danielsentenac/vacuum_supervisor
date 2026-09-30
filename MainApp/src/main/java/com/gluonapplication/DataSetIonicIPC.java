package com.gluonapplication;



public class DataSetIonicIPC extends DataSet {

   // Agilent IPCMini on SCADARPI racks (e.g. TUBE900N): channels VAC_<rack>_IPC_<pump><field>
   public DataSetIonicIPC(String name) {
      super();

      String[] attributes = name.split(":"); // Expect 2 attributes
      String channelPrefix = "VAC_" + attributes[0] + "_IPC_" + attributes[1];
      System.out.println("Creating DataSetIonicIPC : " + channelPrefix);

      // Status IONIC
      list.addElement(new DataElement("Status",Type.LABEL_IPC_STATUS_STRING, channelPrefix + "ST"));
      // Status Comm
      list.addElement(new DataElement("StatusComm",Type.LABEL_RACK_STATUS_STRING, channelPrefix + "COMST"));
      // Status Error
      list.addElement(new DataElement("StatusError",Type.LABEL_IPC_ERROR_STRING, channelPrefix + "ERR"));
      // Control (Remote) Mode
      list.addElement(new DataElement("RemoteMode",Type.LABEL_IPC_REMOTE_MODE_STRING, channelPrefix + "REMOTEMODE"));
      // Protect Mode
      list.addElement(new DataElement("ProtectMode",Type.LABEL_IPC_PROTECT_MODE_STRING, channelPrefix + "OPMODE"));
      // Voltage Mode
      list.addElement(new DataElement("VoltageMode",Type.LABEL_IONIC_VOLTAGE_MODE_STRING, channelPrefix + "VOLTMODE"));
      // Pressure
      list.addElement(new DataElement("Pressure",Type.LABEL_VALUE_STRING, channelPrefix + "P","mbar"));
      // Absorbed Current
      list.addElement(new DataElement("AbsorbedCurrent",Type.LABEL_VALUE_STRING, channelPrefix + "ABSCUR","A"));
      // Absorbed Voltage
      list.addElement(new DataElement("AbsorbedVoltage",Type.LABEL_VALUE_STRING, channelPrefix + "ABSVOLT","V"));
      // Protect Current
      list.addElement(new DataElement("ProtectCurrent",Type.LABEL_VALUE_STRING, channelPrefix + "PRTCUR","uA"));
      // Target Voltage
      list.addElement(new DataElement("TargetVoltage",Type.LABEL_VALUE_STRING, channelPrefix + "MAXVOLT","V"));
      // Max Power
      list.addElement(new DataElement("MaxPower",Type.LABEL_VALUE_STRING, channelPrefix + "MAXW","W"));
      // Set Point
      list.addElement(new DataElement("SetPoint",Type.LABEL_VALUE_STRING, channelPrefix + "SETPOINT","mbar"));
      // Temperature power section
      list.addElement(new DataElement("TempPower",Type.LABEL_VALUE_STRING, channelPrefix + "TEMPPWR","°C"));
      // Temperature controller
      list.addElement(new DataElement("TempController",Type.LABEL_VALUE_STRING, channelPrefix + "TEMPINT","°C"));
      // Pump type (device number)
      list.addElement(new DataElement("PumpType",Type.LABEL_IPC_PUMPTYPE_STRING, channelPrefix + "PUMPTYPE"));

      // Init
      Init();
   }
}
