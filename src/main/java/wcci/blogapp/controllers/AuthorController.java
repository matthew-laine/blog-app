package wcci.blogapp.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import wcci.blogapp.models.Author;
import wcci.blogapp.models.Post;
import wcci.blogapp.repositories.AuthorRepository;
import wcci.blogapp.repositories.PostRepository;

@Controller
@RequestMapping({ "/authors", "/authors/" })
public class AuthorController {

	@Resource
	private AuthorRepository authorRepo;

	@Resource
	private PostRepository postRepo;

	@RequestMapping({ "", "/" })
	public String findAll(Model model) {
		model.addAttribute("allAuthorsAttribute", authorRepo.findAll());
		return "allAuthorsTemplate";
	}

	@RequestMapping({ "/{id}", "/{id}/" })
	public String findById(@PathVariable("id") long id, Model model) {
		model.addAttribute("singleAuthorAttribute", authorRepo.findById(id).get());
		return "singleAuthorTemplate";
	}

	@PostMapping({ "/add", "/add/" })
	public String saveNewAuthor(String name) {
		boolean shouldAddAuthor = shouldAddAuthor(name);
		if (shouldAddAuthor) {
			Author authorToAdd = new Author(name);
			authorRepo.save(authorToAdd);
		}
		return "redirect:/authors";
	}

	@PostMapping({ "/{authorId}/add-post", "/{authorId}/add-post/" })
	public String addPostToPostTag(@PathVariable("authorId") long authorId, long postId) {
		boolean shouldAddPost = shouldAddPost(authorId, postId);
		if (shouldAddPost) {
			Author author = authorRepo.findById(authorId).get();
			Post postToAdd = postRepo.findById(postId).get();
			author.addPost(postToAdd);
			authorRepo.save(author);
		}
		return "redirect:/post-tags/{postTagId}";
	}

	private boolean shouldAddPost(long authorId, long postId) {
		boolean addPost = true;
		Author authorToAdd = authorRepo.findById(authorId).get();
		Post post = postRepo.findById(postId).get();
		for (Author author : post.getAuthors()) {
			if (author.getId() == authorToAdd.getId()) {
				addPost = false;
			}
		}
		return addPost;
	}

	private boolean shouldAddAuthor(String name) {
		Iterable<Author> allAuthors = authorRepo.findAll();
		boolean addAuthor = true;
		for (Author author : allAuthors) {
			if (author.getName().equals(name)) {
				addAuthor = false;
			}
		}
		return addAuthor;
	}

}
