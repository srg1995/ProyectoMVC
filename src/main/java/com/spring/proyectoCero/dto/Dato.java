package com.spring.proyectoCero.dto;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Dato implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Pattern(regexp = "[0-9]{1}", message = "{i18n.error.clave.repetida}")
	private String identificador;
	
	@Size(min = 1, max = 20, message = "{i18n.error.clave.repetida}" )
	@NotBlank
	private String nombre;
	
	public Dato() {}

	/**
	 * 
	 * @return
	 */
	public String getIdentificador() {
		return identificador;
	}

	/**
	 * 
	 * @param identificador
	 */
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
