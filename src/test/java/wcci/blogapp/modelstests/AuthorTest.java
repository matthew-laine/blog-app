package wcci.blogapp.modelstests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import wcci.blogapp.models.Author;

public class AuthorTest {
	
	@Test
	public void authorConstructorShouldHaveName() {
		Author underTest = new Author("John Doe");
		String retrievedName = underTest.getName();
		assertThat(retrievedName, is("John Doe"));
	}
	
	
}
