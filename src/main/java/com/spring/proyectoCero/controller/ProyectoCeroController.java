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
	
	/* hacemos la inyeccion del bean con el @Autowired
	 * creamos la variable datoServicio para poder acceder al servicio */
	@Autowired
	DatoService datoService;
	
	/**
	 * metodo que creamos para que nos devuelva una jsp mediante el metodo get
	 */
	@RequestMapping(value = "/principal", method = RequestMethod.GET)
	public String cargaIndex(){
		return "index";
	}
	
	
	/**
	 * metodo que creamos para que nos devuelva una jsp mediante el metodo get
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String cargaInicial(Model m){
		m.addAttribute("nombre","sergio");
		return "saludo";
	}
	
	/**
	 * metodo que creamos para ver si podemos OBTENER un valor de BBDD haciendo una invocacion al servicio
	 */
	@RequestMapping(value = "/testBBDD", method = RequestMethod.GET)
	public void obtenerValorBBDD(){
		Dato d = datoService.getDatoMapper("1");
		System.out.print(d.getNombre()+"ESTE ES EL VALOR");
	}
	
	/**
	 * metodo que creamos para ver si podemos INSERTAR un valor de BBDD haciendo una invocacion al servicio
	 */
	@RequestMapping(value = "/testBBDDInsertar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void insertarValorBBDD(@RequestBody Dato dato, BindingResult result){
		System.out.println(dato.getIdentificador()+"--"+dato.getNombre()+"--ESTE ES EL VALOR VAS A INSERTAR");
		
		datoService.insertarDato(dato, result);
	}
	
	/**
	 * metodo que creamos para ver si podemos ACTUALIZAR un valor de BBDD haciendo una invocacion al servicio
	 */
	@RequestMapping(value = "/testBBDDActualizar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void actualizarValorBBDD(@RequestBody Dato dato){
		System.out.println(dato.getIdentificador()+"--"+dato.getNombre()+"--ESTE ES EL VALOR VAS A ACTUALIZAR");
		
		datoService.actualizarDato(dato);
	}
	
	/**
	 * metodo que creamos para ver si podemos ELIMINAR un valor de BBDD haciendo una invocacion al servicio
	 */
	@RequestMapping(value = "/testBBDDBorrar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void borrarValorBBDD(@RequestBody Dato dato){
		System.out.println(dato.getIdentificador()+"--"+dato.getNombre()+"--ESTE ES EL VALOR VAS A ELIMINAR");
		
		datoService.borrarDato(dato.getNombre());
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
