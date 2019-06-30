package wcci.blogapp.modelstests;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Test;

import wcci.blogapp.models.Genre;

public class GenreTest {

	LocalDateTime dateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);

	@Test
	public void whenWeCreateAGenreItHasAName() {
		Genre underTest = new Genre("TestName");
		String returnName = underTest.getName();
		assertEquals("TestName", returnName);
	}
}
