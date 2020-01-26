package com.spring.proyectoCero.controller;

import java.util.Locale;

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
	
	@Autowired
	private DatoService datoService;

	@Autowired
    private MessageSource ms;

	@RequestMapping("/cargaInicial")
	public String cargaInicial(Model m){
		Dato d = new Dato();
		m.addAttribute("dato", d);
		return "formulario";
	}
	
	
	@RequestMapping("validarForm")
	public ModelAndView validarFormulario(@Valid Dato d, BindingResult result){
		ModelAndView model = new ModelAndView();
		model.addObject("dato", d);
		
		if(!result.hasErrors()){
			datoService.insertarDato(d, result);
		}
		
		model.setViewName(result.hasErrors() ? "formulario" : "formularioCorrecto");
		
		return model;
	}
	
	
	@RequestMapping("validarFormString")
	public String validarFormularioString(@Valid Dato d, BindingResult result,Model m){

		if(!result.hasErrors()){
				datoService.insertarDato(d, result);
				return "formularioCorrecto";
		}
		m.addAttribute("hola",ms.getMessage("clave.duplicada", null, new Locale("es")) );
		return "formulario";
	}
	
	
}
