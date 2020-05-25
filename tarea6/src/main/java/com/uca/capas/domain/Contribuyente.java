package com.uca.capas.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "public", name ="contribuyente")
public class Contribuyente {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "c_contribuyente")
	private Integer codigoContribuyente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_importancia")
	private Importancia importancia;
	
	@Size(message = "El nombre no debe tener mas de 50 caracteres", max = 30)
	@NotEmpty(message ="Este campo no puede estar vacio.")
	@Column(name = "s_nombre")
	private String Nombre;
	
	@Size(message = "El nombre no debe tener mas de 50 caracteres", max = 30)
	@NotEmpty(message ="Este campo no puede estar vacio.")
	@Column(name = "s_apellido")
	private String Apellido;
	
	@Pattern(regexp = "^[0-9]{14}$", message = "El NIT debe tener exactamente 14 digitos")
	@NotEmpty(message ="Este campo no puede estar vacio.")
	@Column(name = "s_nit")
	private String nit;
	
	@Column(name = "f_fecha_ingreso")
	private LocalDate fechaIngreso;

	public Contribuyente() {
		super();
	}

	public Integer getCodigoContribuyente() {
		return codigoContribuyente;
	}

	public void setCodigoContribuyente(Integer codigoContribuyente) {
		this.codigoContribuyente = codigoContribuyente;
	}

	public Importancia getImportancia() {
		return importancia;
	}

	public void setImportancia(Importancia importancia) {
		this.importancia = importancia;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	public String getFechaDelegate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fechaI = dtf.format(this.fechaIngreso);
	    return fechaI;
	}

}
