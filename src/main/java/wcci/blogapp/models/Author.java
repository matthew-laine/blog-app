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

}
