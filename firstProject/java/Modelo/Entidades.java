package Modelo;

public class Entidades {
	
	
	
	private String id;
	private String name;

	public Entidades(){
		id="";
		name="";
	}
	
	public Entidades(String id,String name){
		if(id!=null && !id.isEmpty() && name!=null && !name.isEmpty()){
			this.id=id;
			this.name=name;
		}
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
