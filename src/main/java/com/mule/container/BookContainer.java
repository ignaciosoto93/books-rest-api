package com.mule.container;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.mule.support.Book;

public final class BookContainer {

	private static BookContainer instance = null;

	private Map<Integer, Book> books;

	protected BookContainer() {
		this.books = new HashMap<Integer, Book>();
	}

	public static BookContainer getInstance() {
		if (instance == null) {
			instance = new BookContainer();
			createBooks();
		}
		return instance;
	}

	private static void createBooks() {
		Book book1 = new Book();
		book1.setAuthor("pepe");
		book1.setId(1);
		book1.setPages(15);
		book1.setTitle("Norewaing");

		Book book2 = new Book();
		book2.setAuthor("luis");
		book2.setId(2);
		book2.setPages(300);
		book2.setTitle("Nole");

		instance.addBook(book1);
		instance.addBook(book2);

	}

	public Map<Integer, Book> getBooks() {
		return books;
	}

	public void setBooks(Map<Integer, Book> books) {
		this.books = books;
	}

	public void addBook(Book book) {
		this.books.put(book.getId(), book);

	}

	public Book getBook(Integer id) {
		return this.books.get(id);
	}

	public void mergeBook(Book book) throws Exception {
		if(this.books.containsKey(book.getId())){
			this.books.put(book.getId(), book);

		} else throw new Exception("Book ID doesn't exist");
	}

	public void deleteBook(Integer id) throws Exception {
		
		if(this.books.containsKey(id)){
			this.books.remove(id);

		} else throw new Exception("Book ID doesn't exist");
	}

	public Book findByName(String name) throws Exception {

		for (Entry<Integer, Book> entry : books.entrySet()) {
			if (entry.getValue().getTitle().equals(name)) {
				return entry.getValue();
			}
		}

		throw new Exception("Book wasn't found");

	}

}
