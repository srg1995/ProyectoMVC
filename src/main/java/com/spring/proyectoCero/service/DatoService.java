package com.spring.proyectoCero.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.proyectoCero.mapper.DatoMapper;

public class DatoService {

	@Autowired
	private DatoMapper datoMapper;
	
	public DatoMapper getDatoMapper(String id) {
		datoMapper.getDato();
		return datoMapper;
	}
}
