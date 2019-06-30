package wcci.blogapp.units;

public class Author {
	private String name;
	private String post;

	public String getName() {
		return name;
	}

	public String getPost() {
		return post;
	}

	@SuppressWarnings("unused")
	private Author() {

	}

	public Author(String name, String post) {
		super();
		this.name = name;
		this.post = post;

	}

}
