package com.api.CrudApi.Servicio;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.CrudApi.Modelos.Genero;
import com.api.CrudApi.Repositorio.RepositorioGenero;

@Service
public class ServicioGenero {

	@Autowired
	RepositorioGenero repositorioGenero;
	
	public ArrayList<Genero> getGenero()
	{
		return (ArrayList<Genero>)repositorioGenero.findAll();
	}
	
	public void insertarGenero(Genero genero)
	{
		repositorioGenero.save(genero);
	}
	
	public Optional<Genero> getGeneroId(Long id)
	{
		return repositorioGenero.findById(id);
	}
	
	
	public void updateGenero(Genero genero,Long id)
	{
		Genero generoObtenido=repositorioGenero.findById(id).get();
		generoObtenido.setNombreGenero(genero.getNombreGenero());
		generoObtenido.setDescripcionGenero(genero.getDescripcionGenero());
		repositorioGenero.save(generoObtenido);
	}
	
	public Boolean deleteGenero(Long id) {
		try {
			repositorioGenero.deleteById(id);
			return true;
		}catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}
}
