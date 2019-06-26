package wcci.blogapp;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.junit.Test;

public class PostTagTest {
	Genre genre = new Genre ("Test Genre");
	LocalDateTime dateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);
	
	@Test
	public void tagShouldHaveNameAndPosts() {
		Post post1 = new Post("Title", "Body", "Authors", dateTime, genre , "Tags");
		Post post2 = new Post("Title2", "Body", "Authors", dateTime, genre , "Tags");
		String tagName = "tag";
		PostTag underTest = new PostTag(tagName, post1, post2);
		
		String gottenName = underTest.getName();
		List<Post> gottenPosts = underTest.getPosts();
		
		assertThat(gottenName, is(tagName));
		assertThat(gottenPosts, hasItems(post1, post2));
		
	}
	
}