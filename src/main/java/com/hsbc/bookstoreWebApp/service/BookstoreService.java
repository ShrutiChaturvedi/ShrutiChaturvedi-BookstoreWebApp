package com.hsbc.bookstoreWebApp.service;

import java.util.Map;

import com.hsbc.bookstoreWebApp.model.Book;

public interface BookstoreService {

    public Book getBook(Long id);
    
    public Map<Long, Book> getBooks();

    public int countTotalNumberOfBooks();
    
    public Book createBook(Book bookToBeCreated);

    public Book deleteBook(Long idOfBookToBeDeleted);
    
    public Book updateBook(Book updatedBook);
    
}
