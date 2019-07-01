package wcci.blogapp.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class PostTag {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@ManyToMany
	private List<Post> posts;

	public String getName() {
		return name;
	}

	public List<Post> getPosts() {
		return posts;
	}

	@SuppressWarnings("unused")
	private PostTag() {
	}

	public PostTag(String tagName) {
		this.name = tagName;
		this.posts = new ArrayList<>();
	}
	
	public void addPost(Post postToAdd) {
		boolean addPost = true;
		for (Post post : posts) {
			if (post.getId() == postToAdd.getId()) {
				addPost = false;
			}
		}
		if (addPost) {
			posts.add(postToAdd);
		}
	}

	public long getId() {
		return id;
	}
}
