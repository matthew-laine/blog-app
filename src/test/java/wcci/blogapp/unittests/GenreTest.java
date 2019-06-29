package wcci.blogapp.unittests;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.junit.Test;

import wcci.blogapp.units.Genre;
import wcci.blogapp.units.Post;

public class GenreTest {

	LocalDateTime dateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);

	@Test
	public void whenWeCreateAGenreItHasAName() {
		Genre underTest = new Genre("TestName");
		String returnName = underTest.getName();
		assertEquals("TestName", returnName);
	}

	@Test
	public void genreShouldHoldPosts() {
		Genre underTest = new Genre("TestName");
		Post post1 = new Post("test title", "test body", "author", dateTime, underTest, "tags");
		underTest.getPosts().add(post1);
		List<Post> retrievedPosts = underTest.getPosts();
		int postsSize = retrievedPosts.size();
		assertEquals(1, postsSize);

	}
}
