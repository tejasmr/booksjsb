package com.tezzio.booksjsb.Book.v1;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tezzio.booksjsb.Book.Book;

@Service
public interface BookServiceV1 {
	public List<Book> getBookList();
	public Book getBook(String isbn);
	public boolean addBook(Book book);
	public boolean deleteBook(String isbn);
	public boolean updateBook(Book book);
	public List<Book> sortedByIsbn();
	public List<Book> sortedByName();
	public List<Book> sortedByAuthor();
}
