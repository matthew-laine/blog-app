package wcci.blogapp;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collection;

import org.junit.Test;

public class AuthorTest {

	private LocalDateTime dateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);
	Post postOne = new Post("title", "body", "authors", dateTime, "genre", "tags");
	private LocalDateTime dateTime2 = LocalDateTime.of(2016, Month.JULY, 29, 19, 30, 40);
	Post postTwo = new Post("title2", "body2", "authors2", dateTime2, "genre2", "tags2");
	
	Collection<Post> posts;
	
	
	public Collection<Post> getPosts() {
		return posts;
	}


	public void setPosts(Collection<Post> posts) {
		this.posts = posts;
	}


	@Test
	public void authorShouldHaveNamePosts() {
		Author underTest = new Author("name","post");
		
		assertThat(underTest.getName(), is("name"));
		assertThat(underTest.getPost(), is("post"));
		
		
		
	}

	



}
