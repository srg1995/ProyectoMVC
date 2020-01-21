package com.spring.proyectoCero.dto;

public class Excel {
	private String title;
    private String author;
    private String isbn;
    private String publishedDate;
    private float price;
 
    public Excel(String title, String author, String isbn, String publishedDate,
            float price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
        this.price = price;
    }
}
