package com.api.CrudApi.Modelos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="generos", schema="gbp_almacen")
public class Genero {
	
	//Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_genero", nullable = false)
	private long idGenero;

	@Column(name = "nombre_genero", nullable = false)
	private String nombreGenero;

	@Column(name = "descripcion_genero")
	private String descripcionGenero;
	
	@OneToMany(mappedBy="genero")
	List<Libro> librosGenero;
	
	//Constructores
	
	public Genero() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Genero(long idGenero, String nombreGenero, String descripcionGenero) {
		super();
		this.idGenero = idGenero;
		this.nombreGenero = nombreGenero;
		this.descripcionGenero = descripcionGenero;
	}

	//Getters && Setters
	public long getIdLibro() {
		return idGenero;
	}

	public void setIdLibro(long idLibro) {
		this.idGenero = idLibro;
	}

	public String getNombreGenero() {
		return nombreGenero;
	}

	public void setNombreGenero(String nombreGenero) {
		this.nombreGenero = nombreGenero;
	}

	public String getDescripcionGenero() {
		return descripcionGenero;
	}

	public void setDescripcionGenero(String descripcionGenero) {
		this.descripcionGenero = descripcionGenero;
	}
	
}
