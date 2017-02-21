package com.commerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.commerce.almacenDAO.AlmacenDAO;
import com.commerce.modelo.Almacen;




@Controller
@RequestMapping("/almacenesList")
public class ControllerAlmacenes {

	
	
	private AlmacenDAO almacenDAO;
	public List<Almacen> storeAlmacen;
	
	public ControllerAlmacenes(){
			
		storeAlmacen = new ArrayList<Almacen>();
		almacenDAO = new AlmacenDAO();
	}
	
	
	@RequestMapping(value = "/almacenesList", method = RequestMethod.GET)
	public String initList(Model model){
		String resultado="almacenesList";
		try{
			List<Almacen> storeList = almacenDAO.getStoresByIdCompany(0);
			model.addAttribute("storeList", storeList);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
		
		return resultado;
	}
	

}
