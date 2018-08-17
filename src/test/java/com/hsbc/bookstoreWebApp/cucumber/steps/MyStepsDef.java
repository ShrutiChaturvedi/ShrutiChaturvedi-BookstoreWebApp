package com.hsbc.bookstoreWebApp.cucumber.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import com.hsbc.bookstoreWebApp.model.Book;
import com.hsbc.bookstoreWebApp.model.Language;
import com.hsbc.bookstoreWebApp.service.BookstoreService;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepsDef {

	private BookstoreService bookstoreService;
	
	private Map<Long, Book> books;

	public MyStepsDef(BookstoreService bookstoreService) {
		this.bookstoreService = bookstoreService;
	}

	@Given("^I call get books api$")
	public void callGetBooksApi() throws Throwable {
		books = bookstoreService.getBooks();
		assertNotNull(books);
	}

	@Then("^I should get a list of books$")
	public void shouldGetAListOfBooks() throws Throwable {
		assertEquals(books.size(), 4);
	}

	@Given("^I add a book with id (.*), title (.*), description (.*), isbn (.*), price (.*) and language (.*)$")
	public void addABookWithIdAndName(String id, String title, String description, String isbn, String price, String language) throws Throwable {
		Book newBook = new Book();
		newBook.setId(new Long(id));
		newBook.setTitle(title);
		newBook.setDescription(description);
		newBook.setIsbn(isbn);
		newBook.setPrice(new Long(price));
		newBook.setLanguage(Language.valueOf(language));
		bookstoreService.createBook(newBook);
		
		assertNotNull(bookstoreService.getBook(newBook.getId()));
	}

	
	@Then("^I should be able to find this book in the system by id (.*)$")
	public void shouldHaveABookWithId(String id) throws Throwable {
		Book book = bookstoreService.getBook(new Long(id));
		assertTrue(!book.getTitle().isEmpty());
	}

	@Given("^I update a book with id (.*) with a new title (.*)$")
	public void updateABookWithNewName(String id, String title) throws Throwable {
		Book updatedBook = new Book();
		updatedBook.setId(Long.parseLong(id));
		updatedBook.setTitle(title);

		bookstoreService.updateBook(updatedBook);
	}

	
	@Then("^A book with id (.*) should have a title (.*)$")
	public void aBookWithIdShouldHaveAName(String id, String title) throws Throwable {
		assertTrue(bookstoreService.getBook(Long.parseLong(id)).getTitle().equals(title));
	}
	
	
	@When("^I delete a book with id (.*)$")
	public void deleteABookWithId(String id) throws Throwable {
		Book deletedBook = bookstoreService.deleteBook(Long.parseLong(id));
		assertNull(bookstoreService.getBook(deletedBook.getId()));
	}

	@Then("^a book with id (.*) should not be in the list$")
	public void aBookWithIdShouldNotBeInTheList(String id) throws Throwable {
		books = bookstoreService.getBooks();

		for(Book book : books.values()){
			assertTrue(!book.getId().toString().equals(id));
		}
	}
}
