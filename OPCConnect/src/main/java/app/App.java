package app;

import java.util.Date;
import java.util.ResourceBundle;

import com.sun.jna.platform.win32.Variant.VARIANT;

import opcclient.OPCClientProperites;
import opcclient.OPCConnection;
import opcclient.OPCData;
import opcclient.OPCGroup;
import opcclient.OPCItem;


public class App 
{
    public static void main( String[] args )
    {
    	try{
    	
    		System.out.println(OPCClientProperites.GetResourceString("TITLE"));
    		
    		OPCConnection connection = new OPCConnection("DMRYVKIN","Graybox.Simulator.1");
           	
    		connection.Connect();
    		
        	OPCGroup group = connection.CreateGroup("Test");
        	
        	OPCItem item =  group.CreateItem("numeric.saw.double");
        	
        	for(int i=0; i< 100; i++){
        	
	        	OPCData data = item.ReadDataSync();
	        
	        	
	            VARIANT value =  data.getValue();
	            
	            int quality = data.getQuality();
	            
	            Date date = data.getDate();
	        
	            
	            System.out.println( String.format("%f %d  %s",  value.doubleValue(), quality, date.toString())); 
	        	
	            data.dispose();
	            
	            Thread.sleep(1000);
            
            
        	}
        	
           
            connection.Close();
        		
    			
    	}
    	catch(Exception e)
    	{
          e.printStackTrace();
        
    	}
       
    }
}
