package com.api.CrudApi.Modelos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="autor", schema="gbp_almacen")
public class Autor {
	
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_autor", nullable = false)
	private long idAutor;

	@Column(name = "nombre_autor", nullable = false)
	private String nombreAutor;

	@Column(name = "apellidos_autor")
	private String apellidosAutor;
	
	@OneToMany(mappedBy="genero")
	List<Libro> libros;	
	//Constructor

	public Autor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Autor(long idAutor, String nombreAutor, String apellidosAutor) {
		super();
		this.idAutor = idAutor;
		this.nombreAutor = nombreAutor;
		this.apellidosAutor = apellidosAutor;
	}
	
	//Getters &&Setters
	public long getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(long idAutor) {
		this.idAutor = idAutor;
	}
	public String getNombreAutor() {
		return nombreAutor;
	}
	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}
	public String getApellidosAutor() {
		return apellidosAutor;
	}
	public void setApellidosAutor(String apellidosAutor) {
		this.apellidosAutor = apellidosAutor;
	}
	
	
}
