package com.spring.proyectoCero.dto;

import java.io.Serializable;

public class Dato implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String identificador;
	
	private String nombre;
	
	public Dato() {}

	/**
	 * 
	 * @return
	 */
	public String getId() {
		return identificador;
	}

	/**
	 * 
	 * @param identificador
	 */
	public void setId(String identificador) {
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
