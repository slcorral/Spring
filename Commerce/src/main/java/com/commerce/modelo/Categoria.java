package com.commerce.modelo;


public class Categoria {
	
	public long idBd;
	public long idCategoria;
	public String categoryName;
	

	public Categoria(){
	   this.idBd=0;
	   this.idCategoria=0;
	   categoryName="";
	}
	
	public Categoria(long idBd,long idCategoria,String categoryName){
		this.idBd=idBd;
		this.idCategoria=idCategoria;
		this.categoryName=categoryName;
	}
	
	
	public long getIdBd() {
		return idBd;
	}

	public void setIdBd(long idBd) {
		this.idBd = idBd;
	}

	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
