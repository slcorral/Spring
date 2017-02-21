package com.mycompany.firstProject;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Modelo.Objeto;
import Modelo.Bank.BankAccount;
import Modelo.Excepciones.LogicException;

@RequestMapping(value="/fechas")
@Controller
public class FechasController {

	
		@RequestMapping(value="/buscar",method=RequestMethod.GET)
		public void buscarFechas(@RequestParam("date") @DateTimeFormat(iso=ISO.NONE) Date date){
			System.out.println("Fecha "+date);
		}
		
		
		
		@RequestMapping(value="/buscar2",method=RequestMethod.GET)
		public void buscarFechas2(@RequestParam("date") Date date){
			System.out.println("Fecha "+date);
		}
		
		
		@RequestMapping(value="/fechas", method = RequestMethod.GET)
		public void init(Model model){
			model.addAttribute("ejemplo","ejemplo");
	    }
		
		
		@RequestMapping(value="/put",method= RequestMethod.PUT)
		public void put(@RequestBody Objeto objeto){
			
			System.out.println(objeto.getDate());
		}
		

}
