package com.gluonapplication;

import java.util.Vector;


public class DataSetGauge extends DataSet implements DataTypes {

   public DataSetGauge(String name) {
      super();

      String[] attributes = name.split(":"); // Expect 2 attributes
      String channelPrefix = "VAC_" + attributes[0];

      if ( channelPrefix.contains("TUBE") && !channelPrefix.contains("LAL")) { // TUBE (EGO) STATION
         // Pressure
         list.addElement(new DataElement("Pressure",Type.LABEL_VALUE_STRING, 
                                         channelPrefix + TUBESTATION_PRESSURE_EGO_CHANNELS.get("Pressure"+attributes[1]), "mbar"));
         // Status Pressure
         list.addElement(new DataElement("StatusPressure",Type.LABEL_MAXIGAUGE_PRESSURE_STATUS_STRING, 
                                         channelPrefix + TUBESTATION_PRESSURE_EGO_CHANNELS.get("StatusPressure"+attributes[1])));
         // Status Sensor
         list.addElement(new DataElement("StatusSensor",Type.LABEL_MAXIGAUGE_SENSOR_STATUS_STRING, 
                                         channelPrefix + TUBESTATION_PRESSURE_EGO_CHANNELS.get("StatusSensor"+attributes[1])));
         // Emission status
         list.addElement(new DataElement("StatusEmission",Type.LABEL_XGSGAUGE_EMISSION_STATUS_STRING,
                                         channelPrefix + TUBESTATION_PRESSURE_EGO_CHANNELS.get("StatusEmission"+attributes[1])));
         // Filament status
         list.addElement(new DataElement("StatusFilament",Type.LABEL_XGSGAUGE_FILAMENT_STATUS_STRING,
                                         channelPrefix + TUBESTATION_PRESSURE_EGO_CHANNELS.get("StatusFilament"+attributes[1])));
         // Degas status
         list.addElement(new DataElement("StatusDegas",Type.LABEL_XGSGAUGE_DEGAS_STATUS_STRING,
                                         channelPrefix + TUBESTATION_PRESSURE_EGO_CHANNELS.get("StatusDegas"+attributes[1])));
      }
      else if ( channelPrefix.contains("TUBE") && channelPrefix.contains("LAL")) { // TUBE (LAL) STATION
         // Pressure
         list.addElement(new DataElement("Pressure",Type.LABEL_VALUE_STRING, 
                                         channelPrefix + TUBESTATION_PRESSURE_LAL_CHANNELS.get("Pressure"+attributes[1]), "mbar"));
         // Status Pressure
         list.addElement(new DataElement("StatusPressure",Type.LABEL_MAXIGAUGE_PRESSURE_STATUS_STRING, 
                                         channelPrefix + TUBESTATION_PRESSURE_LAL_CHANNELS.get("StatusPressure"+attributes[1])));
         // Status Sensor
         list.addElement(new DataElement("StatusSensor",Type.LABEL_MAXIGAUGE_SENSOR_STATUS_STRING, 
                                         channelPrefix + TUBESTATION_PRESSURE_LAL_CHANNELS.get("StatusSensor"+attributes[1])));
         // Emission status
         list.addElement(new DataElement("StatusEmission",Type.LABEL_XGSGAUGE_EMISSION_STATUS_STRING,
                                         channelPrefix + TUBESTATION_PRESSURE_LAL_CHANNELS.get("StatusEmission"+attributes[1])));
         // Filament status
         list.addElement(new DataElement("StatusFilament",Type.LABEL_XGSGAUGE_FILAMENT_STATUS_STRING,
                                         channelPrefix + TUBESTATION_PRESSURE_LAL_CHANNELS.get("StatusFilament"+attributes[1])));
         // Degas status
         list.addElement(new DataElement("StatusDegas",Type.LABEL_XGSGAUGE_DEGAS_STATUS_STRING,
                                         channelPrefix + TUBESTATION_PRESSURE_LAL_CHANNELS.get("StatusDegas"+attributes[1])));
      }
      else if (attributes[0].contains("LINKPR")) {
         // Pressure
         list.addElement(new DataElement("Pressure",Type.LABEL_VALUE_STRING, 
                                         channelPrefix.replace("PR","") + LINKPR_PRESSURE_CHANNELS.get("Pressure"+attributes[1]), "mbar"));
         // Status Pressure
         list.addElement(new DataElement("StatusPressure",Type.LABEL_MAXIGAUGE_PRESSURE_STATUS_STRING, 
                                         channelPrefix.replace("PR","") + LINKPR_PRESSURE_CHANNELS.get("StatusPressure"+attributes[1])));
         // Status Sensor
         list.addElement(new DataElement("StatusSensor",Type.LABEL_MAXIGAUGE_SENSOR_STATUS_STRING, 
                                         channelPrefix.replace("PR","") + LINKPR_PRESSURE_CHANNELS.get("StatusSensor"+attributes[1])));
      }
      else if (attributes[0].contains("LINKSR")) {
         // Pressure
         list.addElement(new DataElement("Pressure",Type.LABEL_VALUE_STRING, 
                                         channelPrefix.replace("SR","") + LINKSR_PRESSURE_CHANNELS.get("Pressure"+attributes[1]), "mbar"));
         // Status Pressure
         list.addElement(new DataElement("StatusPressure",Type.LABEL_MAXIGAUGE_PRESSURE_STATUS_STRING, 
                                         channelPrefix.replace("SR","") + LINKSR_PRESSURE_CHANNELS.get("StatusPressure"+attributes[1])));
         // Status Sensor
         list.addElement(new DataElement("StatusSensor",Type.LABEL_MAXIGAUGE_SENSOR_STATUS_STRING, 
                                         channelPrefix.replace("SR","") + LINKSR_PRESSURE_CHANNELS.get("StatusSensor"+attributes[1])));
      }
      else if (attributes[0].equals("CRYOLINKDET")) {
         // Pressure
         list.addElement(new DataElement("Pressure",Type.LABEL_VALUE_STRING, 
                                         channelPrefix.replace("DET","_DET") + CRYOLINKDET_PRESSURE_CHANNELS.get("Pressure"+attributes[1]), "mbar"));
         // Status Pressure
         list.addElement(new DataElement("StatusPressure",Type.LABEL_MAXIGAUGE_PRESSURE_STATUS_STRING, 
                                         channelPrefix.replace("DET","_DET") + CRYOLINKDET_PRESSURE_CHANNELS.get("StatusPressure"+attributes[1])));
         // Status Sensor
         list.addElement(new DataElement("StatusSensor",Type.LABEL_MAXIGAUGE_SENSOR_STATUS_STRING, 
                                         channelPrefix.replace("DET","_DET") + CRYOLINKDET_PRESSURE_CHANNELS.get("StatusSensor"+attributes[1])));
      }
      else if (attributes[0].equals("CRYOLINKIB")) {
         // Pressure
         list.addElement(new DataElement("Pressure",Type.LABEL_VALUE_STRING, 
                                         channelPrefix.replace("IB","_IB") + CRYOLINKIB_PRESSURE_CHANNELS.get("Pressure"+attributes[1]), "mbar"));
         // Status Pressure
         list.addElement(new DataElement("StatusPressure",Type.LABEL_MAXIGAUGE_PRESSURE_STATUS_STRING, 
                                         channelPrefix.replace("IB","_IB") + CRYOLINKIB_PRESSURE_CHANNELS.get("StatusPressure"+attributes[1])));
         // Status Sensor
         list.addElement(new DataElement("StatusSensor",Type.LABEL_MAXIGAUGE_SENSOR_STATUS_STRING, 
                                         channelPrefix.replace("IB","_IB") + CRYOLINKIB_PRESSURE_CHANNELS.get("StatusSensor"+attributes[1])));
      }
      else if ( channelPrefix.contains("SQZ") ||
                channelPrefix.contains("TILTMETER")) { // SQZ TUBE & MINITOWER STATIONS & TILTMETER
         // Special case GMid
         if ( attributes[1].equals("GMid")) {
            // Pressure
            list.addElement(new DataElement("Pressure",Type.LABEL_VALUE_STRING, 
                                            "VAC_SQZ100N" + SQZ_PRESSURE_CHANNELS.get("Pressure"+attributes[1]), "mbar"));
            // Status Pressure
            list.addElement(new DataElement("StatusPressure",Type.LABEL_MAXIGAUGE_PRESSURE_STATUS_STRING, 
                                            "VAC_SQZ100N" + SQZ_PRESSURE_CHANNELS.get("StatusPressure"+attributes[1])));
            // Status Sensor
            list.addElement(new DataElement("StatusSensor",Type.LABEL_MAXIGAUGE_SENSOR_STATUS_STRING, 
                                            "VAC_SQZ100N" + SQZ_PRESSURE_CHANNELS.get("StatusSensor"+attributes[1])));
         }
         else {
            // Pressure
            list.addElement(new DataElement("Pressure",Type.LABEL_VALUE_STRING, 
                                            channelPrefix + SQZ_PRESSURE_CHANNELS.get("Pressure"+attributes[1]), "mbar"));
            // Status Pressure
            list.addElement(new DataElement("StatusPressure",Type.LABEL_MAXIGAUGE_PRESSURE_STATUS_STRING, 
                                            channelPrefix + SQZ_PRESSURE_CHANNELS.get("StatusPressure"+attributes[1])));
            // Status Sensor
            list.addElement(new DataElement("StatusSensor",Type.LABEL_MAXIGAUGE_SENSOR_STATUS_STRING, 
                                            channelPrefix + SQZ_PRESSURE_CHANNELS.get("StatusSensor"+attributes[1])));
         }
      }
      else if ( channelPrefix.contains("TOWERIB") ||
                channelPrefix.contains("TOWERDET") ||
                channelPrefix.contains("TOWERMC")) { // BENCHTOWER STATIONS
         // Pressure
         list.addElement(new DataElement("Pressure",Type.LABEL_VALUE_STRING, 
                                         channelPrefix + BENCHTOWER_PRESSURE_CHANNELS.get("Pressure"+attributes[1]), "mbar"));
         // Status Pressure
         list.addElement(new DataElement("StatusPressure",Type.LABEL_MAXIGAUGE_PRESSURE_STATUS_STRING, 
                                         channelPrefix + BENCHTOWER_PRESSURE_CHANNELS.get("StatusPressure"+attributes[1])));
         // Status Sensor
         list.addElement(new DataElement("StatusSensor",Type.LABEL_MAXIGAUGE_SENSOR_STATUS_STRING, 
                                         channelPrefix + BENCHTOWER_PRESSURE_CHANNELS.get("StatusSensor"+attributes[1])));
         // Status ITR Sensor
         list.addElement(new DataElement("StatusITRSensor",Type.LABEL_ITRGAUGE_SENSOR_STATUS_STRING,
                                         channelPrefix + BENCHTOWER_PRESSURE_CHANNELS.get("StatusITRSensor"+attributes[1])));
         // Emission status
         list.addElement(new DataElement("StatusEmission",Type.LABEL_ITRGAUGE_EMISSION_STATUS_STRING,
                                         channelPrefix + BENCHTOWER_PRESSURE_CHANNELS.get("StatusEmission"+attributes[1])));
         // Degas status
         list.addElement(new DataElement("StatusDegas",Type.LABEL_ITRGAUGE_DEGAS_STATUS_STRING,
                                         channelPrefix + BENCHTOWER_PRESSURE_CHANNELS.get("StatusDegas"+attributes[1])));
         
      }
      else if ( channelPrefix.contains("TOWER") ) { // TOWER STATION
         // Pressure
         list.addElement(new DataElement("Pressure",Type.LABEL_VALUE_STRING, 
                                         channelPrefix + TOWER_PRESSURE_CHANNELS.get("Pressure"+attributes[1]), "mbar"));
         // Status Pressure
         list.addElement(new DataElement("StatusPressure",Type.LABEL_MAXIGAUGE_PRESSURE_STATUS_STRING, 
                                         channelPrefix + TOWER_PRESSURE_CHANNELS.get("StatusPressure"+attributes[1])));
         // Status Sensor
         list.addElement(new DataElement("StatusSensor",Type.LABEL_MAXIGAUGE_SENSOR_STATUS_STRING, 
                                         channelPrefix + TOWER_PRESSURE_CHANNELS.get("StatusSensor"+attributes[1])));
         // Status ITR Sensor
         list.addElement(new DataElement("StatusITRSensor",Type.LABEL_ITRGAUGE_SENSOR_STATUS_STRING,
                                         channelPrefix + TOWER_PRESSURE_CHANNELS.get("StatusITRSensor"+attributes[1])));
         // Emission status
         list.addElement(new DataElement("StatusEmission",Type.LABEL_ITRGAUGE_EMISSION_STATUS_STRING,
                                         channelPrefix + TOWER_PRESSURE_CHANNELS.get("StatusEmission"+attributes[1])));
         // Degas status
         list.addElement(new DataElement("StatusDegas",Type.LABEL_ITRGAUGE_DEGAS_STATUS_STRING,
                                         channelPrefix + TOWER_PRESSURE_CHANNELS.get("StatusDegas"+attributes[1])));
         
      }
      else if ( channelPrefix.contains("CRYO") && !channelPrefix.contains("LINK")) { // CRYO (NIKHEF) STATION
         // Pressure
         list.addElement(new DataElement("Pressure",Type.LABEL_VALUE_STRING, 
                                         channelPrefix + CRYO_PRESSURE_CHANNELS.get("Pressure"+attributes[1]), "mbar"));
         // Status Pressure
         list.addElement(new DataElement("StatusPressure",Type.LABEL_MAXIGAUGE_PRESSURE_STATUS_STRING, 
                                         channelPrefix + CRYO_PRESSURE_CHANNELS.get("StatusPressure"+attributes[1])));
         // Status Sensor
         list.addElement(new DataElement("StatusSensor",Type.LABEL_MAXIGAUGE_SENSOR_STATUS_STRING, 
                                         channelPrefix + CRYO_PRESSURE_CHANNELS.get("StatusSensor"+attributes[1])));         
      }
      else if ( channelPrefix.contains("REMOTESCROLL")) { // REMOTE PUMPS
         // Pressure
         list.addElement(new DataElement("Pressure",Type.LABEL_VALUE_STRING, 
                                         channelPrefix + REMOTEPUMPS_PRESSURE_CHANNELS.get("Pressure"+attributes[1]), "mbar"));
         // Status Pressure
         list.addElement(new DataElement("StatusPressure",Type.LABEL_MAXIGAUGE_PRESSURE_STATUS_STRING, 
                                         channelPrefix + REMOTEPUMPS_PRESSURE_CHANNELS.get("StatusPressure"+attributes[1])));
         // Status Sensor
         list.addElement(new DataElement("StatusSensor",Type.LABEL_MAXIGAUGE_SENSOR_STATUS_STRING, 
                                         channelPrefix + REMOTEPUMPS_PRESSURE_CHANNELS.get("StatusSensor"+attributes[1])));         
      }
      System.out.println("Attribute:" + attributes[1]);
      // Init
      Init();
   }
}




