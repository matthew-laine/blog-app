package wcci.blogapp.controllers;

import java.time.LocalDateTime;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import wcci.blogapp.models.Genre;
import wcci.blogapp.models.Post;
import wcci.blogapp.repositories.GenreRepository;
import wcci.blogapp.repositories.PostRepository;

@Controller
@RequestMapping({"/posts","/posts/"})
public class PostController {
	@Resource
	private PostRepository postRepo;
	
	@Resource
	private GenreRepository genreRepo;

	@RequestMapping({"", "/"})
	public String findAll(Model model) {
		model.addAttribute("allPostsAttribute", postRepo.findAll());
		return "allPostsTemplate";
	}
	
	@RequestMapping({"/{id}", "/{id}/"})
	public String findById(@PathVariable("id")long id, Model model) {
		model.addAttribute("singlePostAttribute", postRepo.findById(id).get());
		return "singlePostTemplate";
	}
	
	@PostMapping({"/add", "/add/"})
	public String saveNewPost(String title, String body, String genre) {
		Genre genreToAdd = null;
		boolean makeNewGenre = true;
		for (Genre foundGenre : genreRepo.findAll()) {
			if (foundGenre.getName() == genre) {
				makeNewGenre = false;
				genreToAdd = foundGenre;
			}
		}
		if (makeNewGenre) {
			genreToAdd = new Genre(genre);
			genreRepo.save(genreToAdd);
		}
		Post postToAdd = new Post(title, body, genreToAdd, LocalDateTime.now());
		postRepo.save(postToAdd);
		return "redirect:/posts";
	}

}
