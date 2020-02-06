package com.spring.proyectoCero.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

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
	 * Metodo que creamos para testear que funciona la resolucion de errores 404
	 */
	@RequestMapping(value = "/testError404", method = RequestMethod.GET)
	public String cargaInicial404(){
		return "xxx";
	}
	
	/**
	 * Metodo que creamos para testear que funciona la resolucion de errores 500
	 */
	@RequestMapping(value = "/testError500", method = RequestMethod.GET)
	public String cargaInicial500(){
		datoService.borrarDato("pepito");
		return "xxx";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value = "/locale", method = RequestMethod.GET)
	public String locale(Model m){
		m.addAttribute("zonaHoraria", LocaleContextHolder.getTimeZone());
		m.addAttribute("idioma", LocaleContextHolder.getLocale());
		
		return "locale";
	}

	/**
	 * 
	 */
	@RequestMapping(value = "/formFichero", method = RequestMethod.GET)
	public String formFichero(Model m){
		Dato dato = new Dato();
		m.addAttribute("dato", dato);
		return "subidaArchivo";
		
	}
	
	
	
	/**
	 * 
	 */
	@RequestMapping(value = "/recogerFichero", method = RequestMethod.POST)
	public void recogerFichero(Dato d, BindingResult result){
		
		System.out.print(result);
		
		/*if (!mf.isEmpty()) {
			   try {
			    byte[] bytes = mf.getBytes();
			    // Crear el directorio para almacenar el archivo
			    String rootPath = System.getProperty("catalina.home");
			    File dir = new File(rootPath + File.separator + "tmpFiles");
			    
			    if (!dir.exists())
			     dir.mkdirs();

			    // Crear documento en el servidor
			    File serverFile = new File(dir.getAbsolutePath() + File.separator + mf.getOriginalFilename());
			    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			    stream.write(bytes);
			    stream.close();

			    System.out.println("Ubicación de documento = " + serverFile.getAbsolutePath());

			    System.out.println("Documento subido correctamente = " + mf.getOriginalFilename() + " Ubicacion del Archivo = " + serverFile.getAbsolutePath());
			   } catch (Exception e) {
				   System.out.println("Ocurrio un error al subir documento" + mf.getOriginalFilename() + " => " + e.getMessage());
			   }
			  } else {
				  System.out.println("Ocurrio un error al subir " + mf.getOriginalFilename() + " documento vacio.");
			  }*/
		
	}
	
}
