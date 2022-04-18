package com.tezzio.booksjsb.Book;

import java.util.function.Function;

public class Sorter {
	private String sortBy;
	private String order;
	public Sorter(String sortBy, String order) {
		this.sortBy = sortBy;
		this.order = order;
	}
	
	public String getSortBy() {
		return this.sortBy;
	}
	
	public String getOrder() {
		return this.order;
	}
		
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	
	public void setOrder(String order) {
		this.order = order;
	}
	
	public Function<Book, String> getField() throws RuntimeException {
		if(sortBy.equals("isbn"))
			return (book) -> book.getIsbn();
		if(sortBy.equals("name"))
			return (book) -> book.getName();
		if(sortBy.equals("author"))
			return (book) -> book.getAuthor();
		throw new RuntimeException("Invalid field for book. See com.tezzio.bookjsb.Book.Sorter.java.");
	}
}
