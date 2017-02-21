package com.mycompany.firstProject;

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

import ajaxStructure.AjaxStructure;

import com.mycompany.views.Link;
import com.mycompany.views.Parameter;
import com.mycompany.views.Section;

import flexjson.JSONSerializer;
import GeneralInformationDAO.GeneralInformationDAO;
import InterfazGeneralInformation.InterfazGeneralInformation;
import InterfazMovimiento.InterfazMovimiento;
import MovimientoDAO.MovimientoDAO;
import Modelo.Busqueda;
import Modelo.Entidades;
import Modelo.Movimiento;
import Modelo.Excepciones.LogicException;



@Controller
@RequestMapping(value="/movimientos")
public class ControllerMovimientos {

	
	InterfazMovimiento movimientoDAO;
	InterfazGeneralInformation generalInformation;
	
	private List<Section> listSection;
	private List<Entidades> listEntidades;
	private int prueba=0;
	
	public ControllerMovimientos(){
		
		try{
			movimientoDAO = new MovimientoDAO();
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
			listEntidades = generalInformation.getEntidades();
		
		} catch (Modelo.Excepciones.LogicException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
		}
		
	}
	
	
	@RequestMapping(value="/movimientos")
	public String init(Model model,@RequestParam long id){
		String myForm="movimiento";
		try{
			List<Movimiento> movimiento=movimientoDAO.getMovimientosByIdCuenta(id);
			model.addAttribute("vectorMovimientos",exportarJavaScript(movimiento));
			model.addAttribute("movimientos",movimiento);
			model.addAttribute("listSection",listSection);
			model.addAttribute("listaEntidades",listEntidades);
		}catch(LogicException e){
			model.addAttribute("error",e.getError());
		}
		return myForm;
	}

	protected  String exportarJavaScript(List<Movimiento> listMovimiento){
		   
  	  JSONSerializer serializador = new JSONSerializer();
  	  serializador.exclude("class");
      String arraySerializado=serializador.serialize(listMovimiento);
      System.out.println("Serializador "+arraySerializado);
      
      return arraySerializado;
        
	}
	
	
	@RequestMapping(value="/buscar",method=RequestMethod.POST)
	@ResponseBody
	public AjaxStructure buscar(Model model,@RequestBody Busqueda camposBusqueda){
		
		AjaxStructure ajaxStructure = new AjaxStructure();
		
		if(camposBusqueda.getEntidadDestino()!=null && camposBusqueda.getEntidadOrigen()!=null &&
				camposBusqueda.getUsuarioDestino()!=null && camposBusqueda.getUsuarioOrigen()!=null){
		    try{
			   List<Movimiento> movimientos=movimientoDAO.getMovimientosByField(camposBusqueda.getEntidadOrigen(), camposBusqueda.getUsuarioOrigen(),
					camposBusqueda.getEntidadDestino(),camposBusqueda.getUsuarioDestino(),camposBusqueda.getImporte(),camposBusqueda.getState());
			   
				ajaxStructure.setState("OK");
			    Iterator<Movimiento> iterator;
			    iterator=movimientos.iterator();
			    while(iterator.hasNext()){
			    	Movimiento movimiento=iterator.next();
			    	movimiento.setSourceUser("Modificado");
			    	if(prueba>0)
			    		movimiento.setSourceUser("Modificado");
			    	ajaxStructure.addObject(movimiento);
			    }
			    prueba++;
			    
			}catch(OutOfMemoryError e){
				e.printStackTrace();
			}
			finally{
				
			}
			
		}
		
		return ajaxStructure;
	}
	
}
