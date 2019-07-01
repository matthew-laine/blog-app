package wcci.blogapp.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import wcci.blogapp.models.Post;
import wcci.blogapp.models.PostTag;
import wcci.blogapp.repositories.PostRepository;
import wcci.blogapp.repositories.PostTagRepository;

@Controller
@RequestMapping({ "/post-tags", "/post-tags/" })
public class PostTagController {

	@Resource
	private PostTagRepository postTagRepo;

	@Resource
	private PostRepository postRepo;

	@RequestMapping({ "", "/" })
	public String findAll(Model model) {
		model.addAttribute("allPostTagsAttribute", postTagRepo.findAll());
		return "allPostTagsTemplate";
	}

	@RequestMapping({ "/{id}", "/{id}/" })
	public String findById(@PathVariable("id") long id, Model model) {
		model.addAttribute("singlePostTagAttribute", postTagRepo.findById(id).get());
		return "singlePostTagTemplate";
	}

	@PostMapping({ "/add", "/add/" })
	public String saveNewPostTag(String name) {
		boolean shouldAddPostTag = shouldAddPostTag(name);
		if (shouldAddPostTag) {
			PostTag postTagToAdd = new PostTag(name);
			postTagRepo.save(postTagToAdd);
		}
		return "redirect:/post-tags";
	}

	@PostMapping({ "/{postTagId}/add-post", "/{postTagId}/add-post/" })
	public String addPostToPostTag(@PathVariable("postTagId") long postTagId, long postId) {
		boolean shouldAddPost = shouldAddPost(postTagId, postId);
		if (shouldAddPost) {
			PostTag postTag = postTagRepo.findById(postTagId).get();
			Post postToAdd = postRepo.findById(postId).get();
			postTag.addPost(postToAdd);
			postTagRepo.save(postTag);
		}
		return "redirect:/post-tags/{postTagId}";
	}

	private boolean shouldAddPostTag(String name) {
		Iterable<PostTag> allPostTags = postTagRepo.findAll();
		boolean addPostTag = true;
		for (PostTag postTag : allPostTags) {
			if (postTag.getName().equals(name)) {
				addPostTag = false;
			}
		}
		return addPostTag;
	}

	private boolean shouldAddPost(long postTagId, long postId) {
		boolean addPost = true;
		PostTag postTag = postTagRepo.findById(postTagId).get();
		Post post = postRepo.findById(postId).get();
		for (PostTag tag : post.getPostTags()) {
			if (tag.getId() == postTag.getId()) {
				addPost = false;
			}
		}
		return addPost;
	}
}
