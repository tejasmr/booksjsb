package com.tezzio.demo.Book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RequestMapping("/book")
@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("/viewBooks") 
	public String viewBooksView(@RequestParam(required=false) String sortBy, Model model) {
		if(sortBy == null) {
			model.addAttribute("books", bookService.getBookList());
			return "view-books";
		}
		if(sortBy.equalsIgnoreCase("isbn"))
			model.addAttribute("books", bookService.sortedByIsbn());
		else if(sortBy.equalsIgnoreCase("name"))
			model.addAttribute("books", bookService.sortedByName());
		else if(sortBy.equalsIgnoreCase("author"))
			model.addAttribute("books", bookService.sortedByAuthor());
		
		return "view-books";
	}
	
	@GetMapping("/addBook")
	public String addBookView(Model model) {
		model.addAttribute("book", new Book());
		return "add-book";
	}
	
	@RequestMapping("/updateBook")
	public String updateBookView(@RequestParam String isbn, Model model) {
		Book bookToUpdate = bookService.getBook(isbn);
		if(bookToUpdate == null) 
			return "error";
		model.addAttribute("book", bookToUpdate);
		return "update-book";
	}
	
	@PostMapping("/addBook")
	public RedirectView addBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
		final RedirectView redirectView = new RedirectView("/book/addBook", true);
		boolean didAdd = bookService.addBook(book);
		setFlashAttributeStatus(redirectAttributes, "addBook", didAdd);
		redirectAttributes.addFlashAttribute("addedBookIsbn", book.getIsbn());
		return redirectView;
	}
	
	@RequestMapping("/deleteBook")
	public RedirectView deleteBook(@RequestParam("isbn") String isbn, RedirectAttributes redirectAttributes) {
		final RedirectView redirectView = new RedirectView("/book/viewBooks", true);
		boolean didDelete = bookService.deleteBook(isbn);
		setFlashAttributeStatus(redirectAttributes, "deleteBook", didDelete);
		redirectAttributes.addFlashAttribute("deletedBookIsbn", isbn);
		return redirectView;
	}
	
	@PostMapping("/updateBook") 
	public RedirectView updateBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
		final RedirectView redirectView = new RedirectView("/book/viewBooks", true);
		boolean didUpdate = bookService.updateBook(book);
		setFlashAttributeStatus(redirectAttributes, "updateBook", didUpdate);
		redirectAttributes.addFlashAttribute("updatedBookIsbn", book.getIsbn());
		return redirectView;
	}
	
	private void setFlashAttributeStatus(RedirectAttributes redirectAttributes, String task, boolean status) {
		if(status) {
			redirectAttributes.addFlashAttribute(task+"Success", true);
		}
		else {
			redirectAttributes.addFlashAttribute(task+"Failure", true);
		}
	}
}
