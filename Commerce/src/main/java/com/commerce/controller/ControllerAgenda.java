package com.commerce.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.commerce.InterfazGeneralInformation.InterfazGeneralInformation;
import com.commerce.agendaDAO.AgendaDAO;
import com.commerce.ajaxStructure.AjaxStructure;
import com.commerce.generalInformationDAO.GeneralInformationDAO;
import com.commerce.interfaceAgenda.InterfaceAgenda;
import com.commerce.modelo.Asistente;
import com.commerce.modelo.BusquedaSala;
import com.commerce.modelo.Day;
import com.commerce.modelo.Evento;
import com.commerce.modelo.Sala;
import com.commerce.modelo.exception.LogicException;
import com.commerce.views.Link;
import com.commerce.views.Parameter;
import com.commerce.views.Section;

import flexjson.JSONSerializer;


@RequestMapping(value="/agenda")
@Controller
public class ControllerAgenda {

	
	InterfaceAgenda agenda;
	private List<Section> listSection;
	InterfazGeneralInformation generalInformation;
	
	public ControllerAgenda(){
		agenda=new AgendaDAO();
		generalInformation = new GeneralInformationDAO();
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
	}


	@RequestMapping(value="/agenda", method = RequestMethod.GET)
	public void init(Model model,@RequestParam long id){
		
		try{
	
			Day day=agenda.getEventByIdPersona(id);
			model.addAttribute("Day",day);
		    model.addAttribute("listSection",listSection);
		    model.addAttribute("vectorEventos",exportarJavaScript(day.getListEventos()));
		    model.addAttribute("listGrupos",generalInformation.getGrupos());
		    model.addAttribute("listCategorias",generalInformation.getCategorias());
		    model.addAttribute("listGrupos",generalInformation.getGrupos());
		    model.addAttribute("modelDay",exportarJavaScriptDay(day));
		    
		}catch(LogicException e){
			model.addAttribute("error", e.getError());
		}finally{
			
		}
		
	}
	
	@RequestMapping(value="/buscarAsistente",method=RequestMethod.POST)
	@ResponseBody
	public AjaxStructure buscarAsistentes(Model model,@RequestBody Asistente camposBusqueda){
		
		AjaxStructure ajaxStructure= new AjaxStructure();
		try {
			List<Asistente> asistente=agenda.getAsistentesByField(camposBusqueda);
			Iterator<Asistente> it;
			ajaxStructure.setState("OK");
			it=asistente.iterator();
			while(it.hasNext())
				ajaxStructure.addObject(it.next());
			
		} catch (LogicException e) {
			//TODO Auto-generated catch block
			ajaxStructure.setState("KO");
		}
		
		return ajaxStructure;
		
	}
	
	
	@RequestMapping(value="/busquedaSala",method=RequestMethod.POST)
	@ResponseBody
	public AjaxStructure buscarSalar(Model model,@RequestBody BusquedaSala busquedaSala){
		
		AjaxStructure ajaxStructure=new AjaxStructure();
		try{
	    	List<Sala> listaSalas=generalInformation.getListSalas();
	        ajaxStructure.setState("OK");
	        Iterator<Sala> it;
	        it=listaSalas.iterator();
	        while(it.hasNext()){
	        	ajaxStructure.addObject(it.next());
	        }
	     
		}catch(LogicException e){
			ajaxStructure.setMessageOk("KO");
		}finally{
			
		}
		
		return ajaxStructure;
	}
		
	
	protected String exportarJavaScriptDay(Day day){
		
		JSONSerializer serializador = new JSONSerializer();
  	    serializador.exclude("*.class");
        String arraySerializado=serializador.deepSerialize(day);
        System.out.println("Serializador "+arraySerializado);
        
        return arraySerializado;
	}
	
	
	protected  String exportarJavaScript(List<Evento> listEventos){ 
  	    JSONSerializer serializador = new JSONSerializer();
  	    serializador.exclude("class");
        String arraySerializado=serializador.serialize(listEventos);
        System.out.println("Serializador "+arraySerializado);
        return arraySerializado;
	}
	
}
