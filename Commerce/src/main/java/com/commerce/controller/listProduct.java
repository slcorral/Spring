package com.commerce.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.commerce.interfazProduct.InterfazProduct;
import com.commerce.modelo.Product;
import com.commerce.modelo.exception.LogicException;
import com.commerce.productDAO.ProductDAO;


@Controller
@RequestMapping("/listProduct")
public class listProduct {

	private String nameForm="listProduct";
	
	private InterfazProduct productAccess= new ProductDAO();
	private List<Product> listProduct;
	
	private Long inic = new Long(0);
	private Long fin = new Long(20);
	
	@RequestMapping(method= RequestMethod.GET)
	public String listProduct(Model model){
		String result=nameForm;
		
		try{
		  listProduct=productAccess.getListProduct(inic,fin);
		  System.out.println("Tamanio de la lista "+listProduct.size());
	      model.addAttribute("listProduct",listProduct);
		}catch(LogicException e){

		}
		return result;
	}
	
	
	@RequestMapping(value="/next",method = RequestMethod.GET)
	public String nextList(){
		String result="listaProduct";
		
		return result;
	}
	
	@RequestMapping(value="/previous",method = RequestMethod.GET)
	public String previousList(){
		String result=nameForm;
		
		return result;
	}
	
	@RequestMapping(value="/buscar", method= RequestMethod.GET)
	public String buscar(){
		String result="";
		
		return result;
	}

}
