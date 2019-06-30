package wcci.blogapp.integrationtests;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HttpRequestTests {
	
	@Resource
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	String endpoint;
	
	private void assertThatEndPointIsOk(String endpoint) {
		ResponseEntity<String> response = restTemplate.getForEntity(endpoint, String.class);
		HttpStatus status = response.getStatusCode();
		status.is2xxSuccessful();
	}
	
	private void assertThatEndPointIsRedirect(String mapping) {
		ResponseEntity<String> response = restTemplate.getForEntity(mapping, String.class);
		HttpStatus status = response.getStatusCode();
		status.is3xxRedirection();
	}
	
	@Test
	public void postsEndPointShouldBeOk() {
		assertThatEndPointIsOk("/posts");
	}
	
	@Test
	public void addPostEndPointShouldBeRedirect() {
		assertThatEndPointIsRedirect("/posts/add");
	}
	
	@Test
	public void singlePostEndPointShouldBeOk() {
		assertThatEndPointIsOk("/posts/1");
	}
	
	@Test
	public void authorsEndPointShouldBeOk() {
		assertThatEndPointIsOk("/authors");
	}
	
	@Test
	public void addAuthorEndPointShouldBeRedirect() {
		assertThatEndPointIsRedirect("/authors/add");
	}
	
	@Test
	public void singleAuthorEndPointShouldBeOk() {
		assertThatEndPointIsOk("/authors/1");
	}
	
	@Test
	public void genresEndPointShouldBeOk() {
		assertThatEndPointIsOk("/genres");
	}
	
	@Test
	public void addGenreEndPointShouldBeRedirect() {
		assertThatEndPointIsRedirect("/genres/add");
	}
	
	@Test
	public void singleGenreEndPointShouldBeOk() {
		assertThatEndPointIsOk("/genres/1");
	}
	
	@Test
	public void postTagsEndPointShouldBeOk() {
		assertThatEndPointIsOk("/post-tags");
	}
	
	@Test
	public void addPostTagEndPointShouldBeRedirect() {
		assertThatEndPointIsRedirect("/post-tags/add");
	}
	
	@Test
	public void singlePostTagEndPointShouldBeOk() {
		assertThatEndPointIsOk("/post-tags/1");
	}
	

}
