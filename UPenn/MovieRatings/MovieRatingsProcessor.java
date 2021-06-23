/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;


public class MovieRatingsProcessor {

	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
		List<String> movieList = new LinkedList();
		Set set;
		Iterator i;
		
		try {
			set = movieRatings.entrySet();
			i = set.iterator();
			if(movieRatings.isEmpty()) {
				return movieList;
			}
			}catch(Exception e){
				return movieList;
			}
		
		while(i.hasNext()) {
			Map.Entry me = (Map.Entry)i.next();
			movieList.add((String) me.getKey());
		}
		return movieList;
	}

	public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		
		List<String> movieList = new LinkedList();
		PriorityQueue<Integer> ratings;
		boolean isRatingLow = false;
		Set set;
		Iterator iTree;
		
		try {
			set = movieRatings.entrySet();
			iTree = set.iterator();
			if(movieRatings.isEmpty()) {
				return movieList;
			}
			}catch(Exception e){
				return movieList;
		}
		
		
		while(iTree.hasNext()) {
			Map.Entry me = (Map.Entry)iTree.next();
			ratings = (PriorityQueue<Integer>) me.getValue();
			if(ratings.peek() <= rating) {
				isRatingLow = true;
			}
			if(!isRatingLow) {
				movieList.add((String) me.getKey());
			}
			isRatingLow = false;
			}
		return movieList;
	}
	
	public static PriorityQueue<Integer> removeRatings(PriorityQueue<Integer> movieRatings, int rating){
		LinkedList <Integer>tempList = new LinkedList <Integer>();
		for(Integer queueRating : movieRatings) {
			if(queueRating <= rating) {
				tempList.add(queueRating);
			}
		}
		movieRatings.clear();
		for(Integer valueInList: tempList) {
			movieRatings.add(valueInList);
		}
		return movieRatings;
	}
	
	
	
	
	
	
	public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		LinkedList <Integer>tempList;
		TreeMap<String, Integer> TreeMap = new TreeMap<String, Integer>();
		Map<String, PriorityQueue<Integer>> movieRating;
		PriorityQueue<Integer> ratingQueue = new PriorityQueue<Integer>();
		int ratingInQueue;
		int numOfRatings;
		
		try {
			
			if(movieRatings.isEmpty()) {
				return TreeMap;
			}
			}catch(Exception e){
				return TreeMap;
		}
		
		for(Map.Entry<String,PriorityQueue<Integer>> entry : movieRatings.entrySet()) {
			  numOfRatings = 0;
			  String key = entry.getKey();
			  PriorityQueue<Integer> value = entry.getValue();
			  for(Integer queueRating : value) {
				  if(queueRating < rating) {
					  numOfRatings++;
				  }
			  }
			  if(numOfRatings != 0) {
				  TreeMap.put(key, numOfRatings);	  
			  }
			  //System.out.println(key + " => " + numOfRatings);
		}
		
		int sizeOfMovieRatings = movieRatings.size();
		int numOfKeysToRemove = 0;
		for(Map.Entry<String,PriorityQueue<Integer>> entry : movieRatings.entrySet()) {
			  tempList = new LinkedList <Integer>();
			  String key = entry.getKey();
			  PriorityQueue<Integer> value = entry.getValue();
			  if(value.peek() < rating) {
				  numOfKeysToRemove++;
			  }
			  for(Integer queueRating: value) {
				  if(queueRating >= rating) {
					  tempList.add(queueRating);
				  }
			  }
			  value.clear();
			  for(Integer valueInList: tempList) {
				  value.add(valueInList); 
			  }
			  //System.out.println(key + " => " + value);
		}
		
		if(numOfKeysToRemove == sizeOfMovieRatings) {
			movieRatings.clear();
		}
		
		return TreeMap;
		
	}
}
