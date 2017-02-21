package com.commerce.views;



public class Parameter {
	
	
	private String name;
	private String operator;
	private String value;
	
	
	public Parameter(String name,String operator,String value){
		
		if(name==null  || name.isEmpty())
			throw new NullPointerException("Param  null");
		
		if(operator==null  || operator.isEmpty())
			throw new NullPointerException("Param  null");
		
		if(value==null || value.isEmpty())
			throw new NullPointerException("Param null");
		
		this.name=name;
		this.operator=operator;
		this.value=value;
	}
	
	
	public Parameter(){
		name="";
		operator="";
		value="";
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getOperator() {
		return operator;
	}


	public void setOperator(String operator) {
		this.operator = operator;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}
	
	
}
