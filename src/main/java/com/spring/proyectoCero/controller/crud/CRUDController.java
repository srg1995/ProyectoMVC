package com.spring.proyectoCero.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.proyectoCero.dto.Dato;
import com.spring.proyectoCero.service.DatoService;

@Controller
@RequestMapping("/crudController")
public class CRUDController {
	
	/** 
	 * Hacemos la inyeccion del bean con el @Autowired
	 * Creamos la variable datoServicio para poder acceder al servicio 
	 * */
	@Autowired
	DatoService datoService;

	
	/**
	 * Metodo que creamos para ver si podemos INSERTAR un valor de BBDD haciendo una invocacion al servicio
	 */
	@RequestMapping(value = "/testBBDDInsertar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String insertarValorBBDD(@RequestBody Dato dato, BindingResult result, Model m){
		System.out.println(dato.getIdentificador()+"--"+dato.getNombre()+"--ESTE ES EL VALOR VAS A INSERTAR");
		
		datoService.insertarDato(dato, result);
		
		m.addAttribute("dato", dato);
		m.addAttribute("tipoAccion", "INSERTAR");
		
		return "crud/objetoCrud"; 
	}
	
	/**
	 * Metodo que creamos para ver si podemos OBTENER un valor de BBDD haciendo una invocacion al servicio
	 */
	@RequestMapping(value = "/testBBDD", method = RequestMethod.GET)
	public String obtenerValorBBDD(Model m){
		Dato d = datoService.getDatoMapper("1");
		System.out.print(d.getNombre()+"ESTE ES EL VALOR");
		
		m.addAttribute("tipoAccion", "CONSULTAR");
		m.addAttribute("dato", d);
		return "crud/objetoCrud"; 
		
	}
	
	/**
	 * Metodo que creamos para ver si podemos ACTUALIZAR un valor de BBDD haciendo una invocacion al servicio
	 */
	@RequestMapping(value = "/testBBDDActualizar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String actualizarValorBBDD(@RequestBody Dato dato,Model m){
		System.out.println(dato.getIdentificador()+"--"+dato.getNombre()+"--ESTE ES EL VALOR VAS A ACTUALIZAR");
		
		datoService.actualizarDato(dato);
		
		m.addAttribute("tipoAccion", "ACTUALIZAR");
		m.addAttribute("dato", dato);
		return "crud/objetoCrud";
	}
	
	/**
	 * Metodo que creamos para ver si podemos ELIMINAR un valor de BBDD haciendo una invocacion al servicio
	 */
	@RequestMapping(value = "/testBBDDBorrar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String borrarValorBBDD(@RequestBody Dato dato, Model m){
		System.out.println(dato.getIdentificador()+"--"+dato.getNombre()+"--ESTE ES EL VALOR VAS A ELIMINAR");
		
		datoService.borrarDato(dato.getNombre());
		
		m.addAttribute("tipoAccion", "BORRAR");
		m.addAttribute("dato", dato);
		return "crud/objetoCrud";
	}
}
