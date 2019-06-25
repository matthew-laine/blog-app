package wcci.blogapp;

import java.util.ArrayList;
import java.util.List;

public class Genre {

	private String name;
	private List<Post> posts;

	public Genre(String name) {
		this.name = name;
		this.posts = new ArrayList<>();
		
	}

	public String getName() {

		return name;
	}

	public List<Post> getPosts() {

		return posts;
	}

}
