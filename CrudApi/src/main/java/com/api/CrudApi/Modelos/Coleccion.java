package com.api.CrudApi.Modelos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="coleccion", schema="gbp_almacen")
public class Coleccion {
	//atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_coleccion", nullable = false)
	private long idColeccion;

	@Column(name = "nombre_coleccion", nullable = false)
	private String nombreColeccion;

	@OneToMany(mappedBy="coleccion")	
	List<Libro> librosColeccion;
	
	//Constructores
	public Coleccion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Coleccion(long idColeccion, String nombreColeccion) {
		super();
		this.idColeccion = idColeccion;
		this.nombreColeccion = nombreColeccion;
	}
	
	//Getters && Setters
	public long getIdColeccion() {
		return idColeccion;
	}

	public void setIdColeccion(long idColeccion) {
		this.idColeccion = idColeccion;
	}

	public String getNombreColeccion() {
		return nombreColeccion;
	}

	public void setNombreColeccion(String nombreColeccion) {
		this.nombreColeccion = nombreColeccion;
	}
	
}
