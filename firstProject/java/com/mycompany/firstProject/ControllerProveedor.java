package com.mycompany.firstProject;



import java.util.ArrayList;
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

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import Modelo.BankCount;
import Modelo.Movimiento;
import Modelo.MultiProvider;
import Modelo.Proveedor;
import Modelo.Excepciones.LogicException;
import InterfazProveedor.InterfaceProveedor;
import Objects.MessageError;
import ProveedorDAO.ProveedorDAO;

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;


@Controller
@RequestMapping("/provider")
public class ControllerProveedor  {
	
	InterfaceProveedor proveedorDAO;

	
	private Error errors;
	private String myForm;
	private String home="";
	private List<Section> listSection;
	
	public ControllerProveedor() {
		// TODO Auto-generated constructor stub
		proveedorDAO=new ProveedorDAO();
		Section sectionHome = new Section("Principal");
		sectionHome.addLink(new Link("/","Home"));
		
		Section section = new Section("Proveedor");
		listSection = new ArrayList<Section>();
	    listSection.add(sectionHome);
		
		section.addLink(new Link("/provider","Proveedor",new Parameter("id","=","0")));
	    section.addLink(new Link("/movimientos","movimientos",new Parameter("id","=","0")));
		section.addLink(new Link("/account","Account",new Parameter("idProvider","=","0")));
		
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

		
	    errors=new Error();
	    myForm="provider";
	    
	}
	
	@RequestMapping("/provider")
	public String init(Model model,@RequestParam long id){
		String result="provider";
	
		try{
		    Proveedor provider;
			if(id>0)
			  provider = proveedorDAO.getProviderById(id);
			else
			 provider = new Proveedor();
		   
		   model.addAttribute("p",new MultiProvider(provider));
		   model.addAttribute("listSection",listSection);
		   model.addAttribute("vector",exportarJavaScript(provider));
		   
		}catch(LogicException e){
			model.addAttribute("error",e.getError());
		}
		catch(Exception e){
			e.printStackTrace();
		}finally{
			
		}
	    return result;
	}
	
	

    protected  String exportarJavaScript(Proveedor p){
   
    	  JSONSerializer serializador = new JSONSerializer();
    	  serializador.exclude("class");

          String arraySerializado=serializador.serialize(p.getBankAccount());
          System.out.println("Serializador "+arraySerializado);
          return arraySerializado;
          
	}

	
	//Anterior Proveedor
	@RequestMapping(value="/submitForm", method =RequestMethod.POST)
	@ResponseBody
	public AjaxStructure submitForm(Model model,@RequestBody MultiProvider provider){
		AjaxStructure ajaxStructure= new AjaxStructure();
		
		try {
			
			long idProvider=proveedorDAO.addProvider(provider.getProveedor());
			model.addAttribute("idProvider",idProvider);
			model.addAttribute("listSection",listSection);
			
			ajaxStructure.setState("KO");
			ajaxStructure.addMessageError(new MessageError("providerName","Caracteres incorrectos"));
			ajaxStructure.addMessageError(new MessageError("providerStreet","Caracteres incorrectos"));
			
		} catch (LogicException e) {
			// TODO Auto-generated catch block
		   AjaxStructure structure = new AjaxStructure();
		   structure.setState("KO");
		   structure.addMessageError(new MessageError("providerName","Caracteres incorrectos"));
		   model.addAttribute("error",structure);
		   
		}catch(Exception e){
			
		}finally{
			
		}
		
		return ajaxStructure;
	}
	
	
	@RequestMapping (value = "/receptorAjax", method = RequestMethod.POST)
	@ResponseBody
	public long receptorAjax(Model model,@RequestBody Proveedor proveedor){
		long idProveedor=10;
		return idProveedor;
	}
	
	@RequestMapping (value = "/ajaxString", method = RequestMethod.POST)
	@ResponseBody
	public long ajaxString(@RequestBody String example){
		long idNuevo=0;
		idNuevo++;
		Movimiento movimiento = new JSONDeserializer<Movimiento>().deserialize(example,Movimiento.class);
		long idProveedor=10;
		return idProveedor;
	}
	
	
	
	@RequestMapping (value = "/ajaxCuenta", method = RequestMethod.POST)
	@ResponseBody
	public long ajaxCuenta(Model model,@RequestBody BankCount cuenta){
		long idProveedor=10;
		return idProveedor;
	}
	
	

	@RequestMapping (value = "/ajaxMovimiento", method = RequestMethod.POST)
	@ResponseBody
	public long ajaxNuevo(@RequestBody Movimiento movimiento){
		long idProveedor=10;
		
		System.out.println("Movimiento "+movimiento.getSourceBank());
		System.out.println("Movimiento "+movimiento.getSourceUser());
		System.out.println("Movimiento "+movimiento.getTargetBank());
		System.out.println("Movimiento "+movimiento.getTargetUser());
		
		return idProveedor;
	}
	
	@RequestMapping(value = "/ajaxDevuelto", method = RequestMethod.POST)
	@ResponseBody
	public Movimiento ajaxDevuelto(Movimiento movimiento){

		Movimiento mov=new Movimiento();
		mov.setSourceBank("banco");
		mov.setSourceUser("usuariA");
		mov.setTargetUser("banco dest");
		mov.setTargetBank("usuario B");
		return mov;
	}
	
	
	@RequestMapping (value = "/ajaxSimple", method = RequestMethod.POST)
	@ResponseBody
	public long ajaxCuenta(){
		long idProveedor=10;
		return idProveedor;
	}
	
	
	/**
	 * 
	 * @param modelo
	 * @param cuenta
	 */
	public void modificarCuenta(Model modelo,Proveedor cuenta){
		
	}
	
	
	/**
	 * 
	 * @param modelo
	 * @param cuenta
	 */
	public void eliminarCuenta(Model modelo,Proveedor cuenta){
	
	
	}
	
	
}
	
	
	
	
