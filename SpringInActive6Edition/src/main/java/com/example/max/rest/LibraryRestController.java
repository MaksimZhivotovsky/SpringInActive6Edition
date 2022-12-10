package com.example.max.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.max.model.Library;
import com.example.max.service.LibraryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/library")
public class LibraryRestController {

	private final LibraryService libraryService;
	
	@GetMapping
	public List<Library> getLibraries() {
		return libraryService.getLibraries();
	}
	
	@PostMapping
	public Library saveLibrary(@RequestBody Library library) {
		return libraryService.saveLibrary(library);
	}
	
	@GetMapping(value = "/{id}")
	public Library getLibraryById(@PathVariable("id") Long id) {
		return libraryService.getLibraryById(id);
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteLibrary(@PathVariable("id") Long id) {
		libraryService.deleteLibrary(id);
	}
}
