package wcci.blogapp.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PostTag {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
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
}
