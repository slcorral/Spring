package InterfazProveedor;

import Modelo.Proveedor;
import Modelo.Excepciones.LogicException;

public interface InterfaceProveedor {
	
	public  Proveedor getProviderById(long providerId)throws LogicException;
	public long addProvider(Proveedor provider) throws LogicException;
	
}
