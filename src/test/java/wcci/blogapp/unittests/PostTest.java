package wcci.blogapp.unittests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Test;

import wcci.blogapp.units.Genre;
import wcci.blogapp.units.Post;

public class PostTest {
	Genre genre = new Genre ("Test Genre");
	LocalDateTime dateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);
	
	@Test
	public void postShouldHaveTitleBodyAuthorsPublishdateGenreTags() {
		Post underTest = new Post("title", "body", "authors", dateTime, genre, "tags");
		assertThat(underTest.getTitle(), is("title"));
		assertThat(underTest.getBody(), is("body"));
		assertThat(underTest.getAuthors(), is("authors"));
		assertThat(underTest.getPublishdate(), is(dateTime));
		assertThat(underTest.getGenre(), is(genre));
		assertThat(underTest.getTags(), is("tags"));
	 }
	

}