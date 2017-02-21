package com.commerce.modelo;

import java.util.List;

public class Almacen {

	
	private String almacen;
	private String idStore;
	private List<Product> product;
	private String street;
	private List<Employee> listEmployee;
	
	public Almacen(String almacen,String idStore,List<Product> product){
		
			
	}
	
	public Almacen(String almacen,String idStore){
		this.almacen=almacen;
		this.idStore=idStore;
	}
	
	
}
