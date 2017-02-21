package com.myfunctions;

import Modelo.Proveedor;
import Modelo.Bank.BankAccount;
import Modelo.Bank.BankAccount.State;

public class myFunctions {
	

	public myFunctions(){
		
	}
	
	
	/**
	 * 
	 * @param provider
	 * @return
	 */
	public static String getCss(Proveedor provider){
         if(provider.getProviderName().length()>4){
        	 return "";
         }else{
        	 return "";
         }
         
    }
	
	public static String getStateDni(BankAccount bankAccount){
		String state="";
		if(bankAccount!=null){
			if(!bankAccount.getState().equals(State.BLOQUEADA))
				 state="disabled";
			else
				state="";
		}

		return state;
	}
	
	public static String getStateNombre(BankAccount bankAccount){
		String state="";
		if(bankAccount!=null){
			if(!bankAccount.getState().equals(State.BLOQUEADA))
				state="disabled";
		}
		return state;
	}
	
	public static String getStateFirstName(BankAccount bankAccount){
		String state="";
		if(bankAccount!=null){
		  if(!bankAccount.getState().equals(State.BLOQUEADA))
				state="disabled";
		}
		return state;
	}
	
	public static String getStateFirstSurName(BankAccount bankAccount){
		String state="";
		if(bankAccount!=null){
			if(!bankAccount.getState().equals(State.BLOQUEADA))
				state="disabled";	
		}
		return state;
	}
	
	public static String getStateStreet(BankAccount bankAccount){
		String state="";
		if(bankAccount!=null){
			if(!bankAccount.getState().equals(State.BLOQUEADA))
				  state="disabled";
		}
		return state;
	}
	
	
	public static String getStateHouseNumber(BankAccount bankAccount){
		String state="";
		if(bankAccount!=null){
			if(bankAccount.getState().equals(State.BLOQUEADA)){
				state="disabled";
			}
		}
		return state;
	}
	
	
	/**
	 * 
	 * @param provider
	 * @return
	 */
	public static String getCssField(Proveedor provider){
		if(provider.getProviderStreet().length()>6){
			return "prueba de providerStreet";
		}else{
			return "validado";
		}
	}
	
}
