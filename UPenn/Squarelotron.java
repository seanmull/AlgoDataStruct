public class Squarelotron {
	int[][] squarelotron;
	int size;
	
	Squarelotron(int n){
		this.size = n;
		this.squarelotron = new int[size][size];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum++;
				squarelotron[i][j] = sum;
			}
		}
	}
	
	/* Helper functions */
	// print original array
	void Printall() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.printf("%2d",this.squarelotron[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// store array in original square
	void swap(Squarelotron s) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				s.squarelotron[i][j] = this.squarelotron[i][j];
			}
		}
	}
	
	public int findMaxRings() {
	    return  (this.size % 2 == 0) ? (size / 2) : (size / 2) + 1; }
	
	
	/* Method functions */
	// builds new squarelotron and flips it upside down
	Squarelotron upsideDownFlip(int ring) {
		Squarelotron s = new Squarelotron(size);
		this.swap(s);
		
		int first = ring -1;
		int last = size - ring;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if((i >= first && i <= last) && (j == first || j == last)){
					s.squarelotron[i][j] = this.squarelotron[(size-1)-i][j];
				}else if((j >= first && j <= last) && (i == first || i == last)){
					s.squarelotron[i][j] = this.squarelotron[(size-1)-i][j];
				}
			}
		}
		
		return s;
	}
	// builds new squarelotron and flips it diagonally
	Squarelotron mainDiagonalFlip(int ring) {
		
		Squarelotron s = new Squarelotron(size);
		this.swap(s);
		
		int first = ring -1;
		int last = size - ring;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if((i >= first && i <= last) && (j == first || j == last)){
					s.squarelotron[i][j] = this.squarelotron[j][i];
				}else if((j >= first && j <= last) && (i == first || i == last)){
					s.squarelotron[i][j] = this.squarelotron[j][i];
				}
			}
		}
		
		return s;
	}
	
	// rotate the square x amount turns
	void rotateRight(int numberOfTurns) {
	    
		int ring;
	    boolean right = true;  // this tracks if we rotate CW true = yes, false = no
	    int maxRing = findMaxRings();
	    int [][] tmpArr = new int[size][size];

	    for(int i = 0; i < size; i++) {
	        for(int j = 0; j < size; j++) {
	        tmpArr[i][j] = this.squarelotron[i][j];
	        }
	    }
	         
	    if(numberOfTurns < 0) {
	        right = false;
	        numberOfTurns *= -1;
	    }
	 
	    // Iterate through each ring , ie k = ring
	    for(int k = 0; k < numberOfTurns; k++) { 
	         
	        for(int l = 1; l <= maxRing; l++) {
	        ring = l;
	        int first = ring -1;
	        int last = size - ring;
	         
	        
	        for(int i = 0; i < size; i++) { 
	            for(int j = 0; j < size; j++) { 
	            	// the tests for which quadrant of the square we are at
	            	// upper quad
	            	if (i == first && (j >= first && j <= last)) { 
	            		this.squarelotron[i][j] = (right) ? tmpArr[(size -1) -j][first] : 
	                    tmpArr[j][last];
	            	}
	            	// lower quad
	            	else if (i == last && (j >= first && j <= last)) { 
	            		this.squarelotron[i][j] = (right) ? tmpArr[(size -1) -j][last] : 
	                    tmpArr[j][first];
	            	}
	            	// right quad
	            	else if ((i > first && i < last) && j == last) { 
	            		this.squarelotron[i][j] = (right) ? tmpArr[first][i] : 
	                    tmpArr[last][size - 1 -i];
	                }
	                // left quad
	            	else if (j == first) { 
	                this.squarelotron[i][j] = (right) ? tmpArr[last][i] : 
	                    tmpArr[first][size - 1 -i];
	                }
	           }
	        }
	        }
	     }
	        // copy arrays to temp array
	        for(int i = 0; i < size; i++) {
	        	for(int j = 0; j < size; j++) {
	        		tmpArr[i][j] = this.squarelotron[i][j];
	        	}
	        }
	 }

	
	
	public static void main(String[] args) {
		Squarelotron s = new Squarelotron(4);
		
		s.Printall();
		
		s.rotateRight(1);
		
		s.Printall();
		
		
	}
}

