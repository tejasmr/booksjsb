package com.tezzio.booksjsb.Book.v5;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.tezzio.booksjsb.Book.Book;

public interface BookRepositoryV5 extends MongoRepository<Book, String> {
	@Query("{isbn: ?0}")
	Book findByIsbn(String isbn);
	
	Boolean existsBookByIsbn(String isbn);
	
	Book deleteBookByIsbn(String isbn);
}
