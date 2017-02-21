package com.commerce.almacenDAO;

import java.util.ArrayList;
import java.util.List;

import com.commerce.interfaceAlmacen.InterfazAlmacen;
import com.commerce.modelo.Almacen;



public class AlmacenDAO implements InterfazAlmacen  {

	@Override
	public List<Almacen> getStoresByIdCompany(long idCompany) {
		// TODO Auto-generated method stub
		
		List<Almacen> almacen=new ArrayList<Almacen>();
		
		for(int i=0;i<100;i++){
			almacen.add(new Almacen("Nombre"+i,"id"));
		}
		
		
		return almacen;
	}
	
}
