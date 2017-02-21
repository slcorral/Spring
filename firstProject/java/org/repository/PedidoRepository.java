package org.repository;
import jpa.PedidoJPA;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


public interface PedidoRepository extends PagingAndSortingRepository<PedidoJPA, Integer>{
	
	
	public PedidoJPA findPedidoById(long idpedido);

	public PedidoJPA findPedidoByProveedorAndSteet(String proveedor,String street);
	
}
