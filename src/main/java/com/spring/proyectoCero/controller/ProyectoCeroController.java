package com.spring.proyectoCero.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.proyectoCero.dto.Dato;

@Controller("ProyectoCeroController")
public class ProyectoCeroController {
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String cargaInicial(){
		return "saludo";
	}
	
	@RequestMapping(value = "/test/body", method = RequestMethod.GET)
	@ResponseBody
	public String obtenerParametro(@RequestParam(value = "dato") String dato) {
	    return dato;
	}
	
	@RequestMapping(value = "/test/bodyjson", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String obtenerJson(@RequestBody Dato dato) {
	    return dato.getNombre();
	}
	
	@RequestMapping(value = "/test/bodyjson", method = RequestMethod.POST)
	@ResponseBody
	public String obtenerTextoPost(@RequestBody String dato) {
	    return dato;
	}
	
	
}
