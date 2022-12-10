package com.example.max.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.max.model.Library;
import com.example.max.service.LibraryService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/librarys")
public class LibraryController {

	private final LibraryService libraryService;
	
	@GetMapping
	public String viewLibraryPage(Model model) {
		List<Library> listLibrary = libraryService.getLibraries();
		model.addAttribute("listLibrary", listLibrary);
		return "library_list";
	}
	
	@GetMapping(value = "/create")
	public String createLibraryForm(Library library) {
		return "library_create";
	}
	
	@PostMapping(value = "/create")
	public String createLibrary(Library library) {
		libraryService.saveLibrary(library);
		return "redirect:/librarys";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String deleteLibrary(@PathVariable("id") Long id) {
		libraryService.deleteLibrary(id);
		return "redirect:/librarys";
	}
	
	@GetMapping(value = "/update/{id}")
	public String updateLibraryForm(
			@PathVariable("id") Long id,
			Model model) {
		Library library = libraryService.getLibraryById(id);
		model.addAttribute("library", library);
		return "library_update";
	}
	
	@PostMapping(value = "/update")
	public String updateLibrary(Library library) {
		libraryService.saveLibrary(library);
		return "redirect:/librarys";
	}
}
