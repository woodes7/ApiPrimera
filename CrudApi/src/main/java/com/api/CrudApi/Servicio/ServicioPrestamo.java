package com.api.CrudApi.Servicio;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.CrudApi.Modelos.Prestamo;
import com.api.CrudApi.Repositorio.RepositorioPrestamo;

@Service
public class ServicioPrestamo {

	@Autowired
	RepositorioPrestamo repositorioPrestamo;
	
	public ArrayList<Prestamo> getPrestamo()
	{
		return (ArrayList<Prestamo>)repositorioPrestamo.findAll();
	}
	
	public void insertarPrestamo(Prestamo prestamo)
	{
		repositorioPrestamo.save(prestamo);
	}
	
	public Optional<Prestamo> getPrestamoId(Long id)
	{
		return repositorioPrestamo.findById(id);
	}
	
	
	public void updatePrestamo(Prestamo prestamo,Long id)
	{
		Prestamo prestamoObtenido=repositorioPrestamo.findById(id).get();
		prestamoObtenido.setFchInicioPrestamo(prestamo.getFchInicioPrestamo());
		prestamoObtenido.setFchEntregaPrestamo(prestamo.getFchEntregaPrestamo());
		prestamoObtenido.setPrestamoLibro(prestamo.getPrestamoLibro());
		prestamoObtenido.setFchFinPrestamo(prestamo.getFchFinPrestamo());
		repositorioPrestamo.save(prestamoObtenido);
	}
	
	public Boolean deletePrestamo(Long id) {
		try {
			repositorioPrestamo.deleteById(id);
			return true;
		}catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}
}
