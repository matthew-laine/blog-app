package wcci.blogapp;

import java.time.LocalDateTime;

public class Post {

	private String title;
	private String body;
	private String authors;
	private LocalDateTime publishdate;
	private Genre genre;
	private String tags;

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

	public String getAuthors() {
		return authors;
	}

	public LocalDateTime getPublishdate() {
		return publishdate;
	}

	public Genre getGenre() {
		return genre;
	}

	public String getTags() {
		return tags;
	}

	public Post(String title, String body, String authors, LocalDateTime publishdate, Genre genre, String tags) {
		super();
		this.title = title;
		this.body = body;
		this.authors = authors;
		this.publishdate = publishdate;
		this.genre = genre;
		this.tags = tags;
	}

}
