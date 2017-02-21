package InterfazGeneralInformation;

import Modelo.Categoria;
import Modelo.Entidades;
import Modelo.Grupo;
import Modelo.Sala;

import java.util.List;

import Modelo.Excepciones.*;

public interface InterfazGeneralInformation {
	
	public List<Entidades> getEntidades() throws LogicException;
 	public List<Grupo> getGrupos() throws LogicException;
 	public List<Categoria> getCategorias() throws LogicException;
 	public List<Sala> getListSalas() throws LogicException;
 	
}
