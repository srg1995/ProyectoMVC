package com.spring.proyectoCero.mapper;

import com.spring.proyectoCero.dto.Dato;

/**
 * 
 * @author sergio
 *
 *	creamos la interfaz del DatoMapper
 *	las consultas las crearemos en el xml propio que se encuentra en el mismo paquete de mapper
 */
public interface DatoMapper {
	public Dato getDato(String identificador);
	
	public void insertarDato(Dato d);
	public void actualizarDato(Dato d);
	public void borrarDato(String nombre);
	
}

