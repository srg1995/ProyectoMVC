package com.spring.proyectoCero.dto;

import java.io.Serializable;

public class Dato implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String nombre;
	
	public Dato() {super();}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
