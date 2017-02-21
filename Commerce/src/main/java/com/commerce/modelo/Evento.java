package com.commerce.modelo;



import java.util.ArrayList;
import java.util.List;

public class Evento {
	
	public int idBd;
	public int hInic;
	public int minutInic;
	public int secondInic;
	public int hFin;
	public int minutFin;
	public int secondFin;
	public String nombre;
	public String descripcion;
	public List<Asistente> listAsistentes;
	
	
	

	public Evento(int hInic,int minutInic,int secondInic,int hFin,int minutFin,int secondFin, int idBd,String nombre,String descripcion){
		this.hInic=hInic;
		this.minutInic=minutInic;
		this.secondInic=secondInic;
		this.hFin=hFin;
		this.minutFin=minutFin;
		this.secondFin=secondFin;
		this.idBd=idBd;
		this.nombre=nombre;
		this.descripcion=nombre;
		listAsistentes= new ArrayList<Asistente>();
		
	}
	
	
	public Evento(){
		hInic=0;
		minutInic=0;
		secondInic=0;
		hFin=0;
		minutFin=0;
		secondFin=0;
		idBd=0;
		nombre="";
		descripcion="";
		listAsistentes= new ArrayList<Asistente>();
	}
	
	
	public void addAsistentes(Asistente asistente){
		if(asistente!=null){
			listAsistentes.add(asistente);
		}
	}
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public int getIdBd() {
		return idBd;
	}


	public void setIdBd(int idBd) {
		this.idBd = idBd;
	}
	
	
	public int gethInic() {
		return hInic;
	}


	public void sethInic(int hInic) {
		this.hInic = hInic;
	}


	public int gethFin() {
		return hFin;
	}


	public void sethFin(int hFin) {
		this.hFin = hFin;
	}
	
	
	public int getMinutInic() {
		return minutInic;
	}


	public void setMinutInic(int minutInic) {
		this.minutInic = minutInic;
	}


	public int getSecondInic() {
		return secondInic;
	}


	public void setSecondInic(int secondInic) {
		this.secondInic = secondInic;
	}


	public int getMinutFin() {
		return minutFin;
	}


	public void setMinutFin(int minutFin) {
		this.minutFin = minutFin;
	}


	public int getSecondFin() {
		return secondFin;
	}


	public void setSecondFin(int secondFin) {
		this.secondFin = secondFin;
	}
	
	public List<Asistente> getListAsistentes() {
		return listAsistentes;
	}

	
	public void setListAsistentes(List<Asistente> listAsistentes) {
		this.listAsistentes = listAsistentes;
	}

}
