package com.mule.services;

import java.util.Map;

import com.mule.container.BookContainer;
import com.mule.support.Book;

public class BookService {
	
	public Map<Integer, Book> getBooks() {
		return BookContainer.getInstance().getBooks();
	}
	
	public void addBook(Book book){
		BookContainer.getInstance().addBook(book);
	}
	
	public void mergeBook(Book book){
		BookContainer.getInstance().mergeBook(book);
	}
	
	public void deleteBook(Integer id){
		BookContainer.getInstance().deleteBook(id);
	}
	
	public Book findByName(String name){
		try {
			return BookContainer.getInstance().findByName(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
