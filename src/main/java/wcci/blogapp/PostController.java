package wcci.blogapp;

import javax.annotation.Resource;

import org.springframework.ui.Model;

public class PostController {
	@Resource
	private PostRepository postRepo;

	public String findAll(Model model) {
		model.addAttribute("postsAttribute", postRepo.findAll());
		return "postsTemplate";
	}

}
