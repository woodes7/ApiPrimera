package com.api.CrudApi.Controlador;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.api.CrudApi.Modelos.EstadoPrestamo;
import com.api.CrudApi.Repositorio.RepositorioEstadoPrestamo;

public class ControladorEstadoPrestamo {

	RepositorioEstadoPrestamo repositorioEstadoPrestamo;
	
	@GetMapping("/estadoPrestamoSelect")
	public ArrayList<EstadoPrestamo> obtenerEstadoPrestamo() {
	return this.repositorioEstadoPrestamo.getEstadoPrestamo();
	}
	
	@GetMapping(path="/estadoPrestamoSelect/{id}")
	public Optional<EstadoPrestamo> obtenerEstadoPrestamoID(@PathVariable("id") Long id) {	
	return this.repositorioEstadoPrestamo.getEstadoPrestamoId(id);
	}
	
	@PostMapping("/estadoPrestamoInsertar")
	public void insertarEstadoPrestamo(@RequestBody EstadoPrestamo estadoPrestamo) {
		this.repositorioEstadoPrestamo.insertarEstadoPrestamo(estadoPrestamo);
	}
	
	@PutMapping(path="/estadoPrestamoActualizar/{id}")
	public void actualizarEstadoPrestamo(@RequestBody EstadoPrestamo estadoPrestamo,@PathVariable("id") Long id) {
		this.repositorioEstadoPrestamo.updateEstadoPrestamo(estadoPrestamo, id);
	}
	
	@DeleteMapping(path="/estadoPrestamoEliminar/{id}")
	public Boolean eliminarEstadoPrestamo(@PathVariable("id") Long id) {
		return this.repositorioEstadoPrestamo.deleteEstadoPrestamo(id);
	}
}
