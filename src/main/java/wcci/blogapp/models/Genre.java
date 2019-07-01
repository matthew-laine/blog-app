package wcci.blogapp.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genre {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@OneToMany(mappedBy = "genre")
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
