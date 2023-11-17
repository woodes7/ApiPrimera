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
@Table(name="editorial", schema="gbp_almacen")
public class Editorial {
	
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_editorial", nullable = false)
	private long idEditorial;

	@Column(name = "nombre_editorial", nullable = false)
	private String nombreEditorial;

	@Column(name = "descripcion_genero")
	private String descripcionGenero;
	
	@OneToMany	(mappedBy="editorial")
	List<Libro> librosEditorial;
	
	//Contructores

	public Editorial() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Editorial(long idEditorial, String nombreEditorial, String descripcionGenero) {
		super();
		this.idEditorial = idEditorial;
		this.nombreEditorial = nombreEditorial;
		this.descripcionGenero = descripcionGenero;
	}	
	
	//Getters && Setters
	
	public long getIdEditorial() {
		return idEditorial;
	}
	public void setIdEditorial(long idEditorial) {
		this.idEditorial = idEditorial;
	}
	public String getNombreEditorial() {
		return nombreEditorial;
	}
	public void setNombreEditorial(String nombreEditorial) {
		this.nombreEditorial = nombreEditorial;
	}
	public String getDescripcionGenero() {
		return descripcionGenero;
	}
	public void setDescripcionGenero(String descripcionGenero) {
		this.descripcionGenero = descripcionGenero;
	}

	
}
