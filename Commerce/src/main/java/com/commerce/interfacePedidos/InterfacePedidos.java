package com.commerce.interfacePedidos;

import java.util.List;

import com.commerce.modelo.Pedido;
import com.commerce.modelo.exception.LogicException;



public interface InterfacePedidos {

	public List<Pedido> getListPedidos(Long idCompany,Long idUser,int inicIndex,int inicEnd) throws LogicException;
	
	public Pedido getPedidoByIndex(long idCompany,long idUser,long  idPedido);
	
}
