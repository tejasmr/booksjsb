package com.tezzio.booksjsb.Book.v1;

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

@RequestMapping("/v1/book")
@Controller
public class BookControllerV1 {
	@Autowired
	private NPBookServiceV1 bookService;
	
	@GetMapping("/")
	public String rootView() {
		return "redirect:viewBooks";
	}
	@GetMapping("/viewBooks") 
	public String viewBooksView(@ModelAttribute("sorter") Sorter sorter, Model model) {
		if(sorter == null || sorter.getSortBy() == null) {
			sorter = new Sorter("isbn", "ASC");
			model.addAttribute("sorter", sorter);
		}
		String sortBy = sorter.getSortBy();
		if(sortBy.equalsIgnoreCase("isbn"))
			model.addAttribute("books", bookService.sortedByIsbn());
		else if(sortBy.equalsIgnoreCase("name"))
			model.addAttribute("books", bookService.sortedByName());
		else if(sortBy.equalsIgnoreCase("author"))
			model.addAttribute("books", bookService.sortedByAuthor());
		else
			model.addAttribute("books", bookService.getBookList());
		
		return "v1/view-books";
	}
	
	@GetMapping("/addBook")
	public String addBookView(Model model) {
		model.addAttribute("book", new Book());
		return "v1/add-book";
	}
	
	@RequestMapping("/updateBook")
	public String updateBookView(@RequestParam String isbn, Model model) {
		Book bookToUpdate = bookService.getBook(isbn);
		if(bookToUpdate == null) 
			return "error";
		model.addAttribute("book", bookToUpdate);
		return "v1/update-book";
	}
	
	@PostMapping("/addBook")
	public RedirectView addBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
		final RedirectView redirectView = new RedirectView("/v1/book/addBook", true);
		boolean didAdd = bookService.addBook(book);
		setFlashAttributeStatus(redirectAttributes, "addBook", didAdd);
		redirectAttributes.addFlashAttribute("addedBookIsbn", book.getIsbn());
		return redirectView;
	}
	
	@RequestMapping("/deleteBook")
	public RedirectView deleteBook(@RequestParam("isbn") String isbn, RedirectAttributes redirectAttributes) {
		final RedirectView redirectView = new RedirectView("/v1/book/viewBooks", true);
		boolean didDelete = bookService.deleteBook(isbn);
		setFlashAttributeStatus(redirectAttributes, "deleteBook", didDelete);
		redirectAttributes.addFlashAttribute("deletedBookIsbn", isbn);
		return redirectView;
	}
	
	@PostMapping("/updateBook") 
	public RedirectView updateBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
		final RedirectView redirectView = new RedirectView("/v1/book/viewBooks", true);
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
