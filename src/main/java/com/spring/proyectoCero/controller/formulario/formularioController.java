package com.spring.proyectoCero.controller.formulario;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.proyectoCero.dto.Dato;
import com.spring.proyectoCero.service.DatoService;

@Controller
@RequestMapping("/formulario")
public class formularioController {
	
	/** 
	 * Hacemos la inyeccion del bean con el @Autowired
	 * Creamos la variable datoServicio para poder acceder al servicio 
	 * */
	@Autowired
	private DatoService datoService;

	/** 
	 * Hacemos la inyeccion del bean con el @Autowired
	 * Creamos la variable MessageSource para poder internacionalizar los mensajes 
	 * */
	@Autowired
    private MessageSource ms;

	/**
	 * Metodo que creamos para que nos devuelva una jsp principal del formulario
	 * mediante el metodo get, con un modelo de objeto de tipo Dato
	 * 
	 * @param m modelo para permitir que interactue la parte back con el front
	 * @return devuelve la jsp indicada, pero pudiendo utilizar el tipo Dato en la misma
	 */
	@RequestMapping("/cargaInicial")
	public String cargaInicial(Model m){
		Dato d = new Dato();
		m.addAttribute("dato", d);
		return "formulario";
	}
	
	/**
	 * Metodo en el que validamos los datos que recibimos de la jsp,
	 * Lo validamos mediante el BindingResult, este objeto permite realizar las validaciones necesarias y ademas extiende de Errors
	 * 
	 * 
	 * @param d el parametro @valid Dato, se encarga de comprobar las validaciones que se encuentran en la clase Dato
	 * @param result permite que validemos y el se encargue de gestionar los errores
	 * @return puede devolver o bien un ok: redireccion a una pagina de OK, 
	 * o un KO: en este caso redireccionara a la misma pagina de formunlario, 
	 * con el objeto Errors relleno con los errores correspondientes
	 * 
	 * Este metodo devuelve un ModelAndView que se encarga de gestionar 
	 * las vistas con modelo incorporado para asi poder manejar estos objetos en la jsp
	 */
	@RequestMapping("/validarForm")
	public ModelAndView validarFormulario(@Valid Dato d, BindingResult result){
		ModelAndView model = new ModelAndView();
		model.addObject("dato", d);
		
		if(!result.hasErrors()){
			datoService.insertarDato(d, result);
		}
		
		model.setViewName(result.hasErrors() ? "formulario" : "formularioCorrecto");
		
		return model;
	}	
}
