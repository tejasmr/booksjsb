package com.tezzio.booksjsb.Book.v5;

import java.util.List;

import com.tezzio.booksjsb.Book.Book;
import com.tezzio.booksjsb.Book.Sorter;

public interface BookServiceV5 {
	public List<Book> getBookList();
	public Book getBook(String isbn);
	public boolean addBook(Book book);
	public boolean deleteBook(String isbn);
	public boolean updateBook(Book book);
	public List<Book> sorted(Sorter sorter);
}
