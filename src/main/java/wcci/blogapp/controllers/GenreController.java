package wcci.blogapp.controllers;

import javax.annotation.Resource;

import org.springframework.ui.Model;

import wcci.blogapp.repositories.GenreRepository;

public class GenreController {
	
	@Resource
	private GenreRepository genreRepo;

	public String findAll(Model model) {
		model.addAttribute("allGenresAttribute", genreRepo.findAll());
		return "allGenresTemplate";
	}

}
