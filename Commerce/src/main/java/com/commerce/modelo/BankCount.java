package com.commerce.modelo;



import java.util.ArrayList;
import java.util.List;

public class BankCount {
		
	
	private long idBd;
	private String codeAccount;
	private String bankEntity;
	private Double currentBalance;
	
	private Movimiento[] listMovimientos;
	

	private int index=0;
		
	
	public BankCount(long idB,String codeCount,String bankEntity,Double currentBalance){
		//chekqueamos
		this.codeAccount =codeCount;
		this.bankEntity = bankEntity;
		this.currentBalance = currentBalance;
		listMovimientos = new Movimiento[20];
		this.idBd=idB;
	}
	
	public BankCount(){
		codeAccount="";
		bankEntity="";
		currentBalance=3.0;
		listMovimientos = new Movimiento[20];
		idBd=0;
	}
	
	
	public String getCodeAccount() {
		return codeAccount;
	}

	public void setCodeAccount(String codeAccount) {
		this.codeAccount = codeAccount;
	}


	public String getBankEntity() {
		return bankEntity;
	}


	public void setBankEntity(String bankEntity) {
		this.bankEntity = bankEntity;
	}


	public Double getCurrentBalance() {
		return currentBalance;
	}


	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}
	
	public void addMovimiento(Movimiento mov){
		if(mov!=null){
			listMovimientos[index]=mov;
			index++;
		}
	}
	
	public Movimiento[] getListMovimientos() {
		return listMovimientos;
	}

	public void setListMovimientos(Movimiento[] listMovimientos) {
		this.listMovimientos = listMovimientos;
	}
	
	public long getIdBd() {
		return idBd;
	}

	public void setIdBd(long idBd) {
		this.idBd = idBd;
	}
	
}
