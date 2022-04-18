package com.tezzio.booksjsb.Book.v3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tezzio.booksjsb.Book.Book;
import com.tezzio.booksjsb.Book.Sorter;

@Service
public class SONPBookServiceV3 implements BookServiceV3 {

	private Map<String, Book> bookList;
	
	public SONPBookServiceV3() {
		bookList = new LinkedHashMap<String, Book>();
		for(int i=0; i<10; i++) 
			bookList.put("" + i, 
					new Book(
						"" + i, 
						"" + (char)(65+(new Random()).nextInt(26)), 
						"" + (char)(65+(new Random()).nextInt(26))
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
		System.out.println(book);
		if(!bookList.containsKey(book.getIsbn())) {
			return false;
		}
		bookList.put(book.getIsbn(), book);
		return true;
	}

	@Override
	public List<Book> sorted(Sorter sorter) {
		Function<Book, String> field = sorter.getField();
		String order = sorter.getOrder();
		List<Book> ans = this.bookList
							.values()
							.stream()
							.sorted((a, b) -> field.apply(a).compareTo(field.apply(b)))
							.collect(Collectors.toList());
		if(order.equals("DESC")) 
			Collections.reverse(ans);
		return ans;
	}
	
}
