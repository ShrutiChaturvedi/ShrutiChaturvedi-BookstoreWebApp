package com.hsbc.bookstoreWebApp.model;

import java.io.Serializable;

public class Book implements Serializable{

	private static final long serialVersionUID = 1773345214104050752L;
	private Long id;
    private String title;
    private String description;
    private Long price;
    private String isbn;
    private Language language;
    
	public Book() {
		super();
	}
    
	/**
	 * @param id
	 * @param title
	 * @param description
	 * @param price
	 * @param isbn
	 * @param language
	 */
	public Book(Long id, String title, String description, Long price, String isbn, Language language) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.isbn = isbn;
		this.language = language;
	}
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	
	@Override
	public String toString() {
		return "Book [" + (id != null ? "id=" + id + ", " : "") + (title != null ? "title=" + title + ", " : "")
				+ (description != null ? "description=" + description + ", " : "")
				+ (price != null ? "price=" + price + ", " : "") + (isbn != null ? "isbn=" + isbn + ", " : "")
				+ (language != null ? "language=" + language : "") + "]";
	}

}
