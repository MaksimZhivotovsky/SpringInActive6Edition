package com.example.max.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.max.model.Library;
import com.example.max.repository.LibraryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class LibraryService {

	private final LibraryRepository libraryRepository;
	
	public List<Library> getLibraries() {
		return libraryRepository.findAll();
	}
	
	public Library saveLibrary(Library library) {
		return libraryRepository.save(library);
	}
	
	public Library getLibraryById(Long id) {
		return libraryRepository.findById(id).get();
	}
	
	public void deleteLibrary(Long id) {
		libraryRepository.deleteById(id);
	}
}
