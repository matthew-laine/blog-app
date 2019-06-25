package wcci.blogapp;

import java.util.ArrayList;
import java.util.List;

public class PostTag {
	private String name;
	private List<Post> posts;
	
	public PostTag(String tagName, Post...posts) {
		this.name = tagName;
		this.posts = new ArrayList<Post>();
		for(Post post : posts) {
			this.posts.add(post);
		}
	}

	public String getName() {
		return name;
		
		
	}

	public List<Post> getPosts() {
		return posts;
	}

}
