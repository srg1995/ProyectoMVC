package com.spring.proyectoCero.dto;

import java.io.Serializable;

public class Dato implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String identificador;
	
	private String nombre;
	
	public Dato() {super();}

	public String getId() {
		return identificador;
	}

	public void setId(String identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
