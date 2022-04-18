package com.tezzio.booksjsb.Book.v2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.tezzio.booksjsb.Book.Book;
import com.tezzio.booksjsb.Book.Sorter;
import com.tezzio.booksjsb.Book.v1.NPBookServiceV1;

@RequestMapping("/v2/book")
@Controller
public class BookControllerV2 {
	@Autowired
	private NPBookServiceV2 bookService;
	
	@GetMapping("/")
	public String rootView(@ModelAttribute("sorter") Sorter sorter, Model model) {
		if(sorter == null || sorter.getSortBy() == null) {
			sorter = new Sorter("isbn", "ASC");
			model.addAttribute("sorter", sorter);
		}
		if(!model.containsAttribute("book"))
			model.addAttribute("book", new Book());
		if(!model.containsAttribute("isbn"))
			model.addAttribute("isbn", null);
		
		String sortBy = sorter.getSortBy();
		
		if(sortBy.equalsIgnoreCase("isbn"))
			model.addAttribute("books", bookService.sortedByIsbn());
		else if(sortBy.equalsIgnoreCase("name"))
			model.addAttribute("books", bookService.sortedByName());
		else if(sortBy.equalsIgnoreCase("author"))
			model.addAttribute("books", bookService.sortedByAuthor());
		else
			model.addAttribute("books", bookService.getBookList());
		
		return "v2/book";
	}

	@PostMapping("/addBook")
	public RedirectView addBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
		final RedirectView redirectView = new RedirectView("/v2/book/", true);
		boolean didAdd = bookService.addBook(book);
		setFlashAttributeStatus(redirectAttributes, "addBook", didAdd);
		redirectAttributes.addFlashAttribute("addedBookIsbn", book.getIsbn());
		return redirectView;
	}

	@PostMapping("/deleteBook")
	public RedirectView deleteBook(@ModelAttribute("isbn") String isbn, RedirectAttributes redirectAttributes) {
		final RedirectView redirectView = new RedirectView("/v2/book/", true);
		if(isbn == null || isbn == "")
			return redirectView;
		boolean didDelete = bookService.deleteBook(isbn);
		setFlashAttributeStatus(redirectAttributes, "deleteBook", didDelete);
		redirectAttributes.addFlashAttribute("deletedBookIsbn", isbn);
		return redirectView;
	}

	@RequestMapping("/updateBook")
	public String updateBookView(@RequestParam String isbn, Model model) {
		Book bookToUpdate = bookService.getBook(isbn);
		if(bookToUpdate == null) 
			return "error";
		model.addAttribute("book", bookToUpdate);
		return "v2/update-book";
	}
	
	@PostMapping("/updateBook") 
	public RedirectView updateBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
		final RedirectView redirectView = new RedirectView("/v2/book/", true);
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
