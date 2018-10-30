package opcclient;

import com.sun.jna.Pointer;

public class OPCHost extends OPCWrapperObject {

	public OPCHost(String hostName) throws OPCException {
		
		Pointer pointerToHostObject = OPCClientWrapperInterface.INSTANCE.GetHost(hostName);
		
		if(pointerToHostObject == Pointer.NULL)
			throw new OPCException( String.format("%s %s", OPCClientProperites.HOST_ERROR_MESSAGE,hostName));
		
		setPointer( pointerToHostObject );
		
	}

    
	public OPCServer CreateServer(String serverID) throws OPCException{
		
		OPCServer server = new OPCServer();
		
        Pointer pointerToServerObject = OPCClientWrapperInterface.INSTANCE.GetOPCServer(getPointer(), serverID);
		
		if(pointerToServerObject == Pointer.NULL){
			
			throw new OPCException(String.format("%s %s", OPCClientProperites.SERVER_ERROR_MESSAGE, serverID));
		}
		
		server.setPointer(pointerToServerObject);
		
		return server;
		
	}

}
