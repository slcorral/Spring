package com.commerce.pedidosDAO;

import java.util.List;

import com.commerce.interfacePedidos.InterfacePedidos;
import com.commerce.modelo.Pedido;
import com.commerce.modelo.exception.LogicException;

public class PedidosDAO implements InterfacePedidos{

	@Override
	public List<Pedido> getListPedidos(Long idCompany, Long idUser, int inicIndex, int inicEnd) throws LogicException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido getPedidoByIndex(long idCompany, long idUser, long idPedido) {
		// TODO Auto-generated method stub
		return null;
	}

}
