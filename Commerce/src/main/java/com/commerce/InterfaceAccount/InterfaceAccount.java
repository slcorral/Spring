package com.commerce.InterfaceAccount;

import java.util.List;

import com.commerce.modelo.bank.BankAccount;
import com.commerce.modelo.exception.LogicException;


public interface InterfaceAccount {
	
	public BankAccount getAccountByIdAccount(long idAccount) throws LogicException;
	public List<BankAccount> getAccountsByIdProvider(long idProvider) throws LogicException;
	
}
