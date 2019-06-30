package wcci.blogapp.controllertests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Collection;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import wcci.blogapp.controllers.PostController;
import wcci.blogapp.models.Post;
import wcci.blogapp.repositories.PostRepository;

public class PostControllerTest {

	@InjectMocks

	private PostController underTest;

	@Mock
	private PostRepository postRepo;

	@Mock
	private Post post1;
	@Mock
	private Post post2;
	@Mock
	Model model;

	@Before
	public void setUp() {
		initMocks(this);

	}

	@Test
	public void shouldBeAbleToGetPosts() {
		String posts = underTest.findAll(model);
		assertThat(posts, is("allPostsTemplate"));
	}

	@Test
	public void shouldHavePostsInModel() {
		Collection<Post> posts = Arrays.asList(post1, post2);
		Mockito.when(postRepo.findAll()).thenReturn(posts);
		underTest.findAll(model);
		verify(model).addAttribute("allPostsAttribute", posts);
	}
}
