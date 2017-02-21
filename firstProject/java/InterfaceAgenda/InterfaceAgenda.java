package InterfaceAgenda;

import java.util.Date;
import java.util.List;

import Modelo.Asistente;
import Modelo.Day;
import Modelo.Evento;
import Modelo.Excepciones.LogicException;

public interface InterfaceAgenda {
	
	public Day getEventByIdPersona(long idPersona) throws LogicException;
	public List<Evento> getEventByDay(Date date) throws LogicException;
	public List<Evento> getEventByMonthAndYear(int month,int year) throws LogicException;
	public List<Asistente> getAsistentesByField(Asistente asistente) throws LogicException;
	
}
