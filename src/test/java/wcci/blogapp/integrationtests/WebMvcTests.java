package wcci.blogapp.integrationtests;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import wcci.blogapp.models.Post;
import wcci.blogapp.repositories.PostRepository;

@RunWith(SpringRunner.class)
@WebMvcTest
public class WebMvcTests {
	
	@Resource
	private MockMvc mvc;
	
	@MockBean
	private PostRepository postRepo;

	@Mock
	private Post post;
	
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
}