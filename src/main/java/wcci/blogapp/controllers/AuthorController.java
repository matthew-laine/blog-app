package wcci.blogapp.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import wcci.blogapp.models.Author;
import wcci.blogapp.repositories.AuthorRepository;

@Controller
@RequestMapping({"/authors", "/authors/"})
public class AuthorController {
	
	@Resource
	private AuthorRepository authorRepo;

	@RequestMapping({"", "/"})
	public String findAll(Model model) {
		model.addAttribute("allAuthorsAttribute", authorRepo.findAll());
		return "allAuthorsTemplate";
	}

	@RequestMapping({"/{id}", "/{id}/"})
	public String findById(@PathVariable("id")long id, Model model) {
		model.addAttribute("singleAuthorAttribute", authorRepo.findById(id).get());
		return "singleAuthorTemplate";
	}
	
	@PostMapping({"/add", "/add/"})
	public String saveNewAuthor(String name) {
		boolean shouldAddAuthor = shouldAddAuthor(name);
		if (shouldAddAuthor) {
			Author authorToAdd = new Author(name);
			authorRepo.save(authorToAdd);
		}
		return "redirect:/authors";
	}

	private boolean shouldAddAuthor(String name) {
		Iterable<Author> allAuthors = authorRepo.findAll();
		boolean addAuthor = true;
		for(Author author : allAuthors) {
			if (author.getName().equals(name)) {
				addAuthor = false;
			}
		}
		return addAuthor;
	}

}
