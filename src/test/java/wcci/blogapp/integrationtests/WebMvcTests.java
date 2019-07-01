package wcci.blogapp.integrationtests;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import wcci.blogapp.models.Author;
import wcci.blogapp.models.Genre;
import wcci.blogapp.models.Post;
import wcci.blogapp.models.PostTag;
import wcci.blogapp.repositories.AuthorRepository;
import wcci.blogapp.repositories.GenreRepository;
import wcci.blogapp.repositories.PostRepository;
import wcci.blogapp.repositories.PostTagRepository;

@RunWith(SpringRunner.class)
@WebMvcTest
public class WebMvcTests {

	@Resource
	private MockMvc mvc;

	@MockBean
	private PostRepository postRepo;

	@MockBean
	private GenreRepository genreRepo;

	@MockBean
	private AuthorRepository authorRepo;

	@MockBean
	private PostTagRepository postTagRepo;

	@Mock
	private Post post;

	@Mock
	private Genre genre;

	@Mock
	private Author author;

	@Mock
	private PostTag postTag;

	@Test
	public void shouldReturnAllPostsPage() throws Exception {
		this.mvc.perform(get("/posts")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void shouldReturnPost1Page() throws Exception {
		Optional<Post> postOptional = Optional.of(post);
		when(postRepo.findById(1L)).thenReturn(postOptional);
		this.mvc.perform(get("/posts/1")).andDo(print()).andExpect(status().isOk());
	}
	
	

	@Test
	public void shouldReturnAllGenresPage() throws Exception {
		this.mvc.perform(get("/genres")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void shouldReturnGenre1Page() throws Exception {
		Optional<Genre> genreOptional = Optional.of(genre);
		when(genreRepo.findById(1L)).thenReturn(genreOptional);
		this.mvc.perform(get("/genres/1")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void shouldReturnAllAuthorsPage() throws Exception {
		this.mvc.perform(get("/authors")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void shouldReturnAuthor1Page() throws Exception {
		Optional<Author> authorOptional = Optional.of(author);
		when(authorRepo.findById(1L)).thenReturn(authorOptional);
		this.mvc.perform(get("/authors/1")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void shouldReturnAllPostTagsPage() throws Exception {
		this.mvc.perform(get("/post-tags")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void shouldReturnPostTag1Page() throws Exception {
		Optional<PostTag> postTagOptional = Optional.of(postTag);
		when(postTagRepo.findById(1L)).thenReturn(postTagOptional);
		this.mvc.perform(get("/post-tags/1")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void shouldAddPost() throws Exception {
		//still need to learn to do this
	}

	@Test
	public void shouldAddGenre() throws Exception {
		Genre genreToAdd = new Genre("GenreName");
		mvc.perform(post("/genres/add").contentType(MediaType.APPLICATION_JSON).content(genreToAdd.getName()))
		.andExpect(status().is3xxRedirection());
	}
	
	@Test
	public void shouldAddAuthor() throws Exception {
		Author authorToAdd = new Author("AuthorName");
		mvc.perform(post("/genres/add").contentType(MediaType.APPLICATION_JSON).content(authorToAdd.getName()))
		.andExpect(status().is3xxRedirection());
	}
	
	@Test
	public void shouldAddPostTag() throws Exception {
		PostTag postTagToAdd = new PostTag("PostTagName");
		mvc.perform(post("/post-tags/add").contentType(MediaType.APPLICATION_JSON).content(postTagToAdd.getName()))
		.andExpect(status().is3xxRedirection());
	}
}
