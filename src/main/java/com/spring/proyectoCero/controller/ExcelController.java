package com.spring.proyectoCero.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.proyectoCero.dto.Excel;

@Controller("ExcelProyectoCeroController")
public class ExcelController {
	/**
     * Handle request to download an Excel document
     */
	@GetMapping("/downloadExcel")
    public ModelAndView downloadExcel() {
        // create some sample data
        List<Excel> listBooks = new ArrayList<Excel>();
        listBooks.add(new Excel("Effective Java", "Joshua Bloch", "0321356683", "May 28, 2008", 38.11F));
        listBooks.add(new Excel("Head First Java", "Kathy Sierra & Bert Bates", "0596009208", "February 9, 2005", 30.80F));
        listBooks.add(new Excel("Java Generics and Collections","Philip Wadler", "0596527756", "Oct 24, 2006", 29.52F));
        listBooks.add(new Excel("Thinking in Java", "Bruce Eckel", "0596527756", "February 20, 2006", 43.97F));
        listBooks.add(new Excel("Spring in Action", "Craig Walls", "1935182358", "June 29, 2011", 31.98F));
 
        // return a view which will be resolved by an excel view resolver
        return new ModelAndView("excel", "listBooks", listBooks);
    }
    
    @RequestMapping(value = "/hola", method = RequestMethod.GET)
    public String hola() {
    	return "saludo";
    }
}
