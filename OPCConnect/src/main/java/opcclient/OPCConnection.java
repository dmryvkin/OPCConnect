package opcclient;

import com.sun.jna.Platform;


public class OPCConnection {

	
	private String hostName;
	private String serverID;
	
	private OPCHost    opcHost;
	private OPCServer  opcServer;
	
	
	public OPCConnection(String hostName, String serverID){
		
		this.hostName = hostName;
		this.serverID = serverID;
		
		
	}
	
	public void Connect() throws OPCException
	{
		
		if(!Platform.isWindows())
			throw new OPCException(OPCClientProperites.OS_ERROR_MESSAGE);
		
		OPCClientWrapperInterface.INSTANCE.OPCInit();
		
		opcHost = new OPCHost(hostName);
		opcServer = opcHost.CreateServer(serverID);
				
		
		
	}
	
	public OPCGroup CreateGroup(String groupName) throws OPCException{
		
		return opcServer.CreateGroup(groupName);
	}
	
	
	
	public void Close(){
		opcServer.dispose();
		opcHost.dispose();
		
	}
	
	
	
	
	
}
