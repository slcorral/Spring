package InterfaceAccount;

import java.util.List;

import Modelo.Bank.BankAccount;
import Modelo.Excepciones.LogicException;

public interface InterfaceAccount {
	
	public BankAccount getAccountByIdAccount(long idAccount) throws LogicException;
	public List<BankAccount> getAccountsByIdProvider(long idProvider) throws LogicException;
	
}
