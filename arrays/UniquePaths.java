package arrays;

import java.util.Arrays;
import java.util.HashMap;

public class UniquePaths {

	public static void main(String[] args) {
		/*A robot is located at the top-left corner of a m x n grid 
		 * (marked 'Start' in the diagram below).

		The robot can only move either down or right at any point in time. 
		The robot is trying to reach the bottom-right corner of the grid 
		(marked 'Finish' in the diagram below).

		How many possible unique paths are there?

		Example 1:
		Input: m = 3, n = 7
		Output: 28
		
		Example 2:
		Input: m = 3, n = 2
		Output: 3
		Explanation:
		From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
		1. Right -> Down -> Down
		2. Down -> Down -> Right
		3. Down -> Right -> Down
		
		Example 3:
		Input: m = 7, n = 3
		Output: 28
		
		Example 4:
		Input: m = 3, n = 3
		Output: 6
		 
		Constraints:
		1 <= m, n <= 100
		It's guaranteed that the answer will be less than or equal to 2 * 109.*/
		
		//Tabulized solution
		int x = 3; //rows
		int y = 3; //columns
		int[][] table = new int[x][y];
		table[0][0] = 1;
		
		for(int i = 0; i < table.length; i++) { //rows
			for(int j = 0; j < table[0].length; j++) { //columns
				if(i < table.length - 1) table[i+1][j] += table[i][j];
				if(j < table[0].length - 1) table[i][j+1] += table[i][j];		
			}
		}
		for(int[] g: table) System.out.println(Arrays.toString(g));
		
		System.out.println(table[table.length - 1][table[0].length -1]);
		
		//Runtime is n*m and memory is the same
		
		
		
		
		
		
		
		//HashMap <String, Integer> memo = new HashMap <String, Integer> ();
		//System.out.println(uniquePath(3,3,memo));
	}
	
	//Brute force recursive
	/*public static int uniquePath(int row, int col) {
		if(row == 1 && col == 1) return 1;
		if(row == 0 || col == 0) return 0;
		return uniquePath(row - 1,col) + uniquePath(row,col - 1);
	}*/
	//Runtime 2^(m+n) and space is n+m since the function calls clear stack memory
	//as they go back up the tree.
	
	
	//Memoized recursive
	public static int uniquePath(int row, int col, HashMap <String, Integer> m) {
		String s;
		if(row > col) {
			s = row + "_" + col;
		}else {
			s = col + "_" + row;
		}
		if(m.containsKey(s)) return m.get(s);
		if(row == 1 && col == 1) return 1;
		if(row == 0 || col == 0) return 0;
		m.put(s, uniquePath(row - 1,col,m) + uniquePath(row,col - 1,m));
		return m.get(s);
	}
	
	//Runtime n+m since we eliminate alot of repeated searches.
	
	

}
