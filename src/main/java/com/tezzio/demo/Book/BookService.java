package com.tezzio.demo.Book;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class BookService {
	private Map<String, Book> bookList;
	
	public BookService() {
		bookList = new LinkedHashMap<String, Book>();
		for(int i=0; i<10; i++) 
			bookList.put("" + i, 
					new Book(
						"" + i, 
						"" + (char)(65+(new Random()).nextInt(0, 26)), 
						"" + (char)(65+(new Random()).nextInt(0, 26))
					)
			);
	}
	
	public List<Book> getBookList() {
		return new ArrayList<Book>(this.bookList.values());
	}
	
	public Book getBook(String isbn) {
		if(bookList.containsKey(isbn)) {
			return bookList.get(isbn);
		}
		return null;
	}
	
	public boolean addBook(Book book) {
		if(bookList.containsKey(book.getIsbn())) {
			return false;
		}
		this.bookList.put(book.getIsbn(), book);
		return true;
	}
	
	public boolean deleteBook(String isbn) {
		if(!bookList.containsKey(isbn)) {
			return false;
		}
		bookList.remove(isbn);
		return true;
	}
	
	public boolean updateBook(Book book) {
		if(!bookList.containsKey(book.getIsbn())) {
			return false;
		}
		bookList.put(book.getIsbn(), book);
		return true;
	}
	
	public List<Book> sortedByIsbn() {
		return this.bookList
				.values().
				stream().
				sorted((a, b)->a.getIsbn().compareTo(b.getIsbn()))
				.collect(Collectors.toList());
	}
	
	public List<Book> sortedByName() {
		return this.bookList
				.values().
				stream().
				sorted((a, b)->a.getName().compareTo(b.getName()))
				.collect(Collectors.toList());
	}
	
	public List<Book> sortedByAuthor() {
		return this.bookList
				.values().
				stream().
				sorted((a, b)->a.getAuthor().compareTo(b.getAuthor()))
				.collect(Collectors.toList());
	}
	
}
