package wcci.blogapp.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import wcci.blogapp.models.Genre;
import wcci.blogapp.repositories.GenreRepository;

@Controller
public class GenreController {

	@Resource
	private GenreRepository genreRepo;

	public String findAll(Model model) {
		model.addAttribute("allGenresAttribute", genreRepo.findAll());
		return "allGenresTemplate";
	}

	public String findById(long id, Model model) {
		model.addAttribute("singleGenreAttribute", genreRepo.findById(id).get());
		return "singleGenreTemplate";
	}

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
