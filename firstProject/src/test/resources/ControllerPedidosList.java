

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.views.Link;
import com.mycompany.views.Parameter;

import Modelo.Pedido;
import PedidoDAO.*;


@Controller
@RequestMapping("/pedidosList")
public class ControllerPedidosList {

	
	PedidosDAO pedidosDAO;
	private List<Link> listEnlaces;

	public ControllerPedidosList() {
		// TODO Auto-generated constructor stub
		pedidosDAO = new PedidosDAO();
		listEnlaces = new ArrayList<Link>();
		listEnlaces.add(new Link("/provider","Proveedor",new Parameter("id","=","0")));
		listEnlaces.add(new Link("/product","Productos",new Parameter("id","=","0")));
		listEnlaces.add(new Link("/pedidosList","Pedidos",new Parameter("id","=","0")));
	}
	
	
	@RequestMapping(value = "/pedidosList", method = RequestMethod.GET)
	public String init(Model model){
		String result="pedidosList";
		
		System.out.println("Pedidos Init");
		
		try{
			
			List<Pedido> pedidos = pedidosDAO.getListPedidos(new Long(0),new Long(0),0,10);
		    model.addAttribute("pedidos",pedidos);
		    model.addAttribute("listEnlaces",listEnlaces);

		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally{
			
		}
		
		return result;
	}
	
	

}
