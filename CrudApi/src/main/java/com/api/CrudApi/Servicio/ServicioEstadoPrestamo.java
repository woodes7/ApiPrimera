package com.api.CrudApi.Servicio;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.CrudApi.Modelos.EstadoPrestamo;
import com.api.CrudApi.Repositorio.RepositorioEstadoPrestamo;

@Service
public class ServicioEstadoPrestamo {

	@Autowired
	RepositorioEstadoPrestamo repositorioEstadoPrestamo;
	
	public ArrayList<EstadoPrestamo> getEstadoPrestamo()
	{
		return (ArrayList<EstadoPrestamo>)repositorioEstadoPrestamo.findAll();
	}
	
	public void insertarEstadoPrestamo(EstadoPrestamo estadoPrestamo)
	{
		repositorioEstadoPrestamo.save(estadoPrestamo);
	}
	
	public Optional<EstadoPrestamo> getEstadoPrestamoId(Long id)
	{
		return repositorioEstadoPrestamo.findById(id);
	}
	
	
	public void updateEstadoPrestamo(EstadoPrestamo estadoPrestamo,Long id)
	{
		EstadoPrestamo estadoPrestamoObtenida=repositorioEstadoPrestamo.findById(id).get();
		estadoPrestamoObtenida.setFchInicioPresta(estadoPrestamo.getFchInicioPresta());
		estadoPrestamoObtenida.setFchEntregaPresta(estadoPrestamo.getFchEntregaPresta());
		estadoPrestamoObtenida.setFchFinPresta(estadoPrestamo.getFchFinPresta());
		
		repositorioEstadoPrestamo.save(estadoPrestamoObtenida);
	}
	
	public Boolean deleteEstadoPrestamo(Long id) {
		try {
			repositorioEstadoPrestamo.deleteById(id);
			return true;
		}catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}
}
