package Modelo.Bank;

public class Entity {
	
	
	public String Nombre;
	public long idBd;
	public String mainOffice;
	public String telephone;
	public String web;
	public String Horario;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public Long getIdBd() {
		return idBd;
	}
	public void setIdBd(long idBd) {
		this.idBd = idBd;
	}
	public String getMainOffice() {
		return mainOffice;
	}
	public void setMainOffice(String mainOffice) {
		this.mainOffice = mainOffice;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public String getHorario() {
		return Horario;
	}
	public void setHorario(String horario) {
		Horario = horario;
	}
	
}
