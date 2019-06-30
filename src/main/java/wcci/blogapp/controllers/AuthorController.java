package wcci.blogapp.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import wcci.blogapp.repositories.AuthorRepository;

@Controller
public class AuthorController {
	
	@Resource
	private AuthorRepository authorRepo;

	public String findAll(Model model) {
		model.addAttribute("allAuthorsAttribute", authorRepo.findAll());
		return "allAuthorsTemplate";
	}

	public String findById(long id, Model model) {
		model.addAttribute("singleAuthorAttribute", authorRepo.findById(id).get());
		return "singleAuthorTemplate";
	}

}
