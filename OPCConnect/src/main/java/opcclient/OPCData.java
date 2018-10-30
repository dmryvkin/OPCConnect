package opcclient;

import java.util.Date;

import com.sun.jna.platform.win32.Variant.VARIANT;
import com.sun.jna.platform.win32.WinBase.FILETIME;


public class OPCData  extends OPCWrapperObject{

	public OPCData() {
		
	}
	
	
	
	public VARIANT getValue(){
		
		VARIANT value =  new VARIANT( OPCClientWrapperInterface.INSTANCE.GetDataValue(getPointer()));
		
		
		return value;
		
	}
	
	
	public int getQuality()
	{
		
	  return OPCClientWrapperInterface.INSTANCE.GetDataQuality(getPointer());
	}
	
	
    public Date getDate(){
    	
    	FILETIME timeStamp = new FILETIME( OPCClientWrapperInterface.INSTANCE.GetDataTime(getPointer()));
    	
    	return timeStamp.toDate();
    	
    }
	
	

}
