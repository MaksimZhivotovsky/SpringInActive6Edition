package com.example.max.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.max.model.Book;
import com.example.max.model.Library;

public interface BookRepository extends JpaRepository<Book, Long> {
//	List<Book> findByLibrary(String name);
}
