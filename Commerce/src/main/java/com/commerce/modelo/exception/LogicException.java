package com.commerce.modelo.exception;

import com.commerce.errors.MessageError;
import com.commerce.errors.Error;

public class LogicException extends Exception {
	
	
	private long codeException;
	private String prefixException;
	private Error error;
	private boolean isLogic;
	


	public LogicException(String prefixException,long codeException,Error error){	
		if(prefixException!=null && codeException>0 && error!=null){
				if(!prefixException.isEmpty() && error!=null){
					this.prefixException= prefixException;
					this.error = error;
				}
		}
	}
	
	public LogicException(String prefixException,long codeException){	
		if(prefixException!=null && codeException>0 && error!=null){
				if(!prefixException.isEmpty() && error!=null){
					this.prefixException= prefixException;
					this.error = error;
				}
		}
	}
	
	
	public LogicException(){
			this.error=new Error();
			isLogic=true;
	}	
	
	public boolean isEmpty(){
		return error.isEmpty();
	}

	
	
	public void addMessageError(MessageError messageError){
		if(messageError!=null){
				error.addMessageError(messageError);
		}
	}
	
	
	public long getCodeException() {
		return codeException;
	}

	public void setCodeException(long codeException) {
		this.codeException = codeException;
	}

	public String getPrefixException() {
		return prefixException;
	}

	public void setPrefixException(String prefixException) {
		this.prefixException = prefixException;
	}
	
	
	public Error getError(){
		return error;
	}
	
	public void setError(Error err){
		error = err;
	}

	public boolean isLogic() {
		return isLogic;
	}

	public void setLogic(boolean isLogic) {
		this.isLogic = isLogic;
	}
	
}
