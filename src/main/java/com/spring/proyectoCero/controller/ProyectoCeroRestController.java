package com.spring.proyectoCero.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProyectoCeroRestController {

	@GetMapping(value = "/restController")
	public String cargaInicialRest() {
		
		return "saludoRest";
	}
	
	@GetMapping(value = "/restController/get")
	public String cargaInicialRest(@RequestParam(name = "nombre", required = false, defaultValue = "none") String nombre) {
		
		return nombre;
	}
}
