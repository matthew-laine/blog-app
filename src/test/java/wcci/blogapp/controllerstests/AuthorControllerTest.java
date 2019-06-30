package wcci.blogapp.controllerstests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
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

import wcci.blogapp.controllers.AuthorController;
import wcci.blogapp.models.Author;
import wcci.blogapp.repositories.AuthorRepository;

public class AuthorControllerTest {
	
	@InjectMocks

	private AuthorController underTest;

	@Mock
	private AuthorRepository authorRepo;

	@Mock
	private Author author1;

	@Mock
	private Author author2;

	@Mock
	Model model;
	
	Optional<Author> author1Optional;

	@Before
	public void setUp() {
		initMocks(this);
		author1Optional = Optional.of(author1);
	}
	
	@Test
	public void shouldBeAbleToGetAuthors() {
		String authors = underTest.findAll(model);
		assertThat(authors, is("allAuthorsTemplate"));
	}
	
	@Test
	public void shouldHaveAuthorsInModel() {
		Collection<Author> authors = Arrays.asList(author1, author2);
		Mockito.when(authorRepo.findAll()).thenReturn(authors);
		underTest.findAll(model);
		verify(model).addAttribute("allAuthorsAttribute", authors);
	}
	
	@Test
	public void shouldBeAbleToGetSingleAuthor() {
		Mockito.when(authorRepo.findById(0L)).thenReturn(author1Optional);
		String author = underTest.findById(0L, model);
		assertThat(author, is("singleAuthorTemplate"));
	}

	@Test
	public void shouldHaveSingleAuthorInModel() {
		Mockito.when(authorRepo.findById(0L)).thenReturn(author1Optional);
		underTest.findById(0L, model);
		verify(model).addAttribute("singleAuthorAttribute", author1);
	}

}
