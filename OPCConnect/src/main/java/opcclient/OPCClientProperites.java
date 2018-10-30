package opcclient;

import java.util.ResourceBundle;

public class OPCClientProperites {

	
		
	public static final String OS_ERROR_MESSAGE = GetResourceString("OS_ERROR");
	public static final String HOST_ERROR_MESSAGE = GetResourceString("HOST_ERROR");
	public static final String SERVER_ERROR_MESSAGE = GetResourceString("SERVER_ERROR");
	public static final String GROUP_ERROR_MESSAGE = GetResourceString("GROUP_ERROR");
	public static final String ITEM_ERROR_MESSAGE = GetResourceString("ITEM_ERROR");
	public static final String DATA_READ_ERROR_MESSAGE = GetResourceString("DATA_READ_ERROR");
	
	public static String GetResourceString(String resName){

		ResourceBundle res = ResourceBundle.getBundle("opcclient");
		return res.getString(resName);
    	   	
    	
		
	}
	
				
	

}
