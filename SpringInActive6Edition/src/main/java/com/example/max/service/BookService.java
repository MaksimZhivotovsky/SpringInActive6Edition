package com.example.max.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.max.model.Book;
import com.example.max.model.Library;
import com.example.max.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

	private final BookRepository bookRepository;
	
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}
	
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Book getBookById(Long id) {
		return bookRepository.findById(id).get();
	}
	
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
}
