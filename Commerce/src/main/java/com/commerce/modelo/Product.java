package com.commerce.modelo;



public class Product {
	
	
	private String name;
	private String code;
	private String cantidad;
	private String norma;
	
	public Product(){
		name="nombre";
		code="codigo";
		cantidad="cantidad";
		norma="norma";
	}
	
	public String toString(){
		
		StringBuilder result=new StringBuilder();
			
		result.append("Nombre "+ name);
		result.append("Code " + code);
		result.append("Cantidad "+ cantidad);
		result.append("Norma "+ norma);
		
		return result.toString();
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getCantidad() {
		return cantidad;
	}


	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}


	public String getNorma() {
		return norma;
	}


	public void setNorma(String norma) {
		this.norma = norma;
	}
	
	
	
}
