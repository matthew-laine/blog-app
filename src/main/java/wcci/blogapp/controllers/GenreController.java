package wcci.blogapp.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import wcci.blogapp.models.Genre;
import wcci.blogapp.repositories.GenreRepository;

@Controller
@RequestMapping({"/genres", "/genres/"})
public class GenreController {

	@Resource
	private GenreRepository genreRepo;

	@RequestMapping({"", "/"})
	public String findAll(Model model) {
		model.addAttribute("allGenresAttribute", genreRepo.findAll());
		return "allGenresTemplate";
	}
	@RequestMapping({"/{id}", "/{id}/"})
	public String findById(@PathVariable("id")long id, Model model) {
		model.addAttribute("singleGenreAttribute", genreRepo.findById(id).get());
		return "singleGenreTemplate";
	}
	
	@PostMapping({"/add", "/add/"})
	public String saveNewGenre(String name) {
		boolean shouldAddGenre = shouldAddGenre(name);
		if (shouldAddGenre) {
			Genre genreToAdd = new Genre(name);
			genreRepo.save(genreToAdd);
		}
		return "redirect:/genres";
	}

	private boolean shouldAddGenre(String name) {
		Iterable<Genre> allGenres = genreRepo.findAll();
		boolean addGenre = true;
		for(Genre genre : allGenres) {
			if (genre.getName().equals(name)) {
				addGenre = false;
			}
		}
		return addGenre;
	}
}
