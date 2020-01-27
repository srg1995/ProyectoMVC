package com.spring.proyectoCero.controller.json;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.proyectoCero.dto.Dato;

@Controller("ProyectoCeroJsonController")
@RequestMapping("/ProyectoCeroJsonController")
public class ProyectoCeroControllerJson {

	/**
	 * 
	 * Metodo que recoge un JSON por medio del consumes y lo devuelve por el produces
	 * 
	 * @param dato
	 * @return el mismo objeto enviado el JSON
	 */
	@PostMapping(value = "/test/bodyjson", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Dato obtenerJson(@RequestBody Dato dato) {
		return dato;
	}
}
