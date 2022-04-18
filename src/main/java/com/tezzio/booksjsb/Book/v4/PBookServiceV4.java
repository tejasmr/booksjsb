package com.tezzio.booksjsb.Book.v4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.tezzio.booksjsb.Book.Book;
import com.tezzio.booksjsb.Book.Sorter;

/* Persistent Book Service */
@Service
public class PBookServiceV4 implements BookServiceV4 {

	@Autowired
	private BookRepositoryV4 bookRepository;
	
	public List<Book> getBookList() {
		return bookRepository.findAll();
	}
	
	public Book getBook(String isbn) {
		return bookRepository.findByIsbn(isbn);
	}
	
	public boolean addBook(Book book) {
		if(bookRepository.existsBookByIsbn(book.getIsbn()))
			return false;
		bookRepository.save(book);
		return true;
	}
	
	public boolean deleteBook(String isbn) {
		if(!bookRepository.existsBookByIsbn(isbn))
			return false;
		bookRepository.deleteBookByIsbn(isbn);
		return true;
	}
	
	public boolean updateBook(Book book) {
		if(!bookRepository.existsBookByIsbn(book.getIsbn()))
			return false;
		Book updatedBook = bookRepository.findByIsbn(book.getIsbn());
		updatedBook.setName(book.getName());
		updatedBook.setAuthor(book.getAuthor());
		bookRepository.save(updatedBook);
		return true;
	}

	@Override
	public List<Book> sorted(Sorter sorter) {
		if(sorter.getOrder().equals("DESC"))
			return bookRepository.findAll(Sort.by(Sort.Direction.DESC, sorter.getSortBy()));
		return bookRepository.findAll(Sort.by(Sort.Direction.ASC, sorter.getSortBy()));
	}
	
}
