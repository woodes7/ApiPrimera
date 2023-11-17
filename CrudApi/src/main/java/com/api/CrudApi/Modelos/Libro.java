package com.api.CrudApi.Modelos;

import java.util.Calendar;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="libros", schema="gbp_almacen")
public class Libro {

	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_libro", nullable = false)
	private long idLibro;

	@Column(name = "isbn_libro", nullable = false)
	private String idbnLibro;

	@Column(name = "titulo_libro")
	private String tituloLibro;

	@Column(name = "imagen_libro")
	private byte imagenLibro;

	@Column(name = "edicion_libro")
	private String edicionLibro;

	@Column(name = "editorial_libro")
	private String editorialLibro;

	@Column(name = "id_coleccion")
	private int idColeccion;

	@Column(name = "cantidad_libro")
	private int cantiadLibro;

	// Relacion libro-Editorial
	@ManyToOne
	@JoinColumn(name = "id_editorial")
	Editorial editorial;

	// Relacion libro-Genero
	@ManyToOne
	@JoinColumn(name = "id_genero")
	Genero genero;

	// Relacion libro-Colección
	@ManyToOne
	@JoinColumn(name = "id_coleccion")
	Coleccion coleccion;

	// Relacion Libro-Prestamo
	@ManyToMany(mappedBy = "prestamoLibro")
	private List<Prestamo> prestamo;

	// Relacion Autores-Libro
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "Rel_Autores_Libros", schema = "gbp_almacen", joinColumns = @JoinColumn(name = "id_libro"), inverseJoinColumns = @JoinColumn(name = "id_autor"))
	private List<Autor> libroAutor;

	// CONSTRUCTOR

	public Libro() {
		super();

	}

	public Libro(long idLibro, String idbnLibro, String tituloLibro, byte imagenLibro, String edicionLibro,
			String editorialLibro, int idColeccion, int cantiadLibro) {
		super();
		this.idLibro = idLibro;
		this.idbnLibro = idbnLibro;
		this.tituloLibro = tituloLibro;
		this.imagenLibro = imagenLibro;
		this.edicionLibro = edicionLibro;
		this.editorialLibro = editorialLibro;
		this.idColeccion = idColeccion;
		this.cantiadLibro = cantiadLibro;
	}

	// GETTERS & SETTERS

	public long getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(long idLibro) {
		this.idLibro = idLibro;
	}

	public String getIdbnLibro() {
		return idbnLibro;
	}

	public void setIdbnLibro(String idbnLibro) {
		this.idbnLibro = idbnLibro;
	}

	public String getTituloLibro() {
		return tituloLibro;
	}

	public void setTituloLibro(String tituloLibro) {
		this.tituloLibro = tituloLibro;
	}

	public byte getImagenLibro() {
		return imagenLibro;
	}

	public void setImagenLibro(byte imagenLibro) {
		this.imagenLibro = imagenLibro;
	}

	public String getEdicionLibro() {
		return edicionLibro;
	}

	public void setEdicionLibro(String edicionLibro) {
		this.edicionLibro = edicionLibro;
	}

	public String getEditorialLibro() {
		return editorialLibro;
	}

	public void setEditorialLibro(String editorialLibro) {
		this.editorialLibro = editorialLibro;
	}

	public int getIdColeccion() {
		return idColeccion;
	}

	public void setIdColeccion(int idColeccion) {
		this.idColeccion = idColeccion;
	}

	public int getCantiadLibro() {
		return cantiadLibro;
	}

	public void setCantiadLibro(int cantiadLibro) {
		this.cantiadLibro = cantiadLibro;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Coleccion getColeccion() {
		return coleccion;
	}

	public void setColeccion(Coleccion coleccion) {
		this.coleccion = coleccion;
	}

	public List<Prestamo> getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(List<Prestamo> prestamo) {
		this.prestamo = prestamo;
	}

	public List<Autor> getLibroAutor() {
		return libroAutor;
	}

	public void setLibroAutor(List<Autor> libroAutor) {
		this.libroAutor = libroAutor;
	}

}
