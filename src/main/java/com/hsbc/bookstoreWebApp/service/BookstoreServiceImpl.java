package com.hsbc.bookstoreWebApp.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsbc.bookstoreWebApp.model.Book;
import com.hsbc.bookstoreWebApp.model.Language;
import com.hsbc.bookstoreWebApp.util.MapUtil;

@Service("bookstoreService")
@Transactional
public class BookstoreServiceImpl implements BookstoreService {
	
	private static final Map<Long, Book> bookMap = new HashMap<Long, Book>();
	 
    static {
        initBooks();
    }
 
    //Populating Dummy data just for demonstration purpose
    private static void initBooks() {
    	Book book1 = new Book(new Long("1001"), "JQuery Essentials", "Essential Skills--Made Easy!Learn the fundamentals of jQuery programming in no time.", 
    			new Long("85"), "4613146145", Language.ENGLISH);
    	Book book2 = new Book(new Long("1002"), "Apache Tomcat 9", "Lorem ipsum dolor sit amet", 
    			new Long("119"), "46131468251", Language.FRENCH);
    	Book book3 = new Book(new Long("1003"), "Nandan", "Comics", 
    			new Long("99"), "8762346131461", Language.HINDI);
    	Book book4 = new Book(new Long("1004"), "Peter Pan", "Donec quam felis, ultricies nec", 
    			new Long("69"), "1238446131461", Language.IRISH);
    	
    	bookMap.put(book1.getId(), book1);
    	bookMap.put(book2.getId(), book2);
    	bookMap.put(book3.getId(), book3);
    	bookMap.put(book4.getId(), book4);
    }

	public Book getBook(Long id) {
		return bookMap.get(id);
	}

	public Map<Long, Book> getBooks() {
		return MapUtil.clone(bookMap);
	}
	
	public int countTotalNumberOfBooks() {
		return bookMap.size();
	}

	public Book createBook(Book bookToBeCreated) {
		return bookMap.put(bookToBeCreated.getId(), bookToBeCreated);
	}

	public Book deleteBook(Long idOfBookToBeDeleted) {
		return bookMap.remove(idOfBookToBeDeleted);
	}

	public Book updateBook(Book updatedBook) {
		return bookMap.put(updatedBook.getId(), updatedBook);
	}

}
