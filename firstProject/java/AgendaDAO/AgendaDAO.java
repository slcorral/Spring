package AgendaDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import InterfaceAgenda.InterfaceAgenda;
import Modelo.Asistente;
import Modelo.Day;
import Modelo.Evento;
import Modelo.Excepciones.LogicException;

public class AgendaDAO implements InterfaceAgenda {

	@Override
	public List<Evento> getEventByDay(Date date) throws LogicException {
		// TODO Auto-generated method stub
		List<Evento> listaEventos=new ArrayList<Evento>();
		for(int i=9;i<=12;i++){
			Evento evento=new Evento();
			evento.setIdBd(i);
		    evento.sethInic(i);
		    evento.sethFin(i+1);
		    evento.setMinutInic(0);
		    evento.setMinutFin(0);
		    evento.setSecondInic(0);
		    evento.sethFin(0);
		    listaEventos.add(evento);
	    }
		return listaEventos;
	}

	@Override
	public List<Evento> getEventByMonthAndYear(int month, int year)
			throws LogicException {
		return null;
	}


	@Override
	public Day getEventByIdPersona(long idPersona) throws LogicException {
		
		Day  day=new Day();
		day.sethInic(6);
		day.sethFin(20);
		day.setmInic(0);
		day.setsInic(0);
		day.setsFin(0);
		day.setmFin(0);
		
		List<Asistente> listAsistente=new ArrayList<Asistente>();
		
		for(int i=0;i<10;i++){
			Asistente asistente=new Asistente();
			asistente.setDni("A"+i);
			asistente.setFirstName("Primero "+i);
			asistente.setIdCategory(i);
			asistente.setIdGroup(i);
			asistente.setName("Nombre "+i);
			asistente.setSecondName("Segundo "+i);
			asistente.setIdBd(i);
			listAsistente.add(asistente);
		}
		
		for(int i=9;i<=13;i++){
			Evento evento=new Evento();
		    evento.sethInic(i);
		    evento.sethFin(i+1);
		    evento.setMinutInic(0);
		    evento.setMinutFin(0);
		    evento.setSecondInic(0);
		    evento.sethFin(0);
		    evento.setNombre("Nombre "+i);
		    evento.setDescripcion("Descripcion "+i);
		    evento.setListAsistentes(listAsistente);
		    day.addEvento(evento);
	    }
		return day;
	}

	@Override
	public List<Asistente> getAsistentesByField(Asistente asistente)
			throws LogicException {
		// TODO Auto-generated method stub
		List<Asistente> listaAsistente=new ArrayList<Asistente>();
		for(int i=0;i<10;i++){
			Asistente asistente1=new Asistente();
			asistente1.setDni("BU"+i);
			asistente1.setFirstName("Example"+i);
			asistente1.setIdBd(i);
			asistente1.setIdCategory(i);
			asistente1.setIdGroup(i);
			asistente1.setName("Nombre "+i);
			asistente1.setSecondName("Seconda Name "+i);
			listaAsistente.add(asistente1);
		}
		return listaAsistente;
	}



}
