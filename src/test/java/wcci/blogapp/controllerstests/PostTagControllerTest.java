package wcci.blogapp.controllerstests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import wcci.blogapp.controllers.PostTagController;
import wcci.blogapp.models.PostTag;
import wcci.blogapp.repositories.PostTagRepository;

public class PostTagControllerTest {

	@InjectMocks

	private PostTagController underTest;

	@Mock
	private PostTagRepository postTagRepo;

	@Mock
	private PostTag postTag1;

	@Mock
	private PostTag postTag2;

	@Mock
	Model model;

	Optional<PostTag> postTag1Optional;

	@Before
	public void setup() {
		initMocks(this);
		postTag1Optional = Optional.of(postTag1);
	}

	@Test
	public void shouldBeAbleToGetPostTags() {
		String postTags = underTest.findAll(model);
		assertThat(postTags, is("allPostTagsTemplate"));
	}

	@Test
	public void shouldHavePostTagsInModel() {
		Collection<PostTag> postTags = Arrays.asList(postTag1, postTag2);
		Mockito.when(postTagRepo.findAll()).thenReturn(postTags);
		underTest.findAll(model);
		verify(model).addAttribute("allPostTagsAttribute", postTags);
	}
	
	@Test
	public void shouldBeAbleToGetSinglePostTag() {
		Mockito.when(postTagRepo.findById(0L)).thenReturn(postTag1Optional);
		String postTag = underTest.findById(0L, model);
		assertThat(postTag, is("singlePostTagTemplate"));
	}
	
	@Test
	public void shouldHaveSinglePostTagInModel() {
		Mockito.when(postTagRepo.findById(0L)).thenReturn(postTag1Optional);
		underTest.findById(0L, model);
		verify(model).addAttribute("singlePostTagAttribute", postTag1);
	}

}
