package InterfazPedidos;

import java.util.List;



import Modelo.Pedido;
import Modelo.Excepciones.LogicException;

public interface InterfazPedidos {

	public List<Pedido> getListPedidos(Long idCompany,Long idUser,int inicIndex,int inicEnd) throws LogicException;
	
	public Pedido getPedidoByIndex(long idCompany,long idUser,long  idPedido);
	
}
