package wcci.blogapp.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Long id;

	private String title;

	@Lob
	private String body;

	@ManyToMany(mappedBy="posts")
	private List<Author> authors;

	private LocalDateTime publishdate;

	@ManyToOne
	private Genre genre;

	@ManyToMany(mappedBy="posts")
	private List<PostTag> postTags;

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public LocalDateTime getPublishdate() {
		return publishdate;
	}

	public Genre getGenre() {
		return genre;
	}

	public List<PostTag> getPostTags() {
		return postTags;
	}

	@SuppressWarnings("unused")
	private Post() {

	}

	public Post(String title, String body, LocalDateTime publishDate) {
		super();
		this.title = title;
		this.body = body;
		this.publishdate = publishDate;
	}

}
