package com.commerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.commerce.interfazProduct.InterfazProduct;
import com.commerce.modelo.Product;
import com.commerce.modelo.exception.LogicException;
import com.commerce.productDAO.ProductDAO;




@Controller
@RequestMapping("/formProduct")
public class FormProductController {

	//con Ioc deberiamos de tener un objeto de tipo Conexi�n data controller.
	//mediante IOC podemos definir si necesitamos un objeto o no.
	InterfazProduct productAcces= new ProductDAO();

	@RequestMapping(method= RequestMethod.GET)
	public String initForm(Model model,@RequestParam("id") Long id){
		String result="formProduct";
		Product product=null;
		if(id==null || id.longValue()<0){
			result="loginError";
			return result;
		}
		
		try{
			if(id.longValue()==0){
				product = new Product();
				model.addAttribute("form",product);
			}else{
				product = productAcces.getProductById(id.longValue());
				product.setName("modificado22");
				model.addAttribute("form",product);
			}
		}catch(LogicException e){
				
		}catch(OutOfMemoryError e){
			//Gesti�n de servicio Unavailable;
			result="UnavailableService";
		}
		
		return result;
	}
	
	private Product getProduct(Long id) throws LogicException{
		Product product = null;
        product= productAcces.getProductById(id);
		return product;
	}
		
	
     private void salida(Product product){
    	 	
    	 System.out.println("Example product "+product.getName());
    	 System.out.println("Example cantidad "+product.getCantidad());
    	 System.out.println("Example code "+product.getCantidad());
    	 System.out.println("Example norma "+product.getNorma());
     }

	 @RequestMapping(method = RequestMethod.POST)
	 public String submitForm(Model model,Product product) {
	       String resultado="formProduct";
	       salida(product);
	       boolean checkParam=true;
	       if(checkParam==false){
	    	   resultado="form";
	    	   //representamos los errores.
	    	   //controlar en este estado los posibles valores y errores.
	    	   return resultado;
	       }
	       
	       try{
	    	  productAcces.addProduct(product);
	    	  resultado="home";
	       }catch(LogicException e){
	    	 return resultado;
	       }
	       //Invocamos la capa DAO y disparamos un timmer, y una excepci�n
	       //Algoritmo de gesti�n de tiempo de respuesta y gesti�n de excepciones.
	       model.addAttribute("form",product);
	       return  resultado;
    }


}
