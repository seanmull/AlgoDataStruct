package moviedatabase;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MovieDatabaseTest {
	MovieDatabase m = new MovieDatabase();
	String[] actors = {"Marlon Brando", "Al Pacino"};
	String[] actors1 = {"Al Pacino", "Sara May"};
	String movie = "The Godfather";
	String movie1 = "The Godfather II";
	

	@Before
	public void setUp() throws Exception {
		m.addMovie(movie, actors);
		m.addRating("The Godfather", 10.0);
		m.updateRating("The Godfather", 9.0);
		m.updateRating("The Godfather II", 8.5);
	}

	@Test
	public void testAddMovie() {
		assertEquals(m.getActorList().get(0).getName(), actors[0]);
		m.addMovie(movie1, actors1);
		assertNull(m.getActorList().get(0).getMovies());
	}

	@Test
	public void testAddRating() {
		m.addRating("The Godfather", 10.0);
		assertEquals(m.getMovieList().get(0).getRating(), 10.0, .1);
	}

	@Test
	public void testUpdateRating() {
		assertEquals(m.getMovieList().get(0).getRating(), 9.0, .1);
	}

	@Test
	public void testGetBestActor() {
		fail("Not yet implemented");
		//assertEquals(m.getActorList().get(0).getMovies().size(), 1);
		//assertEquals(m.getBestActor(), "Marlon Brando");
	}

	@Test
	public void testGetBestMovie() {
		fail("Not yet implemented");
	}

}
