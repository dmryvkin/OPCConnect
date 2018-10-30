package opcclient;

import java.util.ArrayList;
import java.util.List;

import com.sun.jna.Pointer;

public class OPCGroup extends OPCWrapperObject{
   
	private List<OPCItem> items;	
	
	public OPCGroup() {
				
		items = new ArrayList<OPCItem>();
		
	}
	
	public OPCItem  CreateItem(String itemName) throws OPCException
	{
		Pointer pointerToItemObject = OPCClientWrapperInterface.INSTANCE.GetOPCItem(getPointer(),itemName);
		
		if(pointerToItemObject == Pointer.NULL)
			throw new OPCException(String.format("%s %s", OPCClientProperites.ITEM_ERROR_MESSAGE, itemName));
		
	    OPCItem item = new OPCItem();
	    
	    item.setPointer(pointerToItemObject);
		
	    getItems().add(item);
	    
		return item;
	}
	
	public List<OPCItem> getItems() {
		return items;
	}



	public void dispose(){
		
		for(OPCItem i : getItems()){
			
			i.dispose();
		}
		
		
		super.dispose();
				
	}
	
	
	

}
