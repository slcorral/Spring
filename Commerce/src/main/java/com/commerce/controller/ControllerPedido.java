package com.commerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.commerce.modelo.Pedido;
import com.commerce.pedidosDAO.PedidosDAO;


@Controller
@RequestMapping("/pedido")
public class ControllerPedido {

	
	PedidosDAO pedidoDao=null;
	
	
	public ControllerPedido(){
		pedidoDao = new PedidosDAO();
	}
	
	
	@RequestMapping("/pedido")
	public String init(Model model,@RequestParam long id){
		String result="pedido";
		try{
			Pedido pedido= pedidoDao.getPedidoByIndex(0,0,id);
			model.addAttribute("pedido",pedido);
		}catch(Exception e){
				e.printStackTrace();
		}finally{
			
		}
		return result;
	}
	
	

	
	
}
