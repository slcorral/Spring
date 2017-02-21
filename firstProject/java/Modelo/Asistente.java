package Modelo;

public class Asistente {
	
	public long idBd;
	public String dni;
	public String name;
	public String firstName;
	public String secondName;
	public long idGroup;
	public long idCategory;
	
	
	public Asistente(){
		idBd=0;
		name="";
		firstName="";
		secondName="";
		idGroup=0;
		idCategory=0;
	}
	
	
	public Asistente(long idBd,String dni,String name,String firstName,String secondName,long idGroup,long idCategory){
		this.dni=dni;
		this.name=name;
		this.firstName=firstName;
		this.secondName=secondName;
		this.idGroup=idGroup;
		this.idCategory=idCategory;
	}
	

	


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getSecondName() {
		return secondName;
	}


	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}


	public long getIdGroup() {
		return idGroup;
	}


	public void setIdGroup(long idGroup) {
		this.idGroup = idGroup;
	}


	public long getIdCategory() {
		return idCategory;
	}


	public void setIdCategory(long idCategory) {
		this.idCategory = idCategory;
	}
	
	public long getIdBd() {
		return idBd;
	}


	public void setIdBd(long idBd) {
		this.idBd = idBd;
	}

	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}

}
