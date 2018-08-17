package com.hsbc.bookstoreWebApp.test;

import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.hsbc.bookstoreWebApp.model.Book;
import com.hsbc.bookstoreWebApp.model.Language;
import com.hsbc.bookstoreWebApp.util.Constants;

public class BookstoreRestControllerTest {

	public static final String REST_SERVICE_URI = "http://localhost:8080/bookstoreWebApp";
	public static final String GET_BOOK_ID = "1001";
	public static final String DELETE_BOOK_ID = "1007";
	
	/* GET */
	@SuppressWarnings("unchecked")
	private static void shouldGetAllBooks(){
		System.out.println("Testing getAllBooks API-----------");
		RestTemplate restTemplate = new RestTemplate();
		String uriToBeTested = REST_SERVICE_URI + Constants.SLASH_DELIMETER + Constants.URI_GET_BOOKS;
		Map<String, Object> books = restTemplate.getForObject(uriToBeTested, Map.class);
		if(books!=null){
			books.forEach((k,v)->System.out.println("Book Id : " + k + " Book Details : " + v));
		}else{
			System.out.println("No book exist----------");
		}
	}
	
	/* GET */
	private static void shouldGetBookWithId(){
		System.out.println("Testing getBook API----------");
		RestTemplate restTemplate = new RestTemplate();
		String uriToBeTested = REST_SERVICE_URI + Constants.SLASH_DELIMETER + Constants.URI_BOOK + Constants.SLASH_DELIMETER + GET_BOOK_ID ;
        Book book = restTemplate.getForObject(uriToBeTested, Book.class);
        System.out.println(book);
	}
	
	/* POST */
    private static void shouldCreateBook() {
		System.out.println("Testing create Book API----------");
    	RestTemplate restTemplate = new RestTemplate();
        Book bookToBeCreated = new Book(new Long("1007"), "Treasure Hunt", "Fiction", new Long("100"), "88965625696", Language.ENGLISH);
        String uriToBeTested = REST_SERVICE_URI + Constants.SLASH_DELIMETER + Constants.URI_CREATE_BOOK;
        restTemplate.postForLocation(uriToBeTested, bookToBeCreated, Book.class);
        System.out.println(bookToBeCreated);
    }

    /* PUT */
    private static void shouldUpdateBook() {
		System.out.println("Testing update Book API----------");
        RestTemplate restTemplate = new RestTemplate();
        Book updatedBook  = new Book(new Long("1007"), "Happy", "Happy", new Long("100"), "88965625696", Language.ENGLISH);
        String uriToBeTested = REST_SERVICE_URI + Constants.SLASH_DELIMETER + Constants.URI_UPDATE_BOOK;
        restTemplate.put(uriToBeTested, updatedBook);
        System.out.println(updatedBook);
    }

    /* DELETE */
    private static void shouldDeleteBook() {
		System.out.println("Testing delete Book API----------");
        RestTemplate restTemplate = new RestTemplate();
        String uriToBeTested = REST_SERVICE_URI + Constants.SLASH_DELIMETER + Constants.URI_BOOK + Constants.SLASH_DELIMETER +  DELETE_BOOK_ID; 
        restTemplate.delete(uriToBeTested);
        System.out.println("Testing delete Book API Completed----------");
    }

    public static void main(String args[]){
    	shouldGetAllBooks();
    	shouldGetBookWithId();
    	shouldCreateBook();
    	shouldUpdateBook();
    	shouldDeleteBook();
    	shouldGetAllBooks();
    }
	
}
