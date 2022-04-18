package com.tezzio.booksjsb.Book.v3;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tezzio.booksjsb.Book.Book;
import com.tezzio.booksjsb.Book.Sorter;

@Service
public interface BookServiceV3 {
	public List<Book> getBookList();
	public Book getBook(String isbn);
	public boolean addBook(Book book);
	public boolean deleteBook(String isbn);
	public boolean updateBook(Book book);
	public List<Book> sorted(Sorter sorter);
}
