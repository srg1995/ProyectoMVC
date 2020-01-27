package com.spring.proyectoCero.service;

import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.spring.proyectoCero.constantes.Constantes;
import com.spring.proyectoCero.dto.Dato;
import com.spring.proyectoCero.mapper.DatoMapper;

public class DatoService {

	/* hacemos la inyeccion del bean con el @Autowired
	 * creamos el la variable datoMapper para poder acceder al mapeo de acceso a la bbdd */
	@Autowired
	private DatoMapper datoMapper;

	
	/**
	 * IMPORTANTE
	 * Para que no nos devuelva un error el mapper, necesitamos crear el getter y el setter para poder acceder a bean
	 * */
	
	/**
	 * 
	 * @return
	 */
	public DatoMapper getDatoMapper() {
		return datoMapper;
	}

	/**
	 * 
	 * @param datoMapper
	 */
	public void setDatoMapper(DatoMapper datoMapper) {
		this.datoMapper = datoMapper;
	}
	
	/**
	 * Metodo que devuelve un Dato de BBDD, que se obtiene mediante el identificador del mismo
	 * @param id lo utilizamos para sobre que dato vamos a hacer la consulta de la bbdd
	 * @return devolvemos el objeto tipo Dato, que hemos obtenido de la bbdd(en caso de que exista)
	 */
	public Dato getDatoMapper(String id) {
		return datoMapper.getDato(id);
	}
	
	/**
	 * Metodo que devuelve al controller la respuesta que obtiene de la BBDD, bien sea un OK o un KO
	 * 
	 * @param d
	 * @param result
	 * @return devuelve el resultado obtenido por BBDD
	 * 
	 */
	public BindingResult insertarDato(Dato d, BindingResult result) {

		ResourceBundle messages = ResourceBundle.getBundle("i18n/mensajes", LocaleContextHolder.getLocale());
		try {
			datoMapper.insertarDato(d);
	    } catch (DuplicateKeyException e) {
	    	FieldError fe = new FieldError("identificador","identificador",messages.getString(Constantes.CLAVE_REPETIDA));
	    	result.addError(fe);
	    }
		return result;
	}
	
	/**
	 * Metodo para actualizar un dato de la BBDD, teniendo como referencia el identificador
	 * @param d
	 */
	public void actualizarDato(Dato d) {
		datoMapper.actualizarDato(d);
	}
	
	/**
	 * Metodo para borrar un dato de la BBDD, teniendo como referencia el nombre del mismo
	 * @param d
	 */
	public void borrarDato(String nombre) {
		datoMapper.borrarDato(nombre);
	}
}
