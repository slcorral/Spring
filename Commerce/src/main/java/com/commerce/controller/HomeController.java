package com.commerce.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.commerce.views.Link;
import com.commerce.views.Parameter;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private List<Link> listEnlaces;
	

	public HomeController(){
		
		listEnlaces = new ArrayList<Link>();
		listEnlaces.add(new Link("/provider","Proveedor",new Parameter("id","=","0")));
		listEnlaces.add(new Link("/product","Productos",new Parameter("id","=","0")));
		listEnlaces.add(new Link("/pedidosList","Pedidos",new Parameter("id","=","0")));
		listEnlaces.add(new Link("/agenda","Agenda",new Parameter("id","=","0")));
		listEnlaces.add(new Link("/almacenesList","Almacenes"));
	}
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("variable","hola mundo");
		model.addAttribute("listEnlaces",listEnlaces);
		
		return "home";
	}
	
}
