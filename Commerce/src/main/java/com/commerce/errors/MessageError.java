package com.commerce.errors;

public class MessageError {
		
	
	protected String key;
	protected String value;
	
	/**
	 * 
	 * @param key
	 * @param value
	 * @throws NullPointerException
	 */
	public MessageError(String key,String value) throws NullPointerException{
		checkKeyAndValue(key,value);
	}
	
	public MessageError(){
		key="";
		value="";
	}
	
	
	public boolean isEmpty(){
		if(key==null || value==null || value.isEmpty() || key.isEmpty())
			return true;
		else
			return false;
	}

	protected void checkKeyAndValue(String key,String value) throws NullPointerException{
		if(key!=null && !key.isEmpty() && value!=null && !value.isEmpty()){
			//Logic comparation.
			this.key=key;
			this.value=value;
		}else{
			throw new NullPointerException("");
		}
	}
	
	/**
	 * 
	 * @param keyValue
	 * @param value
	 */
	public void addMessageError(String keyValue,String value){
		checkKeyAndValue(keyValue,value);
	}
	
	
	public String getKey() {
		return key;
	}



	public void setKey(String key) {
		this.key = key;
	}



	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}
	
	
	
}
