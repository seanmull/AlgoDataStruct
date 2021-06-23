package arrays;

public class WordSearch {

	public static void main(String[] args) {
		/*Given an m x n board and a word, find if the word exists in the grid.

		The word can be constructed from letters of sequentially adjacent cells, 
		where "adjacent" cells are horizontally or vertically neighboring. 
		The same letter cell may not be used more than once.

		 

		Example 1:


		Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
		Output: true
		Example 2:


		Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
		Output: true
		Example 3:


		Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
		Output: false
		 

		Constraints:

		m == board.length
		n = board[i].length
		1 <= m, n <= 200
		1 <= word.length <= 103
		board and word consists only of lowercase and uppercase English letters.*/
		
		String[][] board = new String[][] {{"A","B","C","E"},{"S","F","C","S"},{"A","D","E","E"}};
		String word = "ABCCED"; //true
		//String word = "SEE"; //true
		//String word = "ABCB"; //false
		//String[][] board = new String[][] {{"a","d","c"},{"a","o","g"},{"a","b","c"}};
		//String word = "dog";
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[0].length; col++) {
				if(word.startsWith(board[row][col])) {
					WordSearchs(row,col,twoDimCopy(board),word.substring(1));}}
				}
		System.out.println(false);
	}
	public static boolean WordSearchs(int row, int col, String[][] b, String w) {
		boolean isFound = false;
		b[row][col] = "x"; //to indicate used location
		if(w.isEmpty()) {
			System.out.println(true);
			System.exit(0);
		}
		//look up
		if((row - 1) >= 0 && w.startsWith(b[row - 1][col])) {
			row--;
			b[row][col] = "x";
			isFound = WordSearchs(row, col, b, w.substring(1));
			if(!isFound) row++;
		}
		//look down
		if((row + 1) <= b.length - 1 && w.startsWith(b[row + 1][col])) {
			row++;
			b[row][col] = "x";
			isFound = WordSearchs(row, col, b, w.substring(1));
			if(!isFound) row--;
		}
		//look left
		if((col - 1) >= 0 && w.startsWith(b[row][col - 1])) {
			col--;
			b[row][col] = "x";
			isFound = WordSearchs(row, col, b, w.substring(1));
			if(!isFound) col++;
		}
		//look right
		if((col + 1) <= b[0].length - 1 && w.startsWith(b[row][col + 1])) {
			col++;
			b[row][col] = "x";
			isFound = WordSearchs(row, col, b, w.substring(1));
			if(!isFound) col--;
		}
		return isFound;
	}
	
	public static String[][] twoDimCopy(String[][] ori){
		String[][] b = new String[ori.length][ori[0].length];
		for(int i = 0; i < ori.length; i++) {
			b[i] = (String[])ori[i].clone();
		}
		return b;	
	}

}
