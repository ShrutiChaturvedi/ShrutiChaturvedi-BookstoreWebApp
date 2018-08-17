package com.hsbc.bookstoreWebApp.controller;

import java.util.Map;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hsbc.bookstoreWebApp.model.Book;
import com.hsbc.bookstoreWebApp.service.BookstoreService;
import com.hsbc.bookstoreWebApp.service.BookstoreServiceImpl;
import com.hsbc.bookstoreWebApp.util.Constants;

@RestController
public class BookstoreRestController {
	
	private BookstoreService bookstoreService = new BookstoreServiceImpl(); //Service which will do all data retrieval/manipulation work
	
	@RequestMapping(value = Constants.SLASH_DELIMETER + Constants.URI_GET_BOOKS, method = RequestMethod.GET, headers=Constants.HEADER_MEDIA_TYPE)
	public Map<Long, Book> getBooks()
	{
		return bookstoreService.getBooks();
	}
 
	@RequestMapping(value = Constants.SLASH_DELIMETER + Constants.URI_BOOK + Constants.SLASH_DELIMETER + Constants.URI_ID, method = RequestMethod.GET, headers = Constants.HEADER_MEDIA_TYPE)
	public Book getBookById(@PathVariable long id) {
		return bookstoreService.getBook(id);
	}
 
	@RequestMapping(value = Constants.SLASH_DELIMETER + Constants.URI_CREATE_BOOK, method = RequestMethod.POST, headers = Constants.HEADER_MEDIA_TYPE)
	public Book createBook(@RequestBody Book newBook) {
		Assert.notNull(newBook.getId(), Constants.ERROR_ID_NOT_PRESENT);
		Assert.notNull(newBook.getTitle(), Constants.ERROR_TITLE_NOT_PRESENT);
		Assert.notNull(newBook.getDescription(), Constants.ERROR_DESC_NOT_PRESENT);
		Assert.notNull(newBook.getPrice(), Constants.ERROR_PRICE_NOT_PRESENT);
		Assert.notNull(newBook.getIsbn(), Constants.ERROR_PRICE_NOT_PRESENT);
		Assert.notNull(newBook.getLanguage(), Constants.ERROR_LANGUAGE_NOT_PRESENT);
		Book bookToBeCreated = new Book(newBook.getId(), newBook.getTitle(), newBook.getDescription(),
				newBook.getPrice(), newBook.getIsbn(), newBook.getLanguage());
		return bookstoreService.createBook(bookToBeCreated);
	}
 
	@RequestMapping(value = Constants.SLASH_DELIMETER + Constants.URI_UPDATE_BOOK, method = RequestMethod.PUT, headers = Constants.HEADER_MEDIA_TYPE)
	public Book updateBook(@RequestBody Book updateBook) {
		Assert.notNull(updateBook.getId(), Constants.ERROR_ID_NOT_PRESENT);
		Assert.notNull(updateBook.getTitle(), Constants.ERROR_TITLE_NOT_PRESENT);
		Assert.notNull(updateBook.getDescription(), Constants.ERROR_DESC_NOT_PRESENT);
		Assert.notNull(updateBook.getPrice(), Constants.ERROR_PRICE_NOT_PRESENT);
		Assert.notNull(updateBook.getIsbn(), Constants.ERROR_PRICE_NOT_PRESENT);
		Assert.notNull(updateBook.getLanguage(), Constants.ERROR_LANGUAGE_NOT_PRESENT);
		
		Book bookToBeUpdated = bookstoreService.getBook(updateBook.getId());

		Assert.notNull(bookToBeUpdated, Constants.ERROR_BOOK_IS_NOT_PRESENT);
		
		bookToBeUpdated.setId(updateBook.getId());
		bookToBeUpdated.setTitle(updateBook.getTitle());
		bookToBeUpdated.setDescription(updateBook.getDescription());
		bookToBeUpdated.setPrice(updateBook.getPrice());
		bookToBeUpdated.setIsbn(updateBook.getIsbn());
		bookToBeUpdated.setLanguage(updateBook.getLanguage());

		return bookstoreService.updateBook(bookToBeUpdated);
	}
 
	@RequestMapping(value = Constants.SLASH_DELIMETER + Constants.URI_BOOK + Constants.SLASH_DELIMETER + Constants.URI_ID, method = RequestMethod.DELETE, headers = Constants.HEADER_MEDIA_TYPE)
	public Book deleteBook(@PathVariable("id") long id) {
		Assert.notNull(id, Constants.ERROR_ID_NOT_PRESENT);
		Assert.notNull(bookstoreService.getBook(id), Constants.ERROR_BOOK_IS_NOT_PRESENT);
		return bookstoreService.deleteBook(id);
	} 

}
