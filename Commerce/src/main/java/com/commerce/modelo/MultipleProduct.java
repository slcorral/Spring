package com.commerce.modelo;



import java.util.ArrayList;

public class MultipleProduct {

	
	
	public ArrayList<Product> product;
	public Product[] productVector;
	

	public MultipleProduct() {
		// TODO Auto-generated constructor stub
		
		product=new ArrayList<Product>();
		productVector=new Product[10];
		for(int i=0;i<productVector.length;i++){
			productVector[i]=new Product();
		}
		
	}
	
	
	public Product[] getProductVector() {
		return productVector;
	}

	
	public void setProductVector(Product[] productVector) {
		this.productVector = productVector;
	}
	

}
