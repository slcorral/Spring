package com.myfunctions;

import Modelo.Bank.BankAccount;
import Modelo.Bank.BankAccount.State;

public class functionBankAccount {
	
	
	public functionBankAccount(){
		
	}
	
	public static String getStateDni(BankAccount bankAccount){
		String state="";
	    if(bankAccount!=null){
	    	if(bankAccount.getState().equals(State.BLOQUEADA)){
	    	    state="disabled";
	    	}
	    }
	    return state;
	}
}
