package Modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Proveedor {

	private long idBd;
	private Long idProveedor;
	private String providerName;
	private String providerStreet;
	private String codigoPedido;
	private Integer importePedido;


	private String responsableEntrega;
	private String descripcion;

	private List<String> telefonos;
	private String[] fax;

	private String paginaWeb = "";

	private String email = "";
	private String horario = "";

	private String[][] diasVisitaProveedor;

	private List<BankCount> bankAccount;
	private int index;

	public Proveedor() {
		// TODO Auto-generated constructor stub
		providerName = "Proveedor 1";
		providerStreet = "Street 2";
		codigoPedido = "00000";

		// bankAccount=new ArrayList<BankCount>();
		bankAccount = new ArrayList<BankCount>();
		index = 0;
		idBd = 0;
		diasVisitaProveedor = new String[7][2];
		diasVisitaProveedor[0][0] = "L";
		diasVisitaProveedor[0][1] = "Lunes";
		diasVisitaProveedor[1][0] = "M";
		diasVisitaProveedor[1][1] = "Martes";
		diasVisitaProveedor[2][0] = "X";
		diasVisitaProveedor[2][1] = "Miercoles";
		diasVisitaProveedor[3][0] = "J";
		diasVisitaProveedor[3][1] = "Jueves";
		diasVisitaProveedor[4][0] = "V";
		diasVisitaProveedor[4][1] = "Viernes";
		diasVisitaProveedor[5][0] = "S";
		diasVisitaProveedor[5][1] = "Sabado";
		diasVisitaProveedor[6][0] = "D";
		diasVisitaProveedor[6][0] = "Domingo";

		telefonos = new ArrayList<String>();
		telefonos.add("999999");
		telefonos.add("5252525");
		telefonos.add("3333");
		email="ejemplo@proveedor.com";
		paginaWeb="www.proveedor.com";

	}

	public List<BankCount> getBankAccount() {
		return bankAccount;
	}



	public void setBankAccount(List<BankCount> bankAccount) {
		this.bankAccount = bankAccount;
	}

	public void addBankAccount(BankCount bankAccount) {
		this.bankAccount.add(bankAccount);
	}

	public boolean existBankAccount() {
		if (index == 0)
			return false;
		else
			return true;
	}

	public int getImporteTotal() {
		return importePedido.intValue();
	}

	

	public void setCodigoPedido(String codPed) {
		if (codPed != null && !codPed.isEmpty()) {
			codigoPedido = codPed;
		}
	}

	public String getCodigoPedido() {
		return codigoPedido;
	}

	public Integer getImportePedido() {
		return importePedido;
	}

	public void setImportePedido(Integer importePedido) {
		this.importePedido = importePedido;
	}

	public void setResponsableEntrega(String responEntreg) {
		if (responEntreg != null && !responEntreg.isEmpty()) {
			responsableEntrega = responEntreg;
		}
	}

	public String getResponsableEntrega() {
		return responsableEntrega;
	}

	public void setDescripcion(String descrp) {
		if (descripcion != null && !descripcion.isEmpty()) {
			descripcion = descrp;
		}
	}

	public String getDescripcion() {
		return descripcion;
	}

	protected void checkNullAndEmpty(String importePed) {

	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getProviderStreet() {
		return providerStreet;
	}

	public void setProviderStreet(String providerStreet) {
		this.providerStreet = providerStreet;
	}

	public long getIdBd() {
		return idBd;
	}

	public void setIdBd(long idBd) {
		this.idBd = idBd;
	}

	public Long getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}

	
	public String[] getFax() {
		return fax;
	}

	public void setFax(String[] fax) {
		this.fax = fax;
	}

	public String getPaginaWeb() {
		return paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String[][] getDiasVisitaProveedor() {
		return diasVisitaProveedor;
	}

	public void setDiasVisitaProveedor(String[][] diasVisitaProveedor) {
		this.diasVisitaProveedor = diasVisitaProveedor;
	}
	
	public List<String> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<String> telefonos) {
		this.telefonos = telefonos;
	}
}
