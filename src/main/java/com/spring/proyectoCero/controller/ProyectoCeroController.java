package com.spring.proyectoCero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.proyectoCero.dto.Dato;
import com.spring.proyectoCero.service.DatoService;


@Controller("ProyectoCeroController")
public class ProyectoCeroController {
	
	/**
	 * Hacemos la inyeccion del bean con el @Autowired
	 * Creamos la variable datoServicio para poder acceder al servicio 
	 * */
	@Autowired
	DatoService datoService;
	
	/**
	 * Metodo que creamos para que nos devuelva una jsp mediante el metodo get
	 */
	@RequestMapping(value = "/principal", method = RequestMethod.GET)
	public String cargaIndex(){
		return "index";
	}
	
	
	/**
	 * Metodo que creamos para que nos devuelva una jsp mediante el metodo get
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String cargaInicial(Model m){
		m.addAttribute("nombre","sergio");
		return "saludo";
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
