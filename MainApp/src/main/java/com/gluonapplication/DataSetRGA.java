package com.gluonapplication;

import java.util.Vector;


public class DataSetRGA extends DataSet {

   public DataSetRGA(String name) {
      super();

      String[] attributes = name.split(":"); // Expect 2 attributes
      System.out.println("Creating DataSetRGA : " + name);
      // RGA Data
      if (name.contains("1500") && attributes[1].equals("Ge4") ) {
          for ( int i = 1; i <= 50; ++i ) {
             if ( i < 10 )
	        list.addElement(new DataElement(Integer.toString(i),Type.RGA_2_CHART_DATA,"VAC_" + attributes[0] + "_RGA" + attributes[1] + "_00" + i,""));
	     else if ( i < 100 )
                list.addElement(new DataElement(Integer.toString(i),Type.RGA_2_CHART_DATA,"VAC_" + attributes[0] + "_RGA" + attributes[1] + "_0" + i,""));
             else
                list.addElement(new DataElement(Integer.toString(i),Type.RGA_2_CHART_DATA,"VAC_" + attributes[0] + "_RGA" + attributes[1] + "_" + i,""));
             //System.out.println("Creating DataSetRGA element : " + "VAC_" + attributes[0] + "_RGA" + attributes[1] + "_%%" + i);
          }
          
      }
      else if (name.contains("1500") && attributes[1].equals("Gc4") ) {
          for ( int i = 1; i <= 300; ++i ) {
             if ( i < 10 )
	        list.addElement(new DataElement(Integer.toString(i),Type.RGA_2_CHART_DATA,"VAC_" + attributes[0] + "_RGA" + attributes[1] + "_00" + i,""));
	     else if ( i < 100 )
                list.addElement(new DataElement(Integer.toString(i),Type.RGA_2_CHART_DATA,"VAC_" + attributes[0] + "_RGA" + attributes[1] + "_0" + i,""));
             else
                list.addElement(new DataElement(Integer.toString(i),Type.RGA_2_CHART_DATA,"VAC_" + attributes[0] + "_RGA" + attributes[1] + "_" + i,""));
             //System.out.println("Creating DataSetRGA element : " + "VAC_" + attributes[0] + "_RGA" + attributes[1] + "_%%" + i);
          }
          
      }
      else if (name.contains("LINKPR")) {
         for ( int i = 1; i <= 200; ++i ) {
            if ( i < 10 )
	       list.addElement(new DataElement(Integer.toString(i),Type.RGA_CHART_DATA,"VAC_LINK_PR_RGA" + attributes[1] + "_00" + i,""));
	    else if ( i < 100 )
               list.addElement(new DataElement(Integer.toString(i),Type.RGA_CHART_DATA,"VAC_LINK_PR_RGA" + attributes[1] + "_0" + i,""));
            else
               list.addElement(new DataElement(Integer.toString(i),Type.RGA_CHART_DATA,"VAC_LINK_PR_RGA" + attributes[1] + "_" + i,""));
            //System.out.println("Creating DataSetRGA element : " + "VAC_" + attributes[0] + "_RGA" + attributes[1] + "_%%" + i);
         }
      }
      else if (name.contains("LINKDET")) {
         for ( int i = 1; i <= 200; ++i ) {
            if ( i < 10 )
	       list.addElement(new DataElement(Integer.toString(i),Type.RGA_CHART_DATA,"VAC_LINK_DET_RGA" + attributes[1] + "_00" + i,""));
	    else if ( i < 100 )
               list.addElement(new DataElement(Integer.toString(i),Type.RGA_CHART_DATA,"VAC_LINK_DET_RGA" + attributes[1] + "_0" + i,""));
            else
               list.addElement(new DataElement(Integer.toString(i),Type.RGA_CHART_DATA,"VAC_LINK_DET_RGA" + attributes[1] + "_" + i,""));
            //System.out.println("Creating DataSetRGA element : " + "VAC_" + attributes[0] + "_RGA" + attributes[1] + "_%%" + i);
         }
      }
      else {
         for ( int i = 1; i <= 200; ++i ) {
            if ( i < 10 )
	       list.addElement(new DataElement(Integer.toString(i),Type.RGA_CHART_DATA,"VAC_" + attributes[0] + "_RGA" + attributes[1] + "_00" + i,""));
	    else if ( i < 100 )
               list.addElement(new DataElement(Integer.toString(i),Type.RGA_CHART_DATA,"VAC_" + attributes[0] + "_RGA" + attributes[1] + "_0" + i,""));
            else
               list.addElement(new DataElement(Integer.toString(i),Type.RGA_CHART_DATA,"VAC_" + attributes[0] + "_RGA" + attributes[1] + "_" + i,""));
            //System.out.println("Creating DataSetRGA element : " + "VAC_" + attributes[0] + "_RGA" + attributes[1] + "_%%" + i);
         }
      }
      // Init
      Init();
   }
}




