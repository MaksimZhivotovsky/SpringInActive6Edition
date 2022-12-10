package com.example.max.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.max.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
