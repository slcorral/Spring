package com.commerce.interfaceAgenda;

import java.util.Date;
import java.util.List;

import com.commerce.modelo.Asistente;
import com.commerce.modelo.Day;
import com.commerce.modelo.Evento;
import com.commerce.modelo.exception.LogicException;

public interface InterfaceAgenda {
	
	public Day getEventByIdPersona(long idPersona) throws LogicException;
	public List<Evento> getEventByDay(Date date) throws LogicException;
	public List<Evento> getEventByMonthAndYear(int month,int year) throws LogicException;
	public List<Asistente> getAsistentesByField(Asistente asistente) throws LogicException;
	
}
