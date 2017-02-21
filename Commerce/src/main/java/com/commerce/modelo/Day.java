package com.commerce.modelo;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Day {

	
	public int hInic;
	public int mInic;
	public int sInic;
	
	public int hFin;
	public int mFin;
	public int sFin;
	public List<Evento> listEventos;
	
	public Day(){
		this.hInic=0;
		this.mInic=0;
		this.sInic=0;
		
		this.hFin=0;
		this.mFin=0;
		this.sFin=0;
		
		listEventos=new ArrayList<Evento>();
	}
	
	public Day(int hInic,int mInic,int sInic,int hFin,int mFin,int sFin){
		
		this.hInic=hInic;
		this.mInic=mInic;
		this.sInic=sInic;
		this.hFin=hFin;
		this.mFin=mFin;
		this.sFin=sFin;
		listEventos=new ArrayList<Evento>();
	}
	
	
	public int gethInic() {
		return hInic;
	}


	public void sethInic(int hInic) {
		this.hInic = hInic;
	}


	public int getmInic() {
		return mInic;
	}


	public void setmInic(int mInic) {
		this.mInic = mInic;
	}


	public int getsInic() {
		return sInic;
	}


	public void setsInic(int sInic) {
		this.sInic = sInic;
	}


	public int gethFin() {
		return hFin;
	}


	public void sethFin(int hFin) {
		this.hFin = hFin;
	}


	public int getmFin() {
		return mFin;
	}


	public void setmFin(int mFin) {
		this.mFin = mFin;
	}


	public int getsFin() {
		return sFin;
	}


	public void setsFin(int sFin) {
		this.sFin = sFin;
	}


	public List<Evento> getListEventos() {
		return listEventos;
	}
	
	/**
	 * Buscar un evento por la 
	 * 
	 * @param hInic
	 * 
	 * @return
	 */
	public Evento getEventByinicH(int hInic){
		Evento evento=null;
		if(listEventos!=null && hInic>=0  && hInic<hFin){
			Iterator<Evento> it;
			it=listEventos.iterator();
			boolean salir=false;
			while(it.hasNext() && salir==false){
				Evento event=it.next();
				if(event.hInic==hInic){
					evento=event;
					salir=false;
				}
			}
		}
		return evento;
	}
	
	
	public void addEvento(Evento event){
		if(event!=null){
			listEventos.add(event);
		}
	}
	

}
