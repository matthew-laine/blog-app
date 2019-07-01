package wcci.blogapp.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	private String name;
	
	@ManyToMany
	private List<Post> posts;
	
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Post> getPost() {
		return posts;
	}

	@SuppressWarnings("unused")
	private Author() {

	}

	public Author(String name) {
		super();
		this.name = name;
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
}
