package opcclient;

import com.sun.jna.Pointer;

public class OPCItem extends OPCWrapperObject {

	
	private String  itemName; 
	
	
	public OPCItem() {
		
	}
	
	
	public OPCData ReadDataSync() throws OPCException{
		
		Pointer pData  = OPCClientWrapperInterface.INSTANCE.ReadItemDataSync(getPointer());
		
		if(pData == Pointer.NULL)
			throw new OPCException(String.format("%s %s", OPCClientProperites.DATA_READ_ERROR_MESSAGE, itemName));
		
		
		OPCData data = new OPCData();
		
		data.setPointer(pData);
		
		return data;
		
		
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	

}
