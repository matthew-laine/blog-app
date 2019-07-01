package wcci.blogapp.integrationtests;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import wcci.blogapp.models.Author;
import wcci.blogapp.models.Genre;
import wcci.blogapp.models.Post;
import wcci.blogapp.models.PostTag;
import wcci.blogapp.repositories.AuthorRepository;
import wcci.blogapp.repositories.GenreRepository;
import wcci.blogapp.repositories.PostRepository;
import wcci.blogapp.repositories.PostTagRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DataJpaTests {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private GenreRepository genreRepo;
	
	@Autowired
	private AuthorRepository authorRepo;
	
	@Autowired
	private PostTagRepository postTagRepo;
	
	
	
	@Test
	public void shouldSaveAndLoadPost() {
		Genre genre = new Genre("Genre");
		entityManager.persist(genre);
		Author author = new Author("Fred");
		entityManager.persist(author);
		PostTag postTag = new PostTag("Tag");
		entityManager.persist(postTag);
		Post post = new Post("Title", "Lorem Ipsum Stuff", LocalDateTime.now());
		entityManager.persist(post);
		
	}

}
