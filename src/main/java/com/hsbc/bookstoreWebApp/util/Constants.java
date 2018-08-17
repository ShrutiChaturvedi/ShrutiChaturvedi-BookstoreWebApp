package com.hsbc.bookstoreWebApp.util;

public class Constants {
	
	//URI
	public static final String SLASH_DELIMETER = "/";
	public static final String URI_GET_BOOKS = "books";
	public static final String URI_BOOK = "book";
	public static final String URI_CREATE_BOOK = "createBook";
	public static final String URI_UPDATE_BOOK = "updateBook";
	public static final String URI_ID = "{id}";
	
	//MediaType
	public static final String HEADER_MEDIA_TYPE = "Accept=application/json";
	
	//Error Messages
	public static final String ERROR_ID_NOT_PRESENT = "ID is not present in the Book object";
	public static final String ERROR_TITLE_NOT_PRESENT = "TITLE is not present in the Book object";
	public static final String ERROR_DESC_NOT_PRESENT = "DESCRIPTION is not present in the Book object";
	public static final String ERROR_PRICE_NOT_PRESENT = "PRICE is not present in the Book object";
	public static final String ERROR_ISBN_NOT_PRESENT = "ISBN is not present in the Book object";
	public static final String ERROR_LANGUAGE_NOT_PRESENT = "LANGUAGE is not present in the Book object";
	public static final String ERROR_BOOK_IS_NOT_PRESENT = "The book requested to be created/updated is not present in the book repository";
}
