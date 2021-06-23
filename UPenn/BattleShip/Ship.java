
public abstract class Ship {
	private int bowRow;
	private int bowColumn;
	private int length;
	private boolean horizontal;
	private boolean[] hit = new boolean[8];
	
	public int getBowRow() {
		return bowRow;
	}
	public void setBowRow(int bowRow) {
		this.bowRow = bowRow;
	}
	public int getBowColumn() {
		return bowColumn;
	}
	public void setBowColumn(int bowColumn) {
		this.bowColumn = bowColumn;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public boolean isHorizontal() {
		return horizontal;
	}
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	public boolean[] getHit() {
		return hit;
	}
	public void setHit(boolean[] hit) {
		this.hit = hit;
	}
	
	abstract String getShipType();
	
	// check to see if its outside boundry only
	public boolean checkBound(int row, int column, boolean horizontal, Ocean ocean) {
		// check if out of bounds
		if(!horizontal) {
			if((column  > ocean.getShipArray()[0].length) || (row + this.length > ocean.getShipArray()[1].length)) {
				return false;
			}
		}else{
			if((column + this.length > ocean.getShipArray()[0].length) || (row  > ocean.getShipArray()[1].length)) {
				return false;
			}
			
		}
		return true;
		
	}
	
	// check to see if ship is nearby and checks boundry
	public boolean checkProx(int row, int column, boolean horizontal, Ocean ocean) {
		int i_range = 3;
		int j_range = 3;
		
		// check if out of bounds
		//if(!checkBound(row, column, horizontal, ocean)) {
		//	return false;
		//}
		
		// adjust cursor and prox ranges
		row--; column--;  //18 row 10 column
		if(row == -1) {
			i_range--; row++;
		}
		if(row == ocean.getShipArray()[1].length-2) { 
			i_range--; //row--; //17 with 2 i_range
		}
		if(column == -1) {
			j_range--; column++;
		}
		if(column == ocean.getShipArray()[0].length-2) {
			j_range--; //column--;
		}
		
		for(int i = 0; i < i_range; i++) { //2
			for(int j = 0; j < j_range; j++) { //3 not going to check 19
				if(ocean.getShipArray()[row+i][column+j].getShipType() != "empty") {
					return false;
				}
			}
		}
		return true;
	}
	
	/*Returns true if it is okay to put a ship of this length with its bow in this location, 
	with the given orientation, and returns false otherwise. 
	The ship must not overlap another ship, or touch another ship (vertically, horizontally, or diagonally), 
	and it must not �stick out� beyond the array. 
	Do not actually change either the ship or the Ocean, just says whether it is legal to do so.*/
	
	public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		
		// look if its out of bounds
		if(!checkBound(row, column, horizontal, ocean)) {
			return false;
		}

		for(int i = 0; i < ocean.getShipArray()[0].length; i++) {
			for(int j = 0; j < ocean.getShipArray()[1].length; j++) {
				
				if((i >= row) && (i <= row + this.getLength()) && (j == column) && (horizontal == false)){
					if(!checkProx(i, j, horizontal, ocean)){
						return false;
					}
				}	
				if((j >= column) && (j <= column + this.getLength()) && (i == row) && (horizontal == true)){
					if(!checkProx(i, j, horizontal, ocean)) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	/*�Puts� the ship in the ocean. This involves giving values to the bowRow, 
	bowColumn, and horizontal instance variables in the ship, and it also involves 
	putting a reference to the ship in each of 1 or more locations (up to 8) in the 
	ships array in the Ocean object. (Note: This will be as many as eight identical references; 
	you can�t refer to a �part� of a ship, only to the whole ship.)*/
	
	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		this.bowRow = row;
		this.bowColumn = column;
		this.horizontal = horizontal;
		
		for(int i = 0; i < ocean.getShipArray()[0].length; i++) {
			for(int j = 0; j < ocean.getShipArray()[1].length; j++) {
				if((i >= row) && (i <= row + this.getLength()-1) && (j == column) && (horizontal == false)){
					ocean.getShips()[i][j] = this;
				}	
				if((j >= column) && (j <= column + this.getLength()-1) && (i == row) && (horizontal == true)){
					ocean.getShips()[i][j] = this;
				}	
			}
		}		
	}
	
	/*If a part of the ship occupies the given row and column, and the ship hasn�t been sunk, 
	mark that part of the ship as �hit� 
	(in the hit array, 0 indicates the bow) and return true, otherwise return false.*/
			
	public boolean shootAt(int row, int column) {
		for(int i = 0; i < this.length; i++) {
			if(!this.horizontal) {
				if((row == this.bowRow + i) && column == this.bowColumn) {
					this.hit[i] = true;
					return true;
				}
			}else{
				if((column == this.bowColumn + i) && row == this.bowRow) {
					this.hit[i] = true;
					return true;
				}
			}
		}
		return false;
	}
	
	/*Return true if every part of the ship has been hit, false otherwise.*/
	
	public boolean isSunk() {
		for(int i = 0; i < this.length; i++) {
			if(this.hit[i] != true) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		if (this.isSunk() == true) {
			return "x";
		}else{
			return "S";
		}
	}
	
	
}
