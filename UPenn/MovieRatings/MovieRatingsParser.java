/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

	public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {
		TreeMap<String, PriorityQueue<Integer>> TreeMap = new TreeMap<String, PriorityQueue<Integer>>();
		String movie;
		int rating;
		PriorityQueue<Integer> ratings;
		
		try {
			if(allUsersRatings.isEmpty()) {
				return TreeMap;
			}
			}catch(NullPointerException e){
				return TreeMap;
			}
		for(int i = 0; i < allUsersRatings.size(); i++) {
			try {
				if(allUsersRatings.get(i).getMovie().isEmpty() ||
				   allUsersRatings.get(i).getUserRating() < 0) {
					continue;
				}
				}catch(Exception e){
					continue;
				}
			movie = allUsersRatings.get(i).getMovie().toLowerCase();
			rating = allUsersRatings.get(i).getUserRating();
			if(!TreeMap.containsKey(movie)) {
				ratings = new PriorityQueue<Integer>();
				ratings.add(rating);
				TreeMap.put(movie, ratings);
			}else{
				TreeMap.get(movie).add(rating);
			}
		}
		return TreeMap;
	}

}
