package com.tezzio.booksjsb.Book.v5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tezzio.booksjsb.Book.Book;
import com.tezzio.booksjsb.Book.Sorter;

@RequestMapping("/v5/book")
@RestController
@CrossOrigin(origins="https://booksjsbv5.herokuapp.com/")
public class BookControllerV5 {
	@Autowired
	private PBookServiceV5 bookService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Book> rootView(@RequestBody(required=false) Sorter sorter) {
		if(sorter == null || sorter.getSortBy() == null || sorter.getOrder() == null) {
			sorter = new Sorter("isbn", "ASC");
		}
		return bookService.sorted(sorter);
	}

	@RequestMapping(value = "/addBook", method=RequestMethod.POST)
	public boolean addBook(@RequestBody(required=true) Book book) {
		return bookService.addBook(book);
	}

	@RequestMapping(value = "/deleteBook", method=RequestMethod.POST)
	public boolean deleteBook(@RequestBody(required=true) String isbn) {
		return bookService.deleteBook(isbn);
	}
	
	@RequestMapping(value = "/updateBook", method=RequestMethod.POST)
	public boolean updateBook(@RequestBody(required=true) Book book) {
		return bookService.updateBook(book);
	}
}
