package com.spring.proyectoCero.internacionalizar;

import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.context.i18n.LocaleContextHolder;

public class Internacionalizador {
	public String devolverMensajeInternacionalizado(String mensaje) {
		Locale locale = LocaleContextHolder.getLocale();
		ResourceBundle ms = ResourceBundle.getBundle("i18n/mensajes", new Locale("es"));
		return ms.getString(mensaje);
	}
}
