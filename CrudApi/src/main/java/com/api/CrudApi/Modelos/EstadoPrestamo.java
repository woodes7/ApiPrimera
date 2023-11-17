package com.api.CrudApi.Modelos;

import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class EstadoPrestamo {
	// ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado_prestamo", nullable = false)
	private Long idEstadoPrestamo;

	@Column(name = "codigo_estado", nullable = false)
	private int codigoEstado;

	@Column(name = "descripcion_estado_prestamo", nullable = false)
	private int IdUsuario;

	@Column(name="fch_inicio_prestamo")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fchInicioPresta;

	@Column(name="fch_fin_prestamo")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fchFinPresta;
	
	@Column(name="fch_entrega_prestamo")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fchEntregaPresta;
	@ManyToMany
	@JoinColumn(name = "id_usuario")
	Usuario usuario;

	// CONSTRUCTOR
	public EstadoPrestamo() {
		super();

	}

	public EstadoPrestamo(long idEstadoPrestamo, int codigoEstado, int idUsuario) {
		super();
		this.idEstadoPrestamo = idEstadoPrestamo;
		this.codigoEstado = codigoEstado;
		IdUsuario = idUsuario;
	}
	//Getters && Setters 

	public Long getIdEstadoPrestamo() {
		return idEstadoPrestamo;
	}

	public void setIdEstadoPrestamo(Long idEstadoPrestamo) {
		this.idEstadoPrestamo = idEstadoPrestamo;
	}

	public int getCodigoEstado() {
		return codigoEstado;
	}

	public void setCodigoEstado(int codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

	public int getIdUsuario() {
		return IdUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
	}

	public Calendar getFchInicioPresta() {
		return fchInicioPresta;
	}

	public void setFchInicioPresta(Calendar fchInicioPresta) {
		this.fchInicioPresta = fchInicioPresta;
	}

	public Calendar getFchFinPresta() {
		return fchFinPresta;
	}

	public void setFchFinPresta(Calendar fchFinPresta) {
		this.fchFinPresta = fchFinPresta;
	}

	public Calendar getFchEntregaPresta() {
		return fchEntregaPresta;
	}

	public void setFchEntregaPresta(Calendar fchEntregaPresta) {
		this.fchEntregaPresta = fchEntregaPresta;
	}
	
	

}
