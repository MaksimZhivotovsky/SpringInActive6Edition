package com.example.max.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.max.model.Book;
import com.example.max.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/books")
public class BookRestController {

	private final BookService bookService;
	
//	@GetMapping
//	public List<Book> getBooks() {
//		return bookService.getBooks();
//	}
	
	@PostMapping
	public Book saveBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}
	
	@GetMapping(value = "/{id}")
	public Book getBookById(@PathVariable("id") Long id) {
		return bookService.getBookById(id);
	}
	@DeleteMapping(value = "/{id}")
	public void deleteBook(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
	}
}
