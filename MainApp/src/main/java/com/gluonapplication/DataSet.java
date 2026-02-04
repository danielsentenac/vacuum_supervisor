package com.gluonapplication;

import java.util.Vector;
import java.lang.Cloneable;



public class DataSet implements DataTypes, Cloneable {

   Vector<DataElement> list;
   Vector<String> svrNameList;
   Vector<String> svrUnitsList;
   Vector<String> svrValueList;

   public DataSet() {
      list = new Vector<DataElement>();
      svrNameList = new Vector<String>();
      svrUnitsList = new Vector<String>();
      svrValueList = new Vector<String>();      
   }

   public void Init() {
      for (DataElement v : list ) {
         if (v.svrName != null) {
            svrNameList.addElement(v.svrName);
            svrUnitsList.addElement(v.svrUnits);
         }
         else {
            System.out.println("!!!!!!!!!!!!!!!!!!!WARNING NULL CHANNEL DETECTED for " + v.name);
            svrNameList.addElement("---"); // IMPORTANT TO KEEP THE SAME SIZE WITH svrValueList and data vectors
            svrUnitsList.addElement("---"); // IMPORTANT TO KEEP THE SAME SIZE WITH svrValueList and data vectors
         }
      }
   }

   @Override
   public DataSet clone() throws CloneNotSupportedException {
                return (DataSet) super.clone();
   }
  
   public DataElement getDataElement(String name) {
      DataElement dataElement = null;
      for (DataElement v : list ) {
         if (v.name.equals(name)) {
            dataElement = v;
            break;
         }
      }
      return dataElement;
   }
}




