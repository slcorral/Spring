package Modelo.Bank;

import java.util.ArrayList;
import java.util.List;

import Modelo.Movimiento;

public class BankAccount {
	
	public enum State{
		ABIERTO,CERRADO,PENDIENTE,BLOQUEADA,EMBARGADA,PENDIENTE_SALDO
	}
	
	public long idBd;
	public String account;
	public Owner firstOwner;
	public List<Owner> listOwner;
	public Entity entity;
	public String office;
	public String street;
	public State state;
	public double saldo;
	public List<Movimiento> listMovimientos;

	public BankAccount(){
		account="";
		firstOwner= new Owner();
		listOwner=new ArrayList<Owner>();
		entity=new Entity();
		office="";
		street="";
		state=State.ABIERTO;
		saldo=0.0;
		listMovimientos= new ArrayList<Movimiento>();
	}
	
	
	public void AddOwner(Owner owner){
		listOwner.add(owner);
	}
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	
	public Owner getFirstOwner() {
		return firstOwner;
	}

	public void setFirstOwner(Owner firstOwner) {
		this.firstOwner = firstOwner;
	}

	public List<Owner> getListOwner() {
		return listOwner;
	}

	public void setListOwner(List<Owner> listOwner) {
		this.listOwner = listOwner;
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}


	public Double getAmountDisponible() {
		return saldo;
	}

	public void setAmount(Double amount) {
		this.saldo = amount;
	}

	public List<Movimiento> getListMovimientos() {
		return listMovimientos;
	}

	public void setListMovimientos(List<Movimiento> listMovimientos) {
		this.listMovimientos = listMovimientos;
	}
	
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public long getIdBd() {
		return idBd;
	}


	public void setIdBd(long idBd) {
		this.idBd = idBd;
	}

	
}
