package com.spring.proyectoCero.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProyectoCeroRestController {

	/**
	 * 
	 * @return
	 */
	@GetMapping(value = "/restController")
	public String cargaInicialRest() {
		
		return "saludoRest";
	}
}
