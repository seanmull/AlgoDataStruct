import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

public class MovieRatingsProcessorTest {
	TreeMap<String, PriorityQueue<Integer>> movieRatings = new TreeMap<String, PriorityQueue<Integer>>();
	MovieRatingsProcessor mProcessor = new MovieRatingsProcessor();
	MovieRatingsParser mParser = new MovieRatingsParser();
	TreeMap<String, Integer> TreeMap = new TreeMap<String, Integer>();
	List<UserMovieRating> allUsersRatings = new LinkedList<UserMovieRating>();
	UserMovieRating movie1 = new UserMovieRating("y", 10);
	UserMovieRating movie2 = new UserMovieRating("y", 12);
	UserMovieRating movie3 = new UserMovieRating("z", 2);
	UserMovieRating movie4 = new UserMovieRating("z", 4);
	UserMovieRating movie5 = new UserMovieRating("j", 8);


	@Before
	public void setUp() throws Exception {
		allUsersRatings.add(movie1);
		allUsersRatings.add(movie2);
		allUsersRatings.add(movie3);
		allUsersRatings.add(movie4);
		allUsersRatings.add(movie5);
		movieRatings = mParser.parseMovieRatings(allUsersRatings);
	}

	@Test
	public void testGetAlphabeticalMovies() {
		for(String Movie: mProcessor.getAlphabeticalMovies(movieRatings)) {
			System.out.println(Movie);
		}
	}

	@Test
	public void testGetAlphabeticalMoviesAboveRating() {
		for(String Movie: mProcessor.getAlphabeticalMoviesAboveRating(movieRatings, 6)) {
			System.out.println(Movie);
		}
	}

	@Test
	public void testRemoveAllRatingsBelow() {
		
		TreeMap = mProcessor.removeAllRatingsBelow(movieRatings, 10);
		Set set = TreeMap.entrySet();
		Iterator i = set.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}

}
