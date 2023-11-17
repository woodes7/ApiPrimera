package com.api.CrudApi.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.CrudApi.Modelos.Acceso;
import com.api.CrudApi.Repositorio.RepositorioAcceso;

import java.util.Iterator;
import java.util.Optional;

@Service
public class ServicioAcceso {

	@Autowired
	RepositorioAcceso repositorioAcceso;
	
	
	public Iterable<Acceso> darAcceso()
	{
		return repositorioAcceso.findAll();
	}
	
	
	public void insertarAcceso(Acceso acceso)
	{
		repositorioAcceso.save(acceso);
	}
	
	public Optional<Acceso> darAccesoId(Long id)
	{
		return repositorioAcceso.findById(id);
	}
	
	
	public void updateAcceso(Acceso acceso,Long id)
	{
		Acceso accesoObetnido=repositorioAcceso.findById(id).get();
		accesoObetnido.setCodigo_acceso(acceso.getCodigo_acceso());
		accesoObetnido.setDescripcion_acceso(acceso.getDescripcion_acceso());
		repositorioAcceso.save(accesoObetnido);
	}
	
	public Boolean eliminarAcceso(Long id) {
		try {
			repositorioAcceso.deleteById(id);
		}catch(IllegalArgumentException e)
		{
			return false;
		}
		return true;
		
	}
}
