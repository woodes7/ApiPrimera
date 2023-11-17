package com.api.CrudApi.Servicio;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.CrudApi.Modelos.Editorial;
import com.api.CrudApi.Repositorio.RepositorioEditorial;

@Service
public class ServicioEditorial {
	@Autowired
	RepositorioEditorial repositorioEditorial;
	
	public ArrayList<Editorial> getEditorial()
	{
		return (ArrayList<Editorial>) repositorioEditorial.findAll();
	}
	
	public void insertarEditorial(Editorial editorial)
	{
		repositorioEditorial.save(editorial);
	}
	
	public Optional<Editorial> getEditorialId(Long id)
	{
		return repositorioEditorial.findById(id);
	}
	
	
	public void updateEditorial(Editorial editorial,Long id)
	{
		Editorial editorialObetnido=repositorioEditorial.findById(id).get();
		editorialObetnido.setIdEditorial(editorial.getIdEditorial());
		repositorioEditorial.save(editorialObetnido);
	}
	
	public Boolean deleteEditorial(Long id) {
		try {
			repositorioEditorial.deleteById(id);
			return true;
		}catch(IllegalArgumentException e)
		{
			return false;
		}
		
	}
}
