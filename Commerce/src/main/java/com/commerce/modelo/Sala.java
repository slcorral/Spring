package com.commerce.modelo;


public class Sala {
	
	private String nombre;
	private int capacidad;
	private int planta;
	private boolean monitor;
	private boolean conferencia;
	private boolean traductor;
	private boolean traductor2;
	private int numSala;
	private int idBd;

	public Sala(){
		this.nombre="";
		this.capacidad=0;
		this.planta=0;
		this.monitor=false;
		this.conferencia=false;
		this.traductor=false;
		this.traductor2=false;
		this.numSala=0;
		this.idBd=0;
	}
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCapacidad() {
		return capacidad;
	}


	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}


	public int getPlanta() {
		return planta;
	}


	public void setPlanta(int planta) {
		this.planta = planta;
	}


	public boolean isMonitor() {
		return monitor;
	}


	public void setMonitor(boolean monitor) {
		this.monitor = monitor;
	}


	public boolean isConferencia() {
		return conferencia;
	}


	public void setConferencia(boolean conferencia) {
		this.conferencia = conferencia;
	}


	public boolean isTraductor() {
		return traductor;
	}


	public void setTraductor(boolean traductor) {
		this.traductor = traductor;
	}


	public boolean isTraductor2() {
		return traductor2;
	}


	public void setTraductor2(boolean traductor2) {
		this.traductor2 = traductor2;
	}
	
	public int getNumSala() {
		return numSala;
	}

	public void setNumSala(int numSala) {
		this.numSala = numSala;
	}
	
	public int getIdBd() {
		return idBd;
	}

	public void setIdBd(int idBd) {
		this.idBd = idBd;
	}

	
}
