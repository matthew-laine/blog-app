package wcci.blogapp.controllers;

import javax.annotation.Resource;

import org.springframework.ui.Model;

import wcci.blogapp.repositories.PostRepository;

public class PostController {
	@Resource
	private PostRepository postRepo;

	public String findAll(Model model) {
		model.addAttribute("postsAttribute", postRepo.findAll());
		return "postsTemplate";
	}

}
