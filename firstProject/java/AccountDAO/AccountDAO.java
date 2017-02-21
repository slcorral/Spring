package AccountDAO;

import java.util.List;

import InterfaceAccount.InterfaceAccount;
import Modelo.Bank.BankAccount;
import Modelo.Bank.BankAccount.State;
import Modelo.Bank.Entity;
import Modelo.Bank.Owner;
import Modelo.Excepciones.LogicException;

public class AccountDAO implements InterfaceAccount {

	@Override
	public BankAccount getAccountByIdAccount(long idAccount)
			throws LogicException {
		// TODO Auto-generated method stub
		BankAccount bankAccount=new BankAccount();
		bankAccount.setIdBd(1);
		bankAccount.setAmount(333.0);
		bankAccount.setState(State.ABIERTO);
		bankAccount.setAccount("000001");
		Entity entidad=new Entity();
		entidad.setMainOffice("Cajamar 1");
		entidad.setHorario("Lunes a Viernes 9:00 a 15:00");
		entidad.setIdBd(1);
		entidad.setNombre("Nueva");
		entidad.setTelephone("950112233");
		entidad.setWeb("www.cajamar.es");
		bankAccount.setEntity(entidad);
		bankAccount.setSaldo(2);
		Owner owner= new Owner();
		owner.setIdBd(1);
		owner.setDNI("71717171");
		owner.setFirstName("lalala");
		owner.setFirstSurName("Ninguno");
		owner.setSecondSurName("DOs");
		owner.setStreet("Sierra");
		bankAccount.setFirstOwner(owner);
		Owner owner2= new Owner();
		owner2.setIdBd(2);
		owner2.setDNI("717171711");
		owner2.setFirstName("laasdasa");
		owner2.setFirstSurName("bbbbbbb");
		owner2.setSecondSurName("ccccc");
		owner2.setStreet("asdasd");
		bankAccount.AddOwner(owner2);
		Owner owner3= new Owner();
		owner3.setIdBd(3);
		owner3.setDNI("7171723211");
		owner3.setFirstName("aaaaaaaaaa");
		owner3.setFirstSurName("ssssssss");
		owner3.setSecondSurName("dddddddddd");
		owner3.setStreet("asdasd");
		bankAccount.AddOwner(owner3);
		return bankAccount;
	}

	@Override
	public List<BankAccount> getAccountsByIdProvider(long idProvider)
			throws LogicException {
		// TODO Auto-generated method stub
		return null;
	}

}
