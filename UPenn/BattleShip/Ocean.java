
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Ocean {
	private Ship[][] ships = new Ship[20][20];
	private int shotsFired;
	private int hitCount;
	private int shipsSunk;
	int row;
	int column;
	char[][] printValue;
	ArrayList<Ship> shipArray = new ArrayList<Ship>();
	int numOfShips = 0;
	int maxShips = 13;
	int sumOfShips = 0;
	
	Ocean() {
		this.shotsFired = 0;
		this.hitCount = 0;
		this.shipsSunk = 0;
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 20; j++) {
				EmptySea e = new EmptySea();
				this.ships[i][j] = e;
			}
		}
	}
	
	public Ship[][] getShips() {
		return ships;
	}

	public void setShips(Ship[][] ships) {
		this.ships = ships;
	}

	public void setShotsFired(int shotsFired) {
		this.shotsFired = shotsFired;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}

	public void setShipsSunk(int shipsSunk) {
		this.shipsSunk = shipsSunk;
	}
	

	
	/*Place all randomly on the (initially empty) ocean. Place larger ships before smaller ones, 
	 * or you may end up with no legal place to put a large ship. 
	 * You will want to use the Random class in the java.util package, so look that up in the Java API. 
	 */
	public void placeAllShipsRandomly() {
	Random rand = new Random(); 
	Comparator<Ship> COMPARATOR = new Comparator<Ship>()
    {
    // This is where the sorting happens.
        public int compare(Ship o1, Ship o2)
        {
            return  o2.getLength() - o1.getLength();
        }
    };
    
    // place ships in an array
	for(int i = 0; i < maxShips; i++) {
		int value = rand.nextInt(6);
		switch (value) {
		case 0: {Ship s = new BattleShip(); shipArray.add(s); sumOfShips += s.getLength();break;}
		case 1: {Ship s = new BattleCruiser(); shipArray.add(s); sumOfShips += s.getLength();break;}
		case 2: {Ship s = new Cruiser();  shipArray.add(s);sumOfShips += s.getLength();break;}
		case 3: {Ship s = new LightCruiser(); shipArray.add(s);sumOfShips += s.getLength();break;}
		case 4: {Ship s = new Destroyer();  shipArray.add(s);sumOfShips += s.getLength(); break;}
		case 5: {Ship s = new Submarine();  shipArray.add(s); sumOfShips += s.getLength(); break;}
		}
		
	}
	
	// sort array
	Collections.sort(shipArray, COMPARATOR);
	
	// place random ship until limit has been reached
	
	
	while(numOfShips != maxShips) {
		for(int i = 0; i < shipArray.size(); i++) {
			int row = rand.nextInt(this.ships[0].length);
			int column = rand.nextInt(this.ships[1].length);
			boolean horizontal = rand.nextBoolean();
			if(shipArray.get(i).okToPlaceShipAt(row, column, horizontal, this)) {
				shipArray.get(i).placeShipAt(row, column, horizontal, this);
				numOfShips++;
			}else {
				i--; // try again
			}
		}
	}
	}
	
	/*Returns true if the given location contains a ship, 
	 * false if it does not.
	 */
	public boolean isOccupied(int row, int column) {
		if(this.ships[row][column].getShipType() != "empty") {
			return true;
		}else {
			return false;
		}
	}

	/*Returns true if the given location contains a �real� ship, still afloat, (not an EmptySea), 
	 * false if it does not. In addition, this method updates the number of shots that have been fired, 
	 * and the number of hits. Note: If a location contains a �real� ship, shootAt should return true 
	 * every time the user shoots at that same location. 
	 * Once a ship has been �sunk�, additional shots at its location should return false.
	 */
	
	public boolean shootAt(int row, int column) {
		
		this.shotsFired++;
		if(this.ships[row][column].isSunk()){
			return false;
		}
		
		if(this.ships[row][column].getShipType() == "empty") {
			return false;
		}else{
			this.hitCount++;
			this.ships[row][column].shootAt(row, column);
			return true;
		}
	}
	
	/*Returns the number of shots fired (in this game).
	 */
	public int getShotsFired() {
		return this.shotsFired;
	}
	
	/*Returns the number of hits recorded (in this game). All hits are counted, 
	 * not just the first time a given square is hit.
	 */
	public int getHitCount() {
		return this.hitCount;
	}
	
	/*Returns the number of ships sunk (in this game).
	 */
	public int getShipsSunk() {
		return this.shipsSunk;
	}
	
	/*Returns true if all ships have been sunk, otherwise false.
	 */
	public boolean isGameOver() {
		// check to see if all ships in the ocean are sunk?
		for(int i = 0; i < this.getShipArray()[0].length; i++) {
			for(int j = 0; j < this.getShipArray()[1].length; j++) {
				if(!this.getShipArray()[i][j].isSunk() && this.isOccupied(i, j)) {
					return false;
				}
			}
		}
		return true;
	}
	
	/*Returns the 20x20 array of ships. 
	 * The methods in the Ship class that take an Ocean parameter really 
	 * need to be able to look at the contents of this array; the placeShipAt 
	 * method even needs to modify it. While it is undesirable to allow methods 
	 * in one class to directly access instance variables in another class, sometimes 
	 * there is just no good alternative.
	 */
	public Ship[][] getShipArray(){
		return this.ships;
	}
	
	/*Prints the ocean. To aid the user, row numbers should be displayed along the left edge of the array, 
	 * and column numbers should be displayed along the top. Numbers should be 00 to 19, not 1 to 20.
	 * The top left corner square should be 0, 0.
	 *�S� to indicate a location that you have fired upon and hit a (real) ship, 
	 *�-� to indicate a location that you have fired upon and found nothing there, 
	 *�x� to indicate a location containing a sunken ship,
	 *�.� (a period) to indicate a location that you have never fired upon.
	 *This is the only method in the Ocean class that does any input/output, and 
	 *it is never called from within the Ocean class (except possibly during debugging), 
	 *only from the BattleshipGame class.
	 **/

	public void print() {
		// print the upper border
		System.out.printf("  ");
		for(int i = 0; i < 20; i++) {
			System.out.printf("%02d", i);
		}

		// store hits
		for(int i = 0; i < this.getShipArray()[0].length; i++) {
			for(int j = 0; j < this.getShipArray()[1].length; j++) {
				if(i == this.row && j == this.column || printValue[i][j] == 'X') {
					printValue[i][j] = 'X';
				}else {
					printValue[i][j] = 'O';
				}
			}
		}
		// print contents
		for(int i = 0; i < this.getShipArray()[0].length; i++) {
			System.out.printf("\n%02d", i);
			for(int j = 0; j < this.getShipArray()[1].length; j++) {
				if(printValue[i][j] == 'O') {
					System.out.printf(" .");
				}else if(printValue[i][j] == 'X' && !this.isOccupied(i,j)){
					System.out.printf(" -");
				}
				else {
					System.out.printf("%2s",this.getShipArray()[i][j]);
				}
			}
		}
		System.out.println("");
	}
	
	public void printShips() {
		// print the upper border
		System.out.printf("  ");
		for(int i = 0; i < 20; i++) {
			System.out.printf("%02d", i);
		}
		
		for(int i = 0; i < this.getShipArray()[0].length; i++) {
			System.out.printf("\n%02d", i);
			for(int j = 0; j < this.getShipArray()[1].length; j++) {
					System.out.printf("%2s",this.getShipArray()[i][j]);
			}
	}
	}
	
}
