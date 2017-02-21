package ProveedorDAO;

import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;
import InterfazProveedor.InterfaceProveedor;
import Modelo.BankCount;
import Modelo.Proveedor;
import Modelo.Excepciones.LogicException;
import Objects.Error;
import Objects.MessageError;

public class ProveedorDAO implements InterfaceProveedor {
	
	
	public int CONST_SIZE_PROVIDER_NAME=5;
	public int MAX_NUM_PROVIDER = 3;
	
	@Override
	public Proveedor getProviderById(long providerId) throws LogicException {
		// TODO Auto-generated method stub
		Proveedor proveedor=new Proveedor();
		if(providerId<10){
			proveedor=new Proveedor();
			proveedor.setIdProveedor(new Long(11));
			proveedor.setCodigoPedido("00001");
			proveedor.setDescripcion("La primera descripcion que vemos");
			proveedor.setProviderName("Empresa S.L");
			proveedor.setProviderStreet("EXAMPLE");
			proveedor.setResponsableEntrega("Empresa subcontratada");
			
			BankCount bankCount = new BankCount(1,"000001","Caja 1",3.85486);
			proveedor.setIdProveedor(new Long(12));
			proveedor.addBankAccount(bankCount);
			bankCount = new BankCount(2,"000002","Caja 1",4.85486);
			proveedor.addBankAccount(bankCount);
			bankCount = new BankCount(3,"000003","Caja 1",5.85486);
			proveedor.addBankAccount(bankCount);
		    bankCount = new BankCount(4,"000004","Caja 1",6.85486);
			proveedor.addBankAccount(bankCount);

		}else{
			//Dudas surgidas, fallan mas de un campo, fallan multitud de campos.
			//falla de todo
			Error error = new Error();
			if(providerId==11){
					error= new Error();
					error.setError("providerName","El nombre no puede ser superior a dos");
					error.setError("errorStreet","El código del proveedor no puede ser superior a 2");
					error.setError("codigoPedido", "el total del pedido es menor que cero");
					error.setError("totalPedido", "el total del pedido es menor que cero");
			}
			
			if(providerId==12){
				    error = new Error();
					error.setError("Task1", "Message relacionado con oferta");
					error.setError("Task2", "Message relacionado con cantidad");
			}
			
			throw new LogicException("PARAM",001,error);
			
		}
		return proveedor;
	}

	/**
	 *  Añadimos un proveedor.
	 * @param provider
	 * 	    	proveedor
	 * @return
	 * 		example
	 */
	public long addProvider(Proveedor provider) throws LogicException{
		
		long idProveedor=10;
		LogicException logicException = null;
		
		//Método para guardarlo en la base de datos.
		logicException = performValidation(provider);
		if(logicException!=null && logicException.isEmpty()==false)
		   throw logicException;
		
		//Consultamos toda la lógica de la base de datos.
		try{
			
			
		}catch(Exception e){
			
		}finally{
			
		}
		
		return idProveedor;
	}
	
	
	protected LogicException performBussinessValidation(Proveedor provider){
		LogicException logicException = new LogicException();
		MessageError message = checkLimitProvider(provider);
		
		if(!message.isEmpty()){
			logicException.addMessageError(message);
			// decisión de si quieres captuar todas las excepciones, o cuando tenemos la primera 
			// enviarla
			return logicException;
		}
		return logicException;
	}
	

	/**
	 * Confiamos en el nivel transaccional adecuado.
	 * 
	 * Objectivo, contar si el numero de proveedores es mayor > 3 
	 * @return
	 */
	protected MessageError checkLimitProvider(Proveedor provider){
		
         //consultamos el numero minimo de proveedores activos
		 MessageError messageError = new MessageError();
		 
		 String sql=new String("Select count(*)  form proveedores where id_empresa = ? and id_company = ? and id_user = ?");
		 
		 // throw the query.
		 long numProvider = 0;
		 if(numProvider>MAX_NUM_PROVIDER)
			 numProvider = MAX_NUM_PROVIDER;
		 
		 messageError.setKey("providerName");
		 messageError.setValue("El proveedor tiene mas de tres mensajes");
		 
		 return messageError; 
	}
	

	/**
	 * 
	 * @param provider
	 * @return
	 */
	protected LogicException performValidation(Proveedor provider){
			LogicException logic = new LogicException();
			MessageError message = null;
			
			message=checkName(provider.getProviderName());
			logic.addMessageError(message);
			
			return logic;
	}
	

	/**
	 * 
	 * @param providerName
	 * @return
	 * 	   
	 */
	protected MessageError checkName(String providerName){
		MessageError error = null;
		if(providerName!=null && !providerName.isEmpty()){
			if(providerName.length()<CONST_SIZE_PROVIDER_NAME){
				return new MessageError("providerName","El nombre del proveedor no puede ser vacio");
			}
		}
		
		return error;
	}
	
	
	/**
	 * 
	 * @param importe
	 */
	protected void checkImport(Integer importe){
		MessageError error=null;
		
	}
		
}
