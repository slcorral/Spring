package com.commerce.generalInformationDAO;

import java.util.ArrayList;
import java.util.List;

import com.commerce.InterfazGeneralInformation.InterfazGeneralInformation;
import com.commerce.modelo.Categoria;
import com.commerce.modelo.Entidades;
import com.commerce.modelo.Grupo;
import com.commerce.modelo.Sala;
import com.commerce.modelo.exception.LogicException;


public class GeneralInformationDAO implements InterfazGeneralInformation {

	@Override
	public List<Entidades> getEntidades() throws LogicException {
		// TODO Auto-generated method stub
		
		List<Entidades> listaEntidades= new ArrayList<Entidades>();
		Entidades entidad=new Entidades();
		entidad.setId("1");
		entidad.setName("Santander");
		listaEntidades.add(entidad);
		
		Entidades  segunda = new Entidades();
		segunda.setId("2");
		segunda.setName("Cajamar");
		listaEntidades.add(segunda);
		
		return listaEntidades;
		
	}

	@Override
	public List<Grupo> getGrupos() throws LogicException {
		List<Grupo> listGrupos=new ArrayList<Grupo>();
		Grupo grupo=new Grupo();
		for(int i=0;i<20;i++){
			grupo=new Grupo();
			grupo.setIdBd(i);
			grupo.setIdGrupo(i);
			grupo.setGroupName("Groupo "+i);
			listGrupos.add(grupo);
		}
		return listGrupos;
	}

	@Override
	public List<Categoria> getCategorias() throws LogicException {
		List<Categoria> listCategorias=new ArrayList<Categoria>();
		for(int i=0;i<20;i++){
			Categoria categoria=new Categoria();
			categoria.setIdBd(i);
			categoria.setIdCategoria(i);
			categoria.setCategoryName("Category "+i);
			listCategorias.add(categoria);
		}
		return listCategorias;
	}

	@Override
	public List<Sala> getListSalas() throws LogicException {
		List<Sala> listSalas=new ArrayList<Sala>();
		for(int i=1;i<=30;i++){
			Sala sala=new Sala();
			sala.setCapacidad(i);
			sala.setIdBd(i);
			sala.setConferencia(false);
			sala.setMonitor(true);
			sala.setNombre("Nombre "+i);
			sala.setPlanta(i);
			sala.setTraductor(true);
			sala.setTraductor2(false);
			sala.setNumSala(i);
			listSalas.add(sala);
		}
		return listSalas;
	}
	
}
