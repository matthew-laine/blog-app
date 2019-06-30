package wcci.blogapp.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import wcci.blogapp.models.PostTag;
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
	
	public String saveNewPostTag(String name) {
		boolean shouldAddPostTag = shouldAddPostTag(name);
		if (shouldAddPostTag) {
			PostTag postTagToAdd = new PostTag(name);
			postTagRepo.save(postTagToAdd);
		}
		return "redirect:/post-tags";
	}

	private boolean shouldAddPostTag(String name) {
		Iterable<PostTag> allPostTags = postTagRepo.findAll();
		boolean addPostTag = true;
		for(PostTag postTag : allPostTags) {
			if(postTag.getName().equals(name)) {
				addPostTag = false;
			}
		}
		return addPostTag;
	}

}
