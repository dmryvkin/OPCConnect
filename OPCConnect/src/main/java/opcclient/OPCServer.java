package opcclient;

import java.util.ArrayList;
import java.util.List;

import com.sun.jna.Pointer;

public class OPCServer extends OPCWrapperObject {

	
	private List<OPCGroup> groups;
	
	public OPCServer() {
		
		groups = new ArrayList<OPCGroup>(); 
		
	}

	
public OPCGroup CreateGroup(String groupName) throws OPCException{
		
		OPCGroup group = new OPCGroup();
		
		Pointer pointerToGroupObject =  OPCClientWrapperInterface.INSTANCE.GetOPCGroup(this.getPointer(), groupName);
		
		if(pointerToGroupObject == Pointer.NULL)

			throw new OPCException(String.format("%s %s", OPCClientProperites.GROUP_ERROR_MESSAGE,groupName));
		
				
		group.setPointer(pointerToGroupObject);
		
		groups.add(group);
		
		return group;
	}

	public void  dispose(){
	
		for( OPCGroup g : groups){
			
			g.dispose();
		}
		

		super.dispose();
		
	}


	
}
