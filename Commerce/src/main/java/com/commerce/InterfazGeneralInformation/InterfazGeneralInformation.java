package com.commerce.InterfazGeneralInformation;



import java.util.List;

import com.commerce.modelo.Categoria;
import com.commerce.modelo.Entidades;
import com.commerce.modelo.Grupo;
import com.commerce.modelo.Sala;
import com.commerce.modelo.exception.LogicException;



public interface InterfazGeneralInformation {
	
	public List<Entidades> getEntidades() throws LogicException;
 	public List<Grupo> getGrupos() throws LogicException;
 	public List<Categoria> getCategorias() throws LogicException;
 	public List<Sala> getListSalas() throws LogicException;
 	
}
