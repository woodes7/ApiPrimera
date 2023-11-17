package com.api.CrudApi.Controlador;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.CrudApi.Modelos.Coleccion;
import com.api.CrudApi.Repositorio.RepositorioColeccion;

@RestController
@RequestMapping("/coleccion")
public class ControladorColeccion {

	RepositorioColeccion repositorioColeccion;
	
	@GetMapping("/coleccionSelect")
	public ArrayList<Coleccion> obtenerColeccion() {
	return this.repositorioColeccion.getColeccion();
	}
	
	@GetMapping(path="/coleccionSelect/{id}")
	public Optional<Coleccion> obtenerColeccionID(@PathVariable("id") Long id) {	
	return this.repositorioColeccion.getColeccionId(id);
	}
	
	@PostMapping("/coleccionInsertar")
	public void insertarColeccion(@RequestBody Coleccion coleccion) {
		this.repositorioColeccion.insertarColeccion(coleccion);
	}
	
	@PutMapping(path="/coleccionActualizar/{id}")
	public void actualizarColeccion(@RequestBody Coleccion coleccion,@PathVariable("id") Long id) {
		this.repositorioColeccion.updateColeccion(coleccion, id);
	}
	
	@DeleteMapping(path="/coleccionEliminar/{id}")
	public Boolean eliminarColeccion(@PathVariable("id") Long id) {
		return this.repositorioColeccion.deleteColeccion(id);
	}
}
}
