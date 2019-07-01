package wcci.blogapp.modelstests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;

import wcci.blogapp.models.Author;
import wcci.blogapp.models.Genre;
import wcci.blogapp.models.Post;
import wcci.blogapp.models.PostTag;

public class PostTest {
	Genre genre = new Genre("Test Genre");
	LocalDateTime dateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);
	Post underTest;
	Author fred;
	PostTag tag;

	@Before
	public void setup() {
		underTest = new Post("title", "body", dateTime);
		fred = new Author("Fred");
		tag = new PostTag("Tag");
	}

	@Test
	public void postShouldHaveTitleBodyPublishdate() {
		assertThat(underTest.getTitle(), is("title"));
		assertThat(underTest.getBody(), is("body"));
		assertThat(underTest.getPublishdate(), is(dateTime));
	}
}
