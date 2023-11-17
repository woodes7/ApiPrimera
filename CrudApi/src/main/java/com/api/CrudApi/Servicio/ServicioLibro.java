package com.api.CrudApi.Servicio;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.CrudApi.Modelos.Libro;
import com.api.CrudApi.Repositorio.RepositorioLibro;

@Service
public class ServicioLibro {
	@Autowired
	RepositorioLibro repositorioLibro;
	
	public ArrayList<Libro> getLibro()
	{
		return (ArrayList<Libro>) repositorioLibro.findAll();
	}
	
	public void insertarLibro(Libro libro)
	{
		repositorioLibro.save(libro);
	}
	
	public Optional<Libro> getLibroId(Long id)
	{
		return repositorioLibro.findById(id);
	}
	
	
	public void updateLibro(Libro libro,Long id)
	{
		Libro libroObtenido=repositorioLibro.findById(id).get();
		libroObtenido.setCantiadLibro(libro.getCantiadLibro());
		libroObtenido.setEdicionLibro(libro.getEdicionLibro());
		libroObtenido.setCantiadLibro(libro.getCantiadLibro());
		libroObtenido.setTituloLibro(libro.getTituloLibro());
		libroObtenido.setLibroAutor(libro.getLibroAutor());
		repositorioLibro.save(libroObtenido);
	}
	
	public Boolean deleteLibro(Long id) {
		try {
			repositorioLibro.deleteById(id);
			return true;
		}catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}
}
