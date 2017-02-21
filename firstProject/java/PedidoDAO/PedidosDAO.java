package PedidoDAO;

import java.util.ArrayList;
import java.util.List;

import InterfazPedidos.InterfazPedidos;
import Modelo.Pedido;
import Modelo.Product;
import Modelo.Excepciones.LogicException;

public class PedidosDAO implements InterfazPedidos {

	public PedidosDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Pedido> getListPedidos(Long idCompany, Long idUser,
			int inicIndex, int inicEnd) throws LogicException {
		
		List<Pedido> listPedidos = null;
		try{
			 listPedidos = new ArrayList<Pedido>();
			for(int i=0;i<100;i++){
			    listPedidos.add(new Pedido());
			}
		}catch(OutOfMemoryError e){
			e.printStackTrace();
		}
		
		return listPedidos;
	}

	@Override
	public Pedido getPedidoByIndex(long idCompany, long idUser, long idPedido) {
		Pedido pedido=new Pedido();
	    List<Product> listaProduct=new ArrayList<Product>();
	    for(int i=0;i<20;i++){
	    	listaProduct.add(new Product());
	    }
	    pedido.setListProduct(listaProduct);
		return pedido;
	}
	
}
