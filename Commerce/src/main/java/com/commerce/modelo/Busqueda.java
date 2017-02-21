package com.commerce.modelo;



public class Busqueda {
	
	
	  private String entidadOrigen;
	  private String usuarioOrigen;
	  private String entidadDestino;
	  private String usuarioDestino;
	  private double importe;
	  private String state;
	  
	  
	   public Busqueda(){
		  
		   entidadOrigen="";
		   usuarioOrigen="";
		   entidadDestino="";
		   usuarioDestino="";
		   importe=3.1;
		   state="";
		   
	   }

	  
	  
	   public String getEntidadOrigen() {
			return entidadOrigen;
		}


		public void setEntidadOrigen(String entidadOrigen) {
			this.entidadOrigen = entidadOrigen;
		}


		public String getUsuarioOrigen() {
			return usuarioOrigen;
		}


		public void setUsuarioOrigen(String usuarioOrigen) {
			this.usuarioOrigen = usuarioOrigen;
		}


		public String getEntidadDestino() {
			return entidadDestino;
		}


		public void setEntidadDestino(String entidadDestino) {
			this.entidadDestino = entidadDestino;
		}


		public String getUsuarioDestino() {
			return usuarioDestino;
		}


		public void setUsuarioDestino(String usuarioDestino) {
			this.usuarioDestino = usuarioDestino;
		}
		
		public double getImporte() {
			return importe;
	    }

		public void setImporte(double importe) {
			this.importe = importe;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}
 
}
