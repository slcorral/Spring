package com.commerce.movimientoDAO;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.commerce.interfazMovimiento.InterfazMovimiento;
import com.commerce.modelo.Movimiento;
import com.commerce.modelo.exception.LogicException;


public class MovimientoDAO implements InterfazMovimiento {
	
	
	
	public MovimientoDAO(){
		
	}

	
	@Override
	public List<Movimiento> getMovimientosByIdCuenta(long idCuenta)
			throws LogicException {
		// TODO Auto-generated method stub
		List<Movimiento> listaMovimientos;
		listaMovimientos= new ArrayList<Movimiento>();
		for(int i=0;i<12;i++){
			Movimiento movimiento=new Movimiento();
			movimiento.setEstado("Abierto");
			movimiento.setFechaEmision(new Date());
			movimiento.setFechaEnvio(new Date());
			movimiento.setFechaRecepcion(new Date());
			movimiento.setIdBd(i);
			movimiento.setImporte(i*2);
			movimiento.setSourceBank("Banco  "+i);
			movimiento.setSourceUser("Usuario A");
			movimiento.setTargetBank("Banco contrario "+i);
			movimiento.setTargetUser("Usuario B");
			movimiento.setSourceAccount("0000"+i);
			movimiento.setDestinationAccount("0000"+i+1);
			listaMovimientos.add(movimiento);
		}
		return listaMovimientos;
	}

	@Override
	public List<Movimiento> getMovimientosByFecha(String fechaInic,
			String fechaFin) throws LogicException {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<Movimiento> getMovimientosByField(String souceBank,
			String sourceUser, String targetBank, String targetUser,
			double importe, String estado) {
		// TODO Auto-generated method stub
		List<Movimiento> listaMovimientos;
			listaMovimientos= new ArrayList<Movimiento>();
			for(int i=0;i<100;i++){
				Movimiento movimiento=new Movimiento();
				movimiento.setEstado("Abierto");
				movimiento.setFechaEmision(new Date());
				movimiento.setFechaEnvio(new Date());
				movimiento.setFechaRecepcion(new Date());
				movimiento.setIdBd(i);
				movimiento.setImporte(i*2);
				movimiento.setSourceBank("Santander");
				movimiento.setSourceUser("Usuario A");
				movimiento.setTargetBank("Cajamar");
				movimiento.setTargetUser("Usuario B");
				movimiento.setSourceAccount("0000"+i);
				movimiento.setDestinationAccount("0000"+i+1);
				listaMovimientos.add(movimiento);
			}
			
		return listaMovimientos;
	}

	@Override
	public long addMovimiento(Movimiento movimiento) throws LogicException {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
