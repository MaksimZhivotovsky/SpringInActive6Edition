package com.example.max.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.max.model.Book;
import com.example.max.service.BookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/books")
public class BookController {

	private final BookService bookService;
	
	@GetMapping
	public String vievBooks(Model model) {
		List<Book> listBooks = bookService.getBooks();
		model.addAttribute("listBooks", listBooks);
		return "book_list";
	}
	
	@GetMapping("/create")
	public String createBookForm(Book book) {
		return "book_create";
	}
	
	@PostMapping("/create")
	public String createBook(Book book) {
		bookService.saveBook(book);
		return "redirect:/books";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}
	
	@GetMapping("/update/{id}")
	public String updateBookForm(
			@PathVariable("id") Long id,
			Model model) {
		Book book = bookService.getBookById(id);
		model.addAttribute("book", book);
		return "book_update";
	}
	
	@PostMapping("/update")
	public String updateBook(Book book) {
		bookService.saveBook(book);
		return "redirect:/books";
	}
}
