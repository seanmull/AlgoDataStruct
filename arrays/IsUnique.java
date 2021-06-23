package arrays;

public class IsUnique {

	public static void main(String[] args) {
		/*Implement an algorithm to determine if a string has all unique
		 characters.What if you cannot uses additional data structures*/
		String s = "actt";
		
		//Assume unsorted string
		//We could compare all letters to the remaining letters
		//Assume our string is banana
		//For instance I would compare b to all the rest, then a to all the rest etc
		
		/*for(int i=0; i < s.length() - 1; i++) { //b
			char compareChar = s.charAt(i); 
			for(int j= i+1; j < s.length(); j++) {
				if(s.charAt(j) == compareChar) {
					System.out.println("String does not have unique characters");
					System.exit(j);
				}
			}
		}
		System.out.println("String has all unique characters");*/
		//The first loop stores one value so its constant
		//The second loop compares n-1 then n-2 then n-3 etc
		//This looks like n^2
		//The better approach would be to sort first then use implementation below
		//Since that would be nlogn + n-1 which would be nlogn
		
		
		//Assume we had a sorted array
		//In this instance we just look at the next value for the same letter
		for(int i = 0; i < s.length() - 1; i++) {
			if(s.charAt(i)==s.charAt(i+1)) {
				System.out.println("String does not have unique characters");
				System.exit(i);
			}
		}
		System.out.println("String has all unique characters");
		//This one does n-1 comparisions so runtime is big of n
		
		
		
		
		
	}

}
