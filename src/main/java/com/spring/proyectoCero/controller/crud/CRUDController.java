package com.spring.proyectoCero.controller.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@ResponseBody
	public void insertarValorBBDD(@RequestBody Dato dato, BindingResult result){
		System.out.println(dato.getIdentificador()+"--"+dato.getNombre()+"--ESTE ES EL VALOR VAS A INSERTAR");
		
		datoService.insertarDato(dato, result);
	}
	
	/**
	 * Metodo que creamos para ver si podemos OBTENER un valor de BBDD haciendo una invocacion al servicio
	 */
	@RequestMapping(value = "/testBBDD", method = RequestMethod.GET)
	public void obtenerValorBBDD(){
		Dato d = datoService.getDatoMapper("1");
		System.out.print(d.getNombre()+"ESTE ES EL VALOR");
	}
	
	/**
	 * Metodo que creamos para ver si podemos ACTUALIZAR un valor de BBDD haciendo una invocacion al servicio
	 */
	@RequestMapping(value = "/testBBDDActualizar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void actualizarValorBBDD(@RequestBody Dato dato){
		System.out.println(dato.getIdentificador()+"--"+dato.getNombre()+"--ESTE ES EL VALOR VAS A ACTUALIZAR");
		
		datoService.actualizarDato(dato);
	}
	
	/**
	 * Metodo que creamos para ver si podemos ELIMINAR un valor de BBDD haciendo una invocacion al servicio
	 */
	@RequestMapping(value = "/testBBDDBorrar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void borrarValorBBDD(@RequestBody Dato dato){
		System.out.println(dato.getIdentificador()+"--"+dato.getNombre()+"--ESTE ES EL VALOR VAS A ELIMINAR");
		
		datoService.borrarDato(dato.getNombre());
	}
}
