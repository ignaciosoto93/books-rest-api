package com.mule.services;

import java.util.Map;

import org.mule.module.apikit.exception.BadRequestException;

import com.mule.container.BookContainer;
import com.mule.support.Book;

public class BookService {

	public Map<Integer, Book> getBooks() {
		return BookContainer.getInstance().getBooks();
	}

	public void addBook(Book book) {
		BookContainer.getInstance().addBook(book);
	}

	public void mergeBook(Book book) throws BadRequestException {
		try {
			BookContainer.getInstance().mergeBook(book);
		} catch (Exception e) {
			throw new BadRequestException(e.getMessage());		
			}
	}

	public void deleteBook(Integer id) throws BadRequestException {
		try {
			BookContainer.getInstance().deleteBook(id);
		} catch (Exception e) {
			throw new BadRequestException(e.getMessage());		
		}
	}

	public Book findByName(String name) {
		try {
			return BookContainer.getInstance().findByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Book();
	}

}
