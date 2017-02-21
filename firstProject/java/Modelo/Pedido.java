package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Pedido {

	
	List<Product> listProduct = new ArrayList<Product>();
	
	private Proveedor proveedor;
	private Date requestDate;
	private Date deliverDate;

	
	
	public Pedido() {
		// TODO Auto-generated constructor stub
		proveedor= new Proveedor();
		requestDate= new Date();
		deliverDate = new Date();
	}
	
	public List<Product> getListProduct() {
		return listProduct;
	}



	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}



	public Proveedor getProveedor() {
		return proveedor;
	}



	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}



	public Date getRequestDate() {
		return requestDate;
	}



	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}



	public Date getDeliverDate() {
		return deliverDate;
	}



	public void setDeliverDate(Date deliverDate) {
		this.deliverDate = deliverDate;
	}
	
	
	
	public Product getProduct(long orderIndex) throws IndexOutOfBoundsException{
		Product product=null;
		try{
		    product=(Product)listProduct.get((int)orderIndex);  
		}catch(Exception  e){
				e.printStackTrace();
		}
		return product;
	}
	

	
	
}
