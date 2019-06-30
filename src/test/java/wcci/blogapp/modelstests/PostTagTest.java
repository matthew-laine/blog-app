package wcci.blogapp.modelstests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Test;

import wcci.blogapp.models.Genre;
import wcci.blogapp.models.PostTag;

public class PostTagTest {
	Genre genre = new Genre("Test Genre");
	LocalDateTime dateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);

	@Test
	public void postTagConstructorShouldConstructWithName() {
		PostTag underTest = new PostTag("name");
		assertThat(underTest.getName(), is("name"));
	}

}
