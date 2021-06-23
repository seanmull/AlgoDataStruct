package tabulationDP;

import java.util.Arrays;

public class tabGridTraveler {

	public static void main(String[] args) {
		System.out.println(gridTraveler(10,10));

	}
	
	public static int gridTraveler(int row, int column) {
		int[][] grid = new int[row + 1][column + 1];
		grid[1][1] = 1;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(i != grid.length - 1) grid[i + 1][j] += grid[i][j];
				if(j != grid[0].length - 1) grid[i][j+1] += grid[i][j];
			}
		}
		for(int[] g: grid) System.out.println(Arrays.toString(g));
		return grid[row][column];
	}

}
