//see https://courses.edx.org/courses/course-v1:PennX+SD1x+2T2017/courseware/

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class WhackAMole {
	
	// instance variables
	int score;
	int molesLeft;
	int attemptsLeft;
	char[][] moleGrid;
	int numAttempts;
	int gridDimension;
	
	// constructor
	WhackAMole(int numAttempts, int gridDimension){
		this.score = 0;
		this.molesLeft = 0;
		this.numAttempts = numAttempts;
		this.attemptsLeft = numAttempts;
		this.gridDimension = gridDimension;
		this.moleGrid = new char[gridDimension][gridDimension];
		for (int i = 0; i < gridDimension; i++) {
			for (int j = 0; j < gridDimension; j++) {
			moleGrid[i][j] = '*';
			}
		}
	}
		
	// Place moles in certain location
	boolean place(int x, int y) {
		if (moleGrid[x][y] != 'M') {
			moleGrid[x][y] = 'M';
			molesLeft++;
			return true;
		}
		return false;
	}
	
	// Whack mole at a certain location
	void whack(int x, int y) {
		if (moleGrid[x][y] == 'M') {
			score++;
			molesLeft--;
			moleGrid[x][y] = 'W';
		}
		attemptsLeft--;
	}
	
	// Print the grid
	void printGridToUser() {
		for (int i = 0; i < gridDimension; i++) {
			for (int j = 0; j < gridDimension; j++) {
				if(moleGrid[i][j] == 'M'){
					System.out.print('*');
				}else {
					System.out.print(moleGrid[i][j]);
				}
			}
			System.out.print("\n");
		}
	}
	
	// Print Grid completely
	void printGrid() {
		for (int i = 0; i < gridDimension; i++) {
			for (int j = 0; j < gridDimension; j++) {
					System.out.print(moleGrid[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	public static void main(String[] args) {
		// invoke constructor
		WhackAMole game;
		game = new WhackAMole(50, 10);
		
		// place the moles
		while(game.molesLeft != 10) {
			int randomNumx = ThreadLocalRandom.current().nextInt(0,10);
			int randomNumy = ThreadLocalRandom.current().nextInt(0,10);
			game.place(randomNumx, randomNumy);
			}
		
		Scanner scancoords = new Scanner(System.in);
		while((game.molesLeft != 0) || game.attemptsLeft != 0) {
			
			// give status
			System.out.print("Score: " + game.score + "\n");
			System.out.print("Moles left: " + game.molesLeft + "\n");
			System.out.print("Attempts left: " + game.attemptsLeft + "\n");
			
			// print the board
			game.printGridToUser();
			
			// prompt user for coords
			System.out.print("You have a maximum of 50 attempts to get all the moles\n");
			System.out.print("Enter the x and y coordinates: ");
			String coords = scancoords.next();
			String[] parts = coords.split(",");
			int xcoord = Integer.parseInt(parts[0]);
			int ycoord = Integer.parseInt(parts[1]); 
			
			// exit or whack the mole
			if((xcoord == -1) && (ycoord == -1)) {
				game.printGrid();
				//scancoords.close();
				break;
			}
			else {
				game.whack(xcoord, ycoord);
			}
		}
		// close the scanners
		scancoords.close();
	}
}

