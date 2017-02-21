package com.commerce.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.commerce.InterfaceAccount.InterfaceAccount;
import com.commerce.accountDAO.AccountDAO;
import com.commerce.ajaxStructure.AjaxStructure;
import com.commerce.modelo.bank.BankAccount;
import com.commerce.modelo.exception.LogicException;
import com.commerce.views.Link;
import com.commerce.views.Parameter;
import com.commerce.views.Section;

import flexjson.JSONSerializer;



@RequestMapping(value="/account")
@Controller
public class ControllerAccount {
	
	InterfaceAccount interfaceAccount;
	
	
	private List<Section> listSection;
	private long idProveedor;
	
	public ControllerAccount(){
		interfaceAccount=new AccountDAO();
		
		Section sectionHome = new Section("Principal");
		sectionHome.addLink(new Link("/","Home"));
		
		Section section = new Section("Proveedor");
		listSection = new ArrayList<Section>();
	    listSection.add(sectionHome);
		
		section.addLink(new Link("/provider","Proveedor",new Parameter("id","=","0")));
	    section.addLink(new Link("/provider","Proveedor2",new Parameter("id","=","0")));
		section.addLink(new Link("/provider","Proveedor3",new Parameter("id","=","0")));
		
		listSection.add(section);
		Section productSection = new Section("Productos");
		
		productSection.addLink(new Link("/product","Productos1",new Parameter("id","=","0")));
		productSection.addLink(new Link("/product","Productos2",new Parameter("id","=","0")));
		productSection.addLink(new Link("/product","Productos3",new Parameter("id","=","0")));
		
		listSection.add(productSection);
		
		Section pedidosSection = new Section("Pedidos");
		pedidosSection.addLink(new Link("/pedidos","Pedidos1",new Parameter("id","=","0")));
		pedidosSection.addLink(new Link("/pedidos","Pedidos2",new Parameter("id","=","0")));
		pedidosSection.addLink(new Link("/pedidos","Pedidos3",new Parameter("id","=","0")));
		
		listSection.add(pedidosSection);
		idProveedor=0;
	}
	
	
	@RequestMapping(value="/account", method = RequestMethod.GET)
	public void init(Model model,@RequestParam long id){
		
		if(id>=0){
		  this.idProveedor=id;
		  try{
			  
			   BankAccount bankAccount= interfaceAccount.getAccountByIdAccount(id);
			   model.addAttribute("listSection",listSection);
			   model.addAttribute("listOwner",bankAccount.getListOwner());
			   model.addAttribute("bankAccount",bankAccount);
			   model.addAttribute("vectorOwner",exportarJavaScript(bankAccount));
			   
		   } catch (LogicException e) {
			// TODO Auto-generated catch block
			   e.printStackTrace();
		  }finally{
		
		  }
		  
		}
		
	}
	
	
	@RequestMapping(value="/submitForm")
	@ResponseBody
	public AjaxStructure submit(@RequestBody BankAccount bankAccount){
		AjaxStructure ajaxStructure=new AjaxStructure();
		try{
			interfaceAccount.getAccountByIdAccount(222);
		}catch(LogicException e){
			ajaxStructure.setState("KO");
		}finally{
			
		}
		return ajaxStructure;
	}
	
	
	 protected  String exportarJavaScript(BankAccount b){
		 
   	     JSONSerializer serializador = new JSONSerializer();
   	     serializador.exclude("class");
   	     
         String arraySerializado=serializador.serialize(b.getListOwner());
         System.out.println("Serializador "+arraySerializado);
         return arraySerializado;
         
	}
	
	
}
