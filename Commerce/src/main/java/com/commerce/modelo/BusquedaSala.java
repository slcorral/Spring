package com.commerce.modelo;



public class BusquedaSala {

	
	public boolean monitor;
	public boolean conferencia;
	public boolean traductor;
	public boolean traductor2;
	public int capacidad;
	public int planta;
	
	
	public BusquedaSala(){
		this.monitor=false;
		this.conferencia=false;
		this.traductor=false;
		this.traductor2=false;
		capacidad=0;
		planta=0;
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
	
	
}
