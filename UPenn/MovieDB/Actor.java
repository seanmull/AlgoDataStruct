import java.util.*;

public class Actor {
	private String name;
	private ArrayList<Movie> movies;
	
	//TODO need to remove passed in variables
	public Actor(){
		this.name = getName();
		this.movies = getMovies();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Movie> getMovies() {
		return movies;
	}
	public void setMovies(ArrayList<Movie> movies) {
		this.movies = movies;
	}

}
