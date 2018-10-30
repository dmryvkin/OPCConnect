package opcclient;

import com.sun.jna.Pointer;

public abstract class OPCWrapperObject implements PointerObject{

	
	private Pointer pointer;
	
	public OPCWrapperObject()   {
		
	}
	
	
		

	public void dispose()
	{
		OPCClientWrapperInterface.INSTANCE.Delete(getPointer());
		
		setPointer(Pointer.NULL);
		
	}




	protected Pointer getPointer() {
		return pointer;
	}




	protected void setPointer(Pointer pointer) {
		this.pointer = pointer;
	}

	

}
