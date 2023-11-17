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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="autor", schema="gbp_almacen")
public class Prestamo {

	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prestamo", nullable = false)
	private long idPrestamo;

	@Column(name = "id_usuario")
	private int IdUsuario;

	@Column(name = "fch_inicio_prestamo")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fchInicioPrestamo;

	@Column(name = "fhc_fin_prestamo")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fchFinPrestamo;

	@Column(name = "fhc_entrega_prestamo")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fchEntregaPrestamo;

	@Column(name = "cantidad", nullable = false)
	private int cantidad;

	// Relación Usuario-Prestamos
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	Usuario usuario;

	// Relación Prestamo-EstadoPrestamo
	@ManyToOne
	@JoinColumn(name = "id_estado_prestamo")
	EstadoPrestamo estadoPresta;

	// Relación Libro-Prestamo
	@ManyToMany(cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE })

	@JoinTable(name = "rel_libro_prestamo", schema = "gbp_operacional2", joinColumns = {
			@JoinColumn(name = "id_libro") }, inverseJoinColumns = { @JoinColumn(name = "id_prestamo") })
	private List<Libro> prestamoLibro;

	// CONSTRUCTORES
	public Prestamo() {
		super();
		
	}

	public Prestamo(long idPrestamo, int idUsuario, Calendar fchInicioPrestamo, Calendar fchFinPrestamo,
			Calendar fchEntregaPrestamo, int cantidad, List<Libro> prestamoLibro) {
		super();
		this.idPrestamo = idPrestamo;
		IdUsuario = idUsuario;
		this.fchInicioPrestamo = fchInicioPrestamo;
		this.fchFinPrestamo = fchFinPrestamo;
		this.fchEntregaPrestamo = fchEntregaPrestamo;
		this.cantidad = cantidad;
		this.prestamoLibro = prestamoLibro;
	}
	// GETTERS & SETTERS

	public long getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(long idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public int getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}

	public Calendar getFchInicioPrestamo() {
		return fchInicioPrestamo;
	}

	public void setFchInicioPrestamo(Calendar fchInicioPrestamo) {
		this.fchInicioPrestamo = fchInicioPrestamo;
	}

	public Calendar getFchFinPrestamo() {
		return fchFinPrestamo;
	}

	public void setFchFinPrestamo(Calendar fchFinPrestamo) {
		this.fchFinPrestamo = fchFinPrestamo;
	}

	public Calendar getFchEntregaPrestamo() {
		return fchEntregaPrestamo;
	}

	public void setFchEntregaPrestamo(Calendar fchEntregaPrestamo) {
		this.fchEntregaPrestamo = fchEntregaPrestamo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public List<Libro> getPrestamoLibro() {
		return prestamoLibro;
	}

	public void setPrestamoLibro(List<Libro> prestamoLibro) {
		this.prestamoLibro = prestamoLibro;
	}

	
}
