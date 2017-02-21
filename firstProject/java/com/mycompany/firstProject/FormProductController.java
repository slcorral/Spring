package com.mycompany.firstProject;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.tags.form.FormTag;

import Modelo.Product;
import Modelo.Excepciones.LogicException;
import ProductDAO.ProductDAO;
import WebServices.InterfazProduct;


@Controller
@RequestMapping("/formProduct")
public class FormProductController {

	//con Ioc deberiamos de tener un objeto de tipo Conexión data controller.
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
			//Gestión de servicio Unavailable;
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
	       //Invocamos la capa DAO y disparamos un timmer, y una excepción
	       //Algoritmo de gestión de tiempo de respuesta y gestión de excepciones.
	       model.addAttribute("form",product);
	       return  resultado;
    }


}
