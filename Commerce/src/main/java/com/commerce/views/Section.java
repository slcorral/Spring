package com.commerce.views;

import java.util.ArrayList;
import java.util.List;

public class Section {
	

	
	private String section;
	private List<Link> listLink;

	public Section(String section,List<Link> listLink){
		if(section!=null && !section.isEmpty() && listLink!=null && !listLink.isEmpty()){
			 this.section=section;
			 this.listLink=listLink;
		}
	}
	
	
	public Section(String section){
		if(section!=null && !section.isEmpty()){
			   this.section=section;
			   this.listLink= new ArrayList<Link>();
		}
	}
	
	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public List<Link> getListLink() {
		return listLink;
	}

	public void setListLink(List<Link> listLink) {
		if(listLink!=null && !listLink.isEmpty())
	     	this.listLink = listLink;
	}
	
	public void addLink(Link newLink){
	      if(newLink!=null)
	    	 this.listLink.add(newLink);
	}
	
	public boolean hashParam(){
		return listLink.isEmpty();
	}
	
}
