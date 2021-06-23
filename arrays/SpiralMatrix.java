package arrays;

import java.util.ArrayList;

public class SpiralMatrix {

	public static void main(String[] args) {
		/*Given an m x n matrix, return all elements of the matrix in spiral order.

		Example 1:


		Input: matrix = 
		[[1,2,3],
		[4,5,6],
		[7,8,9]]
		Output: [1,2,3,6,9,8,7,4,5]
		Example 2:
		Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
		Output: [1,2,3,4,8,12,11,10,9,5,6,7]
				 
		Constraints:

		m == matrix.length
		n == matrix[i].length
		1 <= m, n <= 10
		-100 <= matrix[i][j] <= 100*/
		
		int matrix[][] = new int[][] {{1,2},{3,4}};
		//int matrix[][] = new int[][] {{1,2,3},{4,5,6},{7,8,9}};//[1,2,3,6,9,8,7,4,5]
		//int matrix[][] = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};//[1,2,3,4,8,12,11,10,9,5,6,7]
		int m = matrix[0].length; //row length
		int n = matrix.length; //column length
		int x = 0; //row position
		int y = 0; //column position
		ArrayList <Integer> spiralMatrix = new ArrayList <Integer> ();
		
        while(n > 0 && m > 0) {
    		//if one row/column left, no circle can be formed
    		if(m == 1) {
    			for(int i = 0; i < n; i++) spiralMatrix.add(matrix[x++][y]);
    			break;
    		}
    		if(n == 1) {
    			for(int i = 0; i < m; i++) spiralMatrix.add(matrix[x][y++]);
    			break;
    		}
    		//below, process a circle
    		//top - move right
    		for(int i = 0; i < m - 1; i++) spiralMatrix.add(matrix[x][y++]);
    		//right - move down
    		for(int i = 0; i < n - 1; i++) spiralMatrix.add(matrix[x++][y]);
    		//bottom - move left
    		for(int i = 0; i < m - 1; i++) spiralMatrix.add(matrix[x][y--]); 
    		//left - move up
    		for(int i = 0; i < n - 1; i++) spiralMatrix.add(matrix[x--][y]);
    		
    		//move to next layer
    		y++;
    		x++;
    		//decrement rows and columns by two one for each side
    		m = m - 2;
    		n = n - 2;
        }

		System.out.println(spiralMatrix);
		
		//Runtime is n*m since it touches each element, memory is also m * n
		
		

	}

}
