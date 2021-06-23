package arraysAndStrings;

import java.util.Arrays;

public class ZeroMatrix {

	public static void main(String[] args) {
		/*Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
		column are set to 0. *///
		Integer[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		Integer[] indexToZero = {0,3}; //row and column index, note this is zero indexed
		Integer[][] newmatrix = new Integer[matrix.length][matrix[0].length];
		
		for(int row = 0; row < matrix.length; row++) {
			for(int column = 0; column < matrix[0].length; column++) {
				if(row == indexToZero[0]) newmatrix[row][column] = 0; // check row
				if(column == indexToZero[1]) newmatrix[row][column] = 0; // check column
				if(row != indexToZero[0] && column != indexToZero[1]) newmatrix[row][column] = matrix[row][column]; //otherwise store
			}
		}
		for(Integer[] rows : newmatrix) System.out.println(Arrays.toString(rows));	
	
		//Runtime is M rows and N columns the if statements are constant run time.

	}

}
