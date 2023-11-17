package com.api.CrudApi.Controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.CrudApi.Modelos.Autor;
import com.api.CrudApi.Servicio.ServicioAutor;

@RestController
@RequestMapping("/autor")
public class ControladorAutor {

	@Autowired
	private ServicioAutor servicioAutor;
	
	@GetMapping("/autorSelect")
	public Iterable<Autor> tenerAcceso() {	
	return this.servicioAutor.getAutor();
	}
	
	@GetMapping(path="/autorSelect/{id}")
	public Optional<Autor> tenerAccesoID(@PathVariable("id") Long id) {	
	return this.servicioAutor.getAutorId(id);
	}
	
	@PostMapping("/autorInsertar")
	public void Autor(@RequestBody Autor autor) {
		this.servicioAutor.insertarAutor(autor);
	}
	
	@PutMapping(path="/autorActualizar/{id}")
	public void actualizarAcceso(@RequestBody Autor autor,@PathVariable("id") Long id) {
		this.servicioAutor.updateAutor(autor, id);
	}
	
	@DeleteMapping(path="/autorEliminar/{id}")
	public Boolean eliminarAutoro(@PathVariable("id") Long id) {
		return this.servicioAutor.eliminarAutor(id);
	}
}
