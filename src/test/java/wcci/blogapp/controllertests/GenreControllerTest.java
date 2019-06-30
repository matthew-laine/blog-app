package wcci.blogapp.controllertests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import wcci.blogapp.controllers.GenreController;
import wcci.blogapp.controllers.PostController;
import wcci.blogapp.models.Genre;
import wcci.blogapp.models.Post;
import wcci.blogapp.repositories.GenreRepository;
import wcci.blogapp.repositories.PostRepository;

public class GenreControllerTest {

	@InjectMocks

	private GenreController underTest;

	@Mock
	private GenreRepository genreRepo;

	@Mock
	private Genre genre1;

	@Mock
	private Genre genre2;

	@Mock
	Model model;

	@Before
	public void setUp() {
		initMocks(this);
	}
	
	@Test
	public void shouldBeAbleToGetGenres() {
		String genres = underTest.findAll(model);
		assertThat(genres, is("allGenresTemplate"));
	}
	
	@Test
	public void shouldHaveGenresInModel() {
		Collection<Genre> genres = Arrays.asList(genre1, genre2);
		Mockito.when(genreRepo.findAll()).thenReturn(genres);
		underTest.findAll(model);
		verify(model).addAttribute("allGenresAttribute", genres);
	}

}
