package com.example.max.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.max.model.Library;

public interface LibraryRepository extends JpaRepository<Library, Long> {

}
