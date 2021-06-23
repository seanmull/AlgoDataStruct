import java.util.*;

public class MovieDatabase {
	private ArrayList<Movie> movieList; 
	private ArrayList<Actor> actorList;
	
	MovieDatabase(){
		this.movieList = new ArrayList<Movie>();
		this.actorList = new ArrayList<Actor>();
	}
	
	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	public ArrayList<Actor> getActorList() {
		return actorList;
	}

	void addMovie(String name, String[] actors) {	
		ArrayList<Actor> Act = new ArrayList<Actor>(); 
		ArrayList<Movie> Mov = new ArrayList<Movie>();
		Actor act;
		Movie mov = new Movie(name, Act, 0.0);
		Mov.add(mov);
		boolean inListActor;
		int Act_ind = 0;
				
		// check if movie is in list
		boolean inListMovie = false;
		for (int i = 0; i < this.getMovieList().size(); i++) {
			if (this.getMovieList().get(i).getName() == name) {
				inListMovie = true;
				break;
			}
		}
		// add to list if nessessary
		if(!inListMovie) {
			for (int i = 0; i < actors.length; i++) {
				act = new Actor();
				act.setName(actors[i]);
				act.setMovies(Mov);
				Act.add(act);					
			}
		this.getMovieList().add(mov);
		}
		
		// iterate through actors in movies
		for (int i = 0; i < actors.length; i++) { 
			inListActor = false;
			// iterate through the actor list
			for (int j = 0; j < this.getActorList().size(); j++) {
				if(this.getActorList().get(j).getName() == actors[i]) {
					inListActor = true;
					Act_ind = j;
				}
			}
			// add to list if nessessary
			if(!inListActor) {
				act = new Actor();
				act.setName(actors[i]);
				act.setMovies(Mov);
				this.getActorList().add(act);
			}else{
				this.getActorList().get(Act_ind).getMovies().add(mov);
			}
		}		
	}
	
	void addRating(String name, double rating) {
		for (int i = 0; i < this.getMovieList().size(); i++) {
			if (this.getMovieList().get(i).getName() == name) {
				this.getMovieList().get(i).setRating(rating);
			}
		}
	}
	
	void updateRating(String name, double newRating) {
		for (int i = 0; i < this.getMovieList().size(); i++) {
			if (this.getMovieList().get(i).getName() == name) {
				this.getMovieList().get(i).setRating(newRating);
			}
		}		
	}
	
	String getBestActor() {
		double max = 0;
		int max_index = 0;
		double avg[] = new double[100000];
		double sum[] = new double[100000];

		// find avg rating for actor
		for (int i = 0; i < this.getActorList().size(); i++) {
			for (int j = 0; j < this.getActorList().get(i).getMovies().size(); j++) {
				sum[i] += this.getActorList().get(i).getMovies().get(j).getRating();
			}
			avg[i] = sum[i] / (this.getActorList().get(i).getMovies().size());
		}
		
		for (int i = 0; i < this.getActorList().size(); i++) {
			if (avg[i] > max) {
				max = avg[i];
				max_index = i;
			}
		}
		return this.getActorList().get(max_index).getName();
	}
	
	String getBestMovie() {
		double max = 0;
		int max_index = 0;
		
		for (int i = 0; i < this.getMovieList().size(); i++) {
			if(this.getMovieList().get(i).getRating() > max) {
				max = this.getMovieList().get(i).getRating();
				max_index = i;
			}
		}
		return this.getMovieList().get(max_index).getName();
	}

	public static void main(String[] args) {
		
		MovieDatabase m = new MovieDatabase();
		
		String[] actors = {"Sara May", "Al Pacino"};
		String[] actors1 = {"Al Pacino", "Marlon Brando"};
		String movie = "The Godfather";
		String movie1 = "The Godfather II";
		
		m.addMovie(movie, actors);
		m.addMovie(movie1, actors1);
		m.addRating("The Godfather", 9);
		m.updateRating("The Godfather", 9);
		m.updateRating("The Godfather II", 7);
		
		System.out.println(m.getBestActor());
		System.out.println(m.getBestMovie());
		
		//m.addMovie(movie, actors);
		
		
		
		/*Finally, write a main method where:

            You create a new instance of a movieDatabase.

            Add all the movies in the file movies.txt.

            Go through the ratings of the movies in the file ratings.txt and add the ratings for the movies.

            Now call the methods that you created and print out the name of the best actor and the name of the highest rated movie.
		*/

	}

}
