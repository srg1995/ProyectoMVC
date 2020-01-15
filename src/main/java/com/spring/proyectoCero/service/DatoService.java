package com.spring.proyectoCero.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.proyectoCero.dto.Dato;
import com.spring.proyectoCero.mapper.DatoMapper;

public class DatoService {

	/* hacemos la inyeccion del bean con el @Autowired
	 * creamos el la variable datoMapper para poder acceder al mapeo de acceso a la bbdd */
	@Autowired
	private DatoMapper datoMapper;

	/* IMPORTANTE
	 * Para que no nos devuelva un error el mapper, necesitamos crear el getter y el setter para poder acceder a bean
	 * */
	/**
	 * 
	 * @return
	 */
	public DatoMapper getDatoMapper() {
		return datoMapper;
	}

	/**
	 * 
	 * @param datoMapper
	 */
	public void setDatoMapper(DatoMapper datoMapper) {
		this.datoMapper = datoMapper;
	}
	
	/**
	 * 
	 * @param id lo utilizamos para sobre que dato vamos a hacer la consulta de la bbdd
	 * @return devolvemos el objeto tipo Dato, que hemos obtenido de la bbdd(en caso de que exista)
	 */
	public Dato getDatoMapper(String id) {
		return datoMapper.getDato(id);
	}
}
