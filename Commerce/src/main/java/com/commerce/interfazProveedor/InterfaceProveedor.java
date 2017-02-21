package com.commerce.interfazProveedor;

import com.commerce.modelo.Proveedor;
import com.commerce.modelo.exception.LogicException;

public interface InterfaceProveedor {
	
	public  Proveedor getProviderById(long providerId)throws LogicException;
	public long addProvider(Proveedor provider) throws LogicException;
	
}
