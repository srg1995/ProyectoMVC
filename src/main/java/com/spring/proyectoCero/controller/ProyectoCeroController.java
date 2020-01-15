package com.spring.proyectoCero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.proyectoCero.dto.Dato;
import com.spring.proyectoCero.service.DatoService;


@Controller("ProyectoCeroController")
public class ProyectoCeroController {
	
	/* hacemos la inyeccion del bean con el @Autowired
	 * creamos la variable datoServicio para poder acceder al servicio */
	@Autowired
	DatoService datoService;
	
	/**
	 * metodo que creamos para que nos devuelva una jsp mediante el metodo get
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String cargaInicial(){
		return "saludo";
	}
	
	/**
	 * metodo que creamos para ver si podemos obtener un valor de BBDD haciendo una invocacion al servicio
	 */
	@RequestMapping(value = "/testBBDD", method = RequestMethod.GET)
	public void obtenerValorBBDD(){
		Dato d = datoService.getDatoMapper("1");
		System.out.print(d.getNombre()+"ESTE ES EL VALOR");
	}
	
	/**
	 * 
	 * @param dato
	 * @return
	 */
	@RequestMapping(value = "/test/body", method = RequestMethod.GET)
	@ResponseBody
	public String obtenerParametro(@RequestParam(value = "dato") String dato) {
	    return dato;
	}
	
	/**
	 * 
	 * @param dato
	 * @return
	 */
	@RequestMapping(value = "/test/bodyjson", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String obtenerJson(@RequestBody Dato dato) {
	    return dato.getNombre();
	}
	
	/**
	 * 
	 * @param dato
	 * @return
	 */
	@RequestMapping(value = "/test/bodyjson", method = RequestMethod.POST)
	@ResponseBody
	public String obtenerTextoPost(@RequestBody String dato) {
	    return dato;
	}
	

	
}
