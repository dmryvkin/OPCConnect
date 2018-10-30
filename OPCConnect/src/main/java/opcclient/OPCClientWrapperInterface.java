package opcclient;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

public interface OPCClientWrapperInterface extends Library {
    OPCClientWrapperInterface INSTANCE = (OPCClientWrapperInterface) Native.load("OPCWrapper", OPCClientWrapperInterface.class);
       
   
    void    OPCInit();

    Pointer GetHost(String hostName);

    Pointer GetOPCServer(Pointer host, String serverName);

    long GetServerState(Pointer server);

    Pointer GetOPCGroup(Pointer opcServer, String groupName);

    Pointer GetOPCItem(Pointer opcGroup, String itemName);

    Pointer ReadItemDataSync(Pointer item);

    Pointer GetDataValue(Pointer data);

    int     GetDataQuality(Pointer data);

    Pointer GetDataTime(Pointer data);

    void    Delete(Pointer p);

}