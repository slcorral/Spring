package com.commerce.ajaxStructure;

import java.util.ArrayList;
import java.util.List;

import com.commerce.errors.MessageError;



public class AjaxStructure {
	
	public enum State{
		OK,KO
	}
	
	private String state;
	private String messageOk;
	private List<MessageError> errorList;
	private List<Object> listObject;
	
	
	public AjaxStructure(){
		state="";
		messageOk="";
		errorList=new ArrayList<MessageError>();
		listObject=new ArrayList<Object>();
	}
	
	
	
	public void addObject(Object object){
		if(object!=null){
			listObject.add(object);
		}
	}
	
	
	public AjaxStructure(String  state,String messageOk,List<MessageError> errorList){
		this.state=state;
		this.messageOk=messageOk;
		this.errorList=errorList;
	}
	
	
	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getMessageOk() {
		return messageOk;
	}


	public void setMessageOk(String messageOk) {
		this.messageOk = messageOk;
	}


	public List<MessageError> getErrorList() {
		return errorList;
	}


	public void setErrorList(List<MessageError> errorList) {
		this.errorList = errorList;
	}
	
	
	public void addMessageError(MessageError error){
		if(error!=null)
		  this.errorList.add(error);
	}
	
	public List<Object> getObject() {
		return listObject;
	}

	
}
