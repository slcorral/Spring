package com.commerce.interfazMovimiento;

import java.util.List;

import com.commerce.modelo.Movimiento;
import com.commerce.modelo.exception.LogicException;



public interface InterfazMovimiento {
		
	
	/**
	 * Añade un movimiento a la base de datos
	 * 
	 * @param 
	 * 	movimiento
	 * @return
	 */
	public long addMovimiento(Movimiento movimiento) throws LogicException;
	/**
	 * Recupera un movimiento mediante su identificador
	 * @param idMovimiento
	 * @return
	 * 		Movimiento = null en el caso de que no encuentre ningun movimiento
	 */
	public List<Movimiento> getMovimientosByIdCuenta(long idCuenta) throws LogicException;
	public List<Movimiento> getMovimientosByFecha(String fechaInic,String fechaFin) throws LogicException;
	public List<Movimiento> getMovimientosByField(String souceBank,String sourceUser,String targetBank,String targetUser,double importe,String estado);
	
		
	
}
