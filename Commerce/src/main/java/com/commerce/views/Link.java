package com.commerce.views;


import java.util.ArrayList;
import java.util.List;

public class Link {
	
	
	private String url;
	private String name;
	private List<Parameter> listParam;
	private String section;
	
	
	
	public Link(String url,String name,Parameter param) throws NullPointerException{
		
		if(url==null || url.isEmpty())
			throw new NullPointerException("Param null");
		
		if(name==null || name.isEmpty())
			throw new NullPointerException("Param null");
		
		if(param==null)
			throw new NullPointerException("Param null");
		
		this.url=url;
		this.name=name;
		
		this.listParam = new ArrayList<Parameter>();
		listParam.add(param);
		
	}
	

	
	public Link(String url,String name){
		if(url==null || url.isEmpty())
			throw new NullPointerException("Param null");
		
		if(name==null || name.isEmpty())
			throw new NullPointerException("Param null");
		this.url=url;
		this.name=name;
		listParam= new ArrayList<Parameter>();
	}
	
	
	
	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}
	
	
	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	public List<Parameter> getListParam() {
		return listParam;
	}

	public void setListParam(List<Parameter> listParam) {
		this.listParam = listParam;
	}
	
	public boolean hasParam(){
	    if(listParam.size()>0)
	     return true;
	    else
	    return false;
	}
	
}
