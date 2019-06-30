package wcci.blogapp.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import wcci.blogapp.repositories.PostTagRepository;

@Controller
public class PostTagController {
	
	@Resource
	private PostTagRepository postTagRepo;

	public String findAll(Model model) {
		model.addAttribute("allPostTagsAttribute", postTagRepo.findAll());
		return "allPostTagsTemplate";
	}

	public String findById(long id, Model model) {
		model.addAttribute("singlePostTagAttribute", postTagRepo.findById(id).get());
		return "singlePostTagTemplate";
	}

}
