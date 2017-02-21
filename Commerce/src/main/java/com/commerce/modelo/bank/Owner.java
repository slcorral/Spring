package com.commerce.modelo.bank;


public class Owner {
	
	private long idBd;
	private String firstName;
	private String firstSurName;
	private String secondSurName;
	private String DNI;
	private String street;
	private String houseNumber;
	
	public Owner(){
		firstName="";
		firstSurName="";
		secondSurName="";
		DNI="";
		street="";
		houseNumber="";
		idBd=0;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getFirstSurName() {
		return firstSurName;
	}



	public void setFirstSurName(String firstSurName) {
		this.firstSurName = firstSurName;
	}



	public String getSecondSurName() {
		return secondSurName;
	}



	public void setSecondSurName(String secondSurName) {
		this.secondSurName = secondSurName;
	}



	public String getDNI() {
		return DNI;
	}



	public void setDNI(String dNI) {
		DNI = dNI;
	}



	public String getStreet() {
		return street;
	}



	public void setStreet(String street) {
		this.street = street;
	}



	public String getHouseNumber() {
		return houseNumber;
	}



	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	public long getIdBd() {
		return idBd;
	}


	public void setIdBd(long idBd) {
		this.idBd = idBd;
	}


}
