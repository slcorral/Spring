package com.commerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.commerce.modelo.MultipleProduct;

@Controller
@RequestMapping("/formMultiple")
public class FormMultipleController {

	public FormMultipleController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(Model model,MultipleProduct product){
		String value="result";
		System.out.println("Numero product "+ product.productVector.length);
		
		for(int i=0;i<product.productVector.length;i++){
			System.out.println(product.productVector[i].toString());
		}
		
		return value;
	}
	
	
	@RequestMapping(method= RequestMethod.GET)
	public String initForm(Model model){
		String result="formMultiple";
		MultipleProduct product=null;
		
		product =new MultipleProduct();
		model.addAttribute("form",product);
		
		return result;
	}


}
