package com.commerce.modelo;


import java.util.Date;

public class Objeto {
	
	private Date date;
	private String nombre;

	public Objeto(){
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
