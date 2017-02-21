package com.commerce.interfaceAlmacen;

import java.util.List;

import com.commerce.modelo.Almacen;

public interface InterfazAlmacen {
	
	/**
	 * gets all store associate to the company.
	 * @param idCompany
	 * @return
	 */
	public List<Almacen> getStoresByIdCompany(long idCompany);
	
}
