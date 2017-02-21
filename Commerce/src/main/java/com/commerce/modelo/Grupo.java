package com.commerce.modelo;



public class Grupo {

	
	public long idBd;
	public long idGrupo;
	public String groupName;
	
	public Grupo(){
		this.idBd=0;
		this.idGrupo=0;
		this.groupName="";
	}
	
	public Grupo(long idBd,long idGrupo,String groupName){
		this.idBd=idBd;
		this.idGrupo=idGrupo;
		this.groupName=groupName;
	}
	
	public long getIdBd() {
		return idBd;
	}

	public void setIdBd(long idBd) {
		this.idBd = idBd;
	}

	public long getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(long idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	

}
