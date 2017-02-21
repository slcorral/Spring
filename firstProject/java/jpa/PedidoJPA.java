package jpa;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import org.springframework.data.jpa.*;


@Entity
@Table(name="pedido")
public class PedidoJPA {

	@Column(name="idpedido")
	private long idpedido;
	
	@Column(name="proveedor")
	private String proveedor;
	
	@Column(name="street")
	private String street;
	
	
	public PedidoJPA(){
		
	}
	
	public PedidoJPA(long id,String proveedor,String street){
		this.idpedido=id;
		this.proveedor=proveedor;
		this.street=street;
	}
	
	
	public long getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(long idpedido) {
		this.idpedido = idpedido;
	}

	
	public String getProveedor() {
		return proveedor;
	}


	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}
}
