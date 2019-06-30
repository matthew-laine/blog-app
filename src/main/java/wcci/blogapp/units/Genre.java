package wcci.blogapp.units;

import java.util.ArrayList;
import java.util.List;

public class Genre {

	private String name;
	private List<Post> posts;


	public String getName() {

		return name;
	}

	public List<Post> getPosts() {

		return posts;
	}

	@SuppressWarnings("unused")
	private Genre() {
		
	}
	
	public Genre(String name) {
		this.name = name;
		this.posts = new ArrayList<>();
		
	}
}
