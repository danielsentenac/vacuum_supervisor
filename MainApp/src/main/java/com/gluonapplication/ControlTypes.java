package com.gluonapplication;

import java.util.Hashtable;

public interface ControlTypes {

   public enum Type {
     
   }

   String DECORATION_STYLE_PUSHED = " -fx-border-color: #cfcfcf; -fx-border-width: 1; -fx-border-radius: 5; -fx-text-fill: black; -fx-background-radius: 5; -fx-background-color: #cfcfcf; -fx-opacity: 0.5";

   Hashtable<String, String> VALVE_COMMAND_CHANNELS = new Hashtable<String, String>(){{ 
      // TUBESTATION
      put("Va1", "_VA1CMD");
      put("Va2", "_VA2CMD");
      put("V21", "_V21CMD");
      put("V22", "_V22CMD"); // CRYO IDENTICAL
      put("V23", "_V23CMD"); // CRYO IDENTICAL
      put("V31", "_V31CMD");
      put("V32", "_V32CMD");
      put("V91", "_V91CMD");
      put("V11", "_V11CMD");
      put("V25", "_V25CMD");
      // TOWER
      put("Vc1", "_Vc1CMD");
      put("Vc2", "_Vc2CMD");
      put("Vd1", "_Vd1CMD");
      put("Vd2", "_Vd2CMD");
      put("V31", "_V31CMD");
      put("V41", "_V41CMD");
      put("V42", "_V42CMD");
      put("V43", "_V43CMD");
      put("V51", "_V51CMD");
      put("V52", "_V52CMD");
      put("V53", "_V53CMD");
      put("V54", "_V54CMD");
      put("V71", "_V71CMD");
      put("V72", "_V72CMD");
      put("V73", "_V73CMD");
      put("V74", "_V74CMD");
      put("V75", "_V75CMD");
      put("V81", "_V81CMD");
      put("V82", "_V82CMD");
      put("V91", "_V91CMD");
      put("V92", "_V92CMD");
      // SQZ MINITOWER
      put("VP","_VPCMD");
      put("Vrem","_VSPARECMD");
      put("V24","_V24CMD");
      put("V25","_V25CMD");
      // CRYO
      put("V1", "_V1CMD"); // REMOTEPUMPS IDENTICAL
      put("VCryo", "_VCRYOCMD");
      put("Ve1", "_VE1CMD");
      put("Ve2", "_VE2CMD");
      put("V31i", "_V31ICMD");
      put("V32i", "_V32ICMD");
      put("V31e", "_V31ECMD");
      put("V32e", "_V32ECMD");
      // REMOTEPUMPS
      put("V2", "_V2CMD");
      put("Vs1", "_VS1CMD");
      put("Vs2", "_VS2CMD");
      put("Vs3", "_VS3CMD");
      put("Vdt", "_VDTCMD");
      put("Vsr", "_VSRCMD");
      put("Vni", "_VNICMD");
      put("Vls", "_VLSCMD");
      put("Vb", "_VBCMD");
      put("Vmc", "_VMCCMD");
      put("Vib", "_VIBCMD");
      put("Vpr", "_VPRCMD");
      put("Vlp", "_VLPCMD");
      put("Vbs", "_VBSCMD");
      put("Vwi", "_VWICMD");
      // TUBES
      put("TUBE300N_V21","_V21CMD");
      put("TUBELAL600N_V21","_V21CMD");
      put("TUBELAL1200N_V21","_V21CMD");
      put("TUBELAL1800N_V21","_V21CMD");
      put("TUBELAL2400N_V21","_V21CMD");
      put("TUBELAL3000N_V21","_V21CMD");
      put("TUBE300W_V21","_V21CMD");
      put("TUBELAL600W_V21","_V21CMD");
      put("TUBELAL1200W_V21","_V21CMD");
      put("TUBELAL1800W_V21","_V21CMD");
      put("TUBELAL2400W_V21","_V21CMD");
      put("TUBELAL3000W_V21","_V21CMD");
      put("TUBE300N_V31","_V31CMD");
      put("TUBELAL600N_V31","_V31CMD");
      put("TUBELAL1200N_V31","_V31CMD");
      put("TUBELAL1800N_V31","_V31CMD");
      put("TUBELAL2400N_V31","_V31CMD");
      put("TUBELAL3000N_V31","_V31CMD");
      put("TUBE300W_V31","_V31CMD");
      put("TUBELAL600W_V31","_V31CMD");
      put("TUBELAL1200W_V31","_V31CMD");
      put("TUBELAL1800W_V31","_V31CMD");
      put("TUBELAL2400W_V31","_V31CMD");
      put("TUBELAL3000W_V31","_V31CMD");
      // LINKS PR & SR
      put("PRV21", "_PR_V21CMD");
      put("PRV22", "_PR_V22CMD");
      put("SRV21", "_SR_V21CMD");
      put("SRV22", "_SR_V22CMD");
      // CRYOLINKS IB & DET
      put("DETV21", "_DET_V21CMD");
      put("DETV22", "_DET_V22CMD");
      put("IBV21", "_IB_V21CMD");
      put("IBV22", "_IB_V22CMD");
      // SQZ
      put("SQZ100N_V21","_V21CMD");
      put("SQZ200N_V21","_V21CMD");
      put("SQZ0N_VP","_VPCMD");
      put("SQZ300N_VP","_VPCMD");
      put("SQZDET1_VP","_VPCMD");
      put("SQZDET2_VP","_VPCMD");
      // BIG VALVES
      put("VALVEBIGNE","_CMD");
      put("VALVEBIGNI","_CMD");
      put("VALVEBIGWE","_CMD");
      put("VALVEBIGWI","_CMD");
      // CRYO FROM MAIN PANELS
      put("CRYONE_VCRYO","_VCRYOCMD");
      put("CRYONI_VCRYO","_VCRYOCMD");
      put("CRYOWE_VCRYO","_VCRYOCMD");
      put("CRYOWI_VCRYO","_VCRYOCMD"); 
      // CRYOLINK FROM MAIN AND DETAILED PANELS
      put("CRYOLINKDET","_Z_10_DOUT"); // bit 0,1,2,3
      put("CRYOLINKIB","_Z_10_DOUT");  // bit 0,1,2,3
      // CENTRAL
      put("VALVECENTRAL_VPS","_VPSCMD");
      put("VALVECENTRAL_VSS","_VSSCMD");
      put("VALVECENTRAL_VWS","_VWSCMD");
      put("VALVECENTRAL_VNS","_VNSCMD");
      put("VALVECENTRAL_VLI","_VLICMD");
      // TANK LN2
      put("NE_LN2TANKVALVE","_LN2TANKVALVE");
      put("WE_LN2TANKVALVE","_LN2TANKVALVE");
      put("NI_LN2TANKVALVE","_LN2TANKVALVE");
      put("LN2TANKVALVE_WI","_LN2TANKVALVE_WI");      
   }};

   Hashtable<String, String> VALVE_CRYOLINK_COMMAND_CHANNELS = new Hashtable<String, String>(){{ 
      // CRYOLINK
      put("Vs1","_Z_10_DOUT"); // bit 0
      put("Vs2","_Z_10_DOUT"); // bit 1
      put("CV1","_Z_10_DOUT"); // bit 3
      put("CV2","_Z_10_DOUT"); // bit 2
   }};

   Hashtable<String,String> GAUGE_COMMAND_CHANNELS = new Hashtable<String, String>(){{
      // TUBESTATION (EGO)
      put("Ga1", "_PR3ONOFF");
      put("Ga2", "_PR5ONOFF");
      put("Ga3", "_PR4ONOFF");
      put("G21", "_PR2ONOFF");
      put("G22", "_PR1ONOFF");
      put("G31", "_PR6ONOFF");
      put("Ga4Fil1", "_PR7EMULT1ONOFF");
      put("Ga4Fil2", "_PR7EMULT2ONOFF");
      put("Ga4Degas", "_PR7DEGASONOFF");
      // CRYO
      put("CRYO_G22", "_MG1_CH1ONOFF");
      put("CRYO_G21", "_MG2_CH1ONOFF");
      put("G31e", "_MG1_CH2ONOFF");
      put("G31i", "_MG1_CH4ONOFF");
      put("Ge1", "_MG2_CH2ONOFF");
      put("Ge2", "_MG2_CH3ONOFF");
      put("Ge3", "_MG1_CH3ONOFF");
      // TOWER
      put("G41", "_MG1_CH1ONOFF");
      put("Gc1", "_MG1_CH2ONOFF");
      put("G72", "_MG1_CH3ONOFF");
      put("Gd1", "_MG1_CH4ONOFF");
      put("Gc2", "_MG1_CH5ONOFF");
      put("G51", "_MG1_CH6ONOFF");
      put("G61", "_MG2_CH1ONOFF");
      put("Gd2", "_MG2_CH2ONOFF");
      put("G31", "_MG2_CH3ONOFF");
      put("G71", "_MG2_CH4ONOFF");
      put("G81", "_MG2_CH5ONOFF");
      put("G51B", "_MG1_CH4ONOFF");  // G51 TOWER BENCH GAUGE
      put("Gc3Emult", "GC3EONOFF");
      put("Gc3Degas", "GC3DONOFF");
      put("Gd3Emult", "GD3EONOFF");
      put("Gd3Degas", "GD3DONOFF");
      // REMOTEPUMPS
      put("G1", "_MG1_CH1ONOFF");
      put("G2", "_MG1_CH2ONOFF");
      put("Gdt", "_MG1_CH3ONOFF");
      put("Gsr", "_MG1_CH4ONOFF");
      put("Gni", "_MG1_CH5ONOFF");
      put("Gs1", "_MG1_CH6ONOFF");
      put("Gni", "_MG2_CH1ONOFF");
      put("Gsl", "_MG2_CH2ONOFF");
      put("G4", "_MG2_CH3ONOFF");
      put("G5", "_MG2_CH4ONOFF");
      put("Gmc", "_MG2_CH5ONOFF");
      put("Gs2", "_MG2_CH6ONOFF");
      put("Gib", "_MG3_CH1ONOFF");
      put("Gpr", "_MG3_CH2ONOFF");
      put("Glp", "_MG3_CH3ONOFF");
      put("Gbs", "_MG3_CH4ONOFF");
      put("Gwi", "_MG3_CH5ONOFF");
   }};

   Hashtable<String,String> GAUGE_LAL_COMMAND_CHANNELS = new Hashtable<String, String>(){{
      // TUBESTATION (LAL)
      put("Ga1", "_MG1_CH4ONOFF");
      put("Ga2", "_MG1_CH5ONOFF");
      put("Ga3", "_MG1_CH6ONOFF");
      put("G21", "_MG1_CH1ONOFF");
      put("G22", "_MG1_CH2ONOFF");
      put("G31", "_MG1_CH3ONOFF");
      put("Ga4Fil1", "_Ga4FILAMENTONOFF");
      put("Ga4Fil2", "_Ga4FILAMENTONOFF");
      put("Ga4Degas", "_Ga4DEGASONOFF");
   }};

   Hashtable<String,String> GAUGE_SQZ_COMMAND_CHANNELS = new Hashtable<String, String>(){{
      // TUBE & MINITOWER SQZ
      put("Ge1", "_PR3ONOFF");
      put("Ge2", "_PR5ONOFF");
      put("Ge3", "_PR4ONOFF");
      put("Ga1", "_PR3ONOFF");
      put("Ga2", "_PR5ONOFF");
      put("Ga3", "_PR4ONOFF");
      put("G21", "_PR2ONOFF"); // SAME FOR BOTH TUBE & MINITOWER !
      put("G22", "_PR1ONOFF"); // SAME FOR BOTH TUBE & MINITOWER !
      put("GP", "_PR6ONOFF");
      put("GMid", "_PR6ONOFF"); // GMid
   }};

   Hashtable<String,String> GAUGE_LINKPR_COMMAND_CHANNELS = new Hashtable<String, String>(){{
      // LINKPR
      put("G21", "_PR3ONOFF");
      put("G22", "_PR1ONOFF");
   }};
  
   Hashtable<String,String> GAUGE_LINKSR_COMMAND_CHANNELS = new Hashtable<String, String>(){{
      // LINKSR
      put("G21", "_PR4ONOFF");
      put("G22", "_PR2ONOFF");
   }};

   Hashtable<String,String> GAUGE_CRYOLINKDET_COMMAND_CHANNELS = new Hashtable<String, String>(){{
      // LINKPR
      put("G21", "_?");
      put("G22", "_PR1ONOFF");
   }};
  
   Hashtable<String,String> GAUGE_CRYOLINKIB_COMMAND_CHANNELS = new Hashtable<String, String>(){{
      // LINKSR
      put("G21", "_?");
      put("G22", "_PR2ONOFF");
   }};

   Hashtable<String,String> SUPERVISORACTIONS_COMMAND_CHANNELS = new Hashtable<String, String>(){{
      put("EmergencyCB","VAC_SAFE_EMERGENCY_VALVE_CB");
      put("EmergencyNE","VAC_SAFE_EMERGENCY_VALVE_NE");
      put("EmergencyWE","VAC_SAFE_EMERGENCY_VALVE_WE");
      put("SafeNorthArm","VAC_SAFE_TUBE_NORTH");
      put("SafeWestArm","VAC_SAFE_TUBE_WEST");
      put("SafeCentral","VAC_SAFE_CENTRAL");
      put("SafeNorthEnd","VAC_SAFE_TOWERNE");
      put("SafeWestEnd","VAC_SAFE_TOWERWE");
      put("PrimaryPumpingBS","VAC_SAFE_PRIMARY_TOWERBS");
      put("PrimaryPumpingNI","VAC_SAFE_PRIMARY_TOWERNI");
      put("PrimaryPumpingWI","VAC_SAFE_PRIMARY_TOWERWI");
      put("PrimaryPumpingNE","VAC_SAFE_PRIMARY_TOWERNE");
      put("PrimaryPumpingWE","VAC_SAFE_PRIMARY_TOWERWE");            
      put("PrimaryPumpingPR","VAC_SAFE_PRIMARY_TOWERPR");
      put("PrimaryPumpingSR","VAC_SAFE_PRIMARY_TOWERSR");
      put("PrimaryPumpingDET","VAC_SAFE_PRIMARY_TOWERDET");
      put("PrimaryPumpingIB","VAC_SAFE_PRIMARY_TOWERIB");
      put("PrimaryPumpingMC","VAC_SAFE_PRIMARY_TOWERMC");
      put("RemotePumpingBS","VAC_SAFE_REMOTE_TOWERBS");
      put("RemotePumpingNI","VAC_SAFE_REMOTE_TOWERNI");
      put("RemotePumpingWI","VAC_SAFE_REMOTE_TOWERWI");
      put("RemotePumpingPR","VAC_SAFE_REMOTE_TOWERPR");
      put("RemotePumpingSR","VAC_SAFE_REMOTE_TOWERSR");
      put("RemotePumpingDET","VAC_SAFE_REMOTE_TOWERDET");
      put("RemotePumpingIB","VAC_SAFE_REMOTE_TOWERIB");
      put("LN2TankNI","VAC_SAFE_LN2TANKVALVE_NI");
      put("LN2TankNI_2","VAC_SAFE_LN2TANKVALVE_NI_2");
      put("LN2TankWI","VAC_SAFE_LN2TANKVALVE_WI");
      put("LN2TankWI_2","VAC_SAFE_LN2TANKVALVE_WI_2");
      put("LN2TankNE","VAC_SAFE_LN2TANKVALVE_NE");
      put("LN2TankNE_2","VAC_SAFE_LN2TANKVALVE_NE_2");
      put("LN2TankWE","VAC_SAFE_LN2TANKVALVE_WE");
      put("LN2TankWE_2","VAC_SAFE_LN2TANKVALVE_WE_2");
   }};
   
   Hashtable<String,String> CRYOACTIONS_COMMAND_CHANNELS = new Hashtable<String, String>(){{
      put("StartStop","_SWITCH_TO_OP");
      put("PIDdisable","_DISABLE_LEVELCTRL");
      put("Reset","_RESET_ERROR_INTLCK");
   }};

   Hashtable<String,String> DRY_COMMAND_CHANNELS = new Hashtable<String, String>(){{
      // TUBESTATION
      put("P22", "_P22ONOFF");
      // LINKS PR & SR
      put("PRP22", "_PR_P22ONOFF");
      put("SRP22", "_SR_P22ONOFF");
      // CRYOLINKS IB & DET
      put("DETP22", "_DET_P22ONOFF");
      put("IBP22", "_IB_P22ONOFF");
      // CRYO
      put("P1", "_P1ONOFF");
      // TOWER
      put("P41", "_P41ONOFF");
      put("P61", "_P61ONOFF");
      // REMOTEPUMPS
      put("PR1", "_PR1ONOFF");
      put("PR2", "_PR2ONOFF");
   }};

   Hashtable<String,String> TURBO_COMMAND_CHANNELS = new Hashtable<String, String>(){{ 
      // TUBE STATION
      put("P21", "_P21ONOFF");
      put("P21Sty", "_P21STYONOFF");
      // CRYO
      put("P2", "_P2ONOFF");
      put("P2Sty", "_P2STY");
      // TOWER
      put("P51", "_P51ONOFF");
      put("P51Sty", "_P51STY");
      put("P71", "_P71ONOFF");
      put("P71Sty", "_P71STY");
      // REMOTE PUMPS
      put("TP1", "_TP1ONOFF");
      put("TP1Sty", "_TP1STY");
      put("TP2", "_TP2ONOFF");
      put("TP2Sty", "_TP2STY");
      // LINK PR & SR
      put("PRP21", "_PR_P21ONOFF");
      put("PRP21Sty", "_PR_P21STYONOFF");
      put("SRP21", "_SR_P21ONOFF");
      put("SRP21Sty", "_SR_P21STYONOFF");
   }};

   Hashtable<String,String> TITANE_COMMAND_CHANNELS = new Hashtable<String, String>(){{
      // CRYO
      put("P31e", "_P31EONOFF");
      put("P31eFilamentUsed", "_P31ESELFILVAL");
      put("P31eSublimationCurrent", "_P31ESUBLCURVAL");
      put("P31eSublimationTime", "_P31ESUBLTIMEVAL");
      put("P31eSublimationPeriod", "_P31ESUBLPERVAL");
      put("P31eParam", "_P31EPARAM");
      put("P32e", "_P32EONOFF");
      put("P32eFilamentUsed", "_P32ESELFILVAL");
      put("P32eSublimationCurrent", "_P32ESUBLCURVAL");
      put("P32eSublimationTime", "_P32ESUBLTIMEVAL");
      put("P32eSublimationPeriod", "_P32ESUBLPERVAL");
      put("P32eParam", "_P32EPARAM");
      put("P31i", "_P31IONOFF");
      put("P31iFilamentUsed", "_P31ISELFILVAL");
      put("P31iSublimationCurrent", "_P31ISUBLCURVAL");
      put("P31iSublimationTime", "_P31ISUBLTIMEVAL");
      put("P31iSublimationPeriod", "_P31ISUBLPERVAL");
      put("P31iParam", "_P31IPARAM");
      put("P32i", "_P32IONOFF");
      put("P32iFilamentUsed", "_P32ISELFILVAL");
      put("P32iSublimationCurrent", "_P32ISUBLCURVAL");
      put("P32iSublimationTime", "_P32ISUBLTIMEVAL");
      put("P32iSublimationPeriod", "_P32ISUBLPERVAL");
      put("P32iParam", "_P32IPARAM");
      // TOWER
      // TUBE STATIONS
      put("P31", "_P31ONOFF");
      put("P31FilamentUsed", "_P31SELFILVAL");
      put("P31SublimationCurrent", "_P31SUBLCURVAL");
      put("P31SublimationTime", "_P31SUBLTIMEVAL");
      put("P31SublimationPeriod", "_P31SUBLPERVAL");
      put("P31Param", "_P31PARAM");
      put("P32", "_P32ONOFF");
      put("P32FilamentUsed", "_P32SELFILVAL");
      put("P32SublimationCurrent", "_P32SUBLCURVAL");
      put("P32SublimationTime", "_P32SUBLTIMEVAL");
      put("P32SublimationPeriod", "_P32SUBLPERVAL");
      put("P32Param", "_P32PARAM");
   }};

   Hashtable<String,String> IONIC_COMMAND_CHANNELS = new Hashtable<String, String>(){{
      // CRYO
      put("P33i", "_P33IONOFF");
      put("P33iOperatingMode", "_P33IOP");
      put("P33iVoltageMode", "_P33IVOLT");
      put("P33iProtectCurrent", "_P33IPRTCURRVAL");
      put("P33iMaxCurrent", "_P33IMAXCURRVAL");
      put("P33iMaxVoltage", "_P33IMAXVOLTVAL");   
      put("P33iMaxPower", "_P33IMAXWVAL"); 
      put("P33iFirstStepVoltage", "_P33I1STEPVOLTVAL"); 
      put("P33iSecondStepVoltage", "_P33I2STEPVOLTVAL"); 
      put("P33iFirstStepCurrent", "_P33I1STEPCURVAL"); 
      put("P33iSecondStepCurrent", "_P33I2STEPCURVAL"); 
      put("P33iParam", "_P33IPARAM"); 
      put("P33e", "_P33EONOFF");
      put("P33eOperatingMode", "_P33EOP");
      put("P33eVoltageMode", "_P33EVOLT");
      put("P33eProtectCurrent", "_P33EPRTCURRVAL");
      put("P33eMaxCurrent", "_P33EMAXCURRVAL");
      put("P33eMaxVoltage", "_P33EMAXVOLTVAL");
      put("P33eMaxPower", "_P33EMAXWVAL"); 
      put("P33eFirstStepVoltage", "_P33E1STEPVOLTVAL"); 
      put("P33eSecondStepVoltage", "_P33E2STEPVOLTVAL"); 
      put("P33eFirstStepCurrent", "_P33E1STEPCURVAL"); 
      put("P33eSecondStepCurrent", "_P33E2STEPCURVAL");
      put("P33eParam", "_P33EPARAM"); 

      // TOWER
      // TUBE STATIONS
      put("P33", "_P33ONOFF");
      put("P33OperatingMode", "_P33OP");
      put("P33VoltageMode", "_P33VOLT");
      put("P33ProtectCurrent", "_P33PRTCURRVAL");
      put("P33MaxCurrent", "_P33MAXCURRVAL");
      put("P33MaxVoltage", "_P33MAXVOLTVAL");   
      put("P33MaxPower", "_P33MAXWVAL"); 
      put("P33FirstStepVoltage", "_P331STEPVOLTVAL"); 
      put("P33SecondStepVoltage", "_P332STEPVOLTVAL"); 
      put("P33FirstStepCurrent", "_P331STEPCURVAL"); 
      put("P33SecondStepCurrent", "_P332STEPCURVAL"); 
      put("P33Param", "_P33PARAM");  
      put("P81", "_P81ONOFF");
      put("P81OperatingMode", "_P81OP");
      put("P81VoltageMode", "_P81VOLT");
      put("P81ProtectCurrent", "_P81PRTCURRVAL");
      put("P81MaxCurrent", "_P81MAXCURRVAL");
      put("P81MaxVoltage", "_P81MAXVOLTVAL");   
      put("P81MaxPower", "_P81MAXWVAL"); 
      put("P81FirstStepVoltage", "_P811STEPVOLTVAL"); 
      put("P81SecondStepVoltage", "_P812STEPVOLTVAL"); 
      put("P81FirstStepCurrent", "_P811STEPCURVAL"); 
      put("P81SecondStepCurrent", "_P812STEPCURVAL"); 
      put("P81Param", "_P81PARAM");  
   }};

   Hashtable<String,String> CRYOLINKACTIONS_COMMAND_CHANNELS = new Hashtable<String, String>(){{
      put("RefillMode", "_CV1");
   }};

   Hashtable<String,String> MINITOWERSQZACTIONS_COMMAND_CHANNELS = new Hashtable<String, String>(){{
      put("FanOnOff", "_RACK_FANONOFF");
      put("FanSpeed", "_RACK_FANSPEED");
      put("ByPassG22", "_M1_BYPASSONOFF");
      put("ByPassGP", "_M2_BYPASSONOFF");
      put("EmultOnOff", "_RGAGe4_EMISSIONONOFF");
      put("StartStop", "_RGAGe4_RUNNINGONOFF");
      put("Filament", "_RGAGe4_FILAMENT");
   }};

   Hashtable<String,String> LINKACTIONS_COMMAND_CHANNELS = new Hashtable<String, String>(){{
      put("FanOnOff", "_RACK_FANONOFF");
      put("FanSpeed", "_RACK_FANSPEED");
      put("ByPassRemotePR", "_PR_BYPASSONOFF");
      put("ByPassRemoteSR", "_SR_BYPASSONOFF");
   }};

   Hashtable<String,String> TUBESQZACTIONS_COMMAND_CHANNELS = new Hashtable<String, String>(){{
      put("FanOnOff", "_RACK_FANONOFF");
      put("FanSpeed", "_RACK_FANSPEED");
   }};
   
   
}

