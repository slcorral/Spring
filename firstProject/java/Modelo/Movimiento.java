package Modelo;

import java.util.Date;


public class Movimiento {
		
	
	private long idBd;
	private String sourceUser;
	private String sourceBank;
	private String targetUser;
	private String targetBank;
	private Date fechaEmision;
	private Date fechaEnvio;
	private Date fechaRecepcion;
	private String estado;
	private double importe;
	private String sourceAccount;
	private String destinationAccount;
	
	
	public Movimiento(String sourceUser,String sourceBank,String targetUser,String targetBank){
			this.sourceUser=sourceUser;
			this.sourceBank=sourceBank;
			this.targetBank=targetBank;
			this.targetUser= targetUser;
	}
	
	public Movimiento(){
		this.sourceUser="";
		this.sourceBank="";
		this.targetBank="";
		this.targetUser= "";
		this.sourceAccount="";
		this.destinationAccount="";
	}
	
	
	public String getSourceUser() {
		return sourceUser;
	}


	public void setSourceUser(String sourceUser) {
		this.sourceUser = sourceUser;
	}


	public String getSourceBank() {
		return sourceBank;
	}


	public void setSourceBank(String sourceBank) {
		this.sourceBank = sourceBank;
	}


	public String getTargetUser() {
		return targetUser;
	}


	public void setTargetUser(String targetUser) {
		this.targetUser = targetUser;
	}


	public String getTargetBank() {
		return targetBank;
	}


	public void setTargetBank(String targetBank) {
		this.targetBank = targetBank;
	}
	
	public long getIdBd() {
		return idBd;
	}

	public void setIdBd(long idBd) {
		this.idBd = idBd;
	}
	
	
	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}
	
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	
	public String getSourceAccount() {
		return sourceAccount;
	}

	public void setSourceAccount(String sourceAccount) {
		this.sourceAccount = sourceAccount;
	}

	public String getDestinationAccount() {
		return destinationAccount;
	}

	public void setDestinationAccount(String destinationAccount) {
		this.destinationAccount = destinationAccount;
	}

	
	

}
