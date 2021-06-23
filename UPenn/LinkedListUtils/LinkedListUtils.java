

import java.util.LinkedList;
import java.util.ArrayList;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {
	
	/*This method assumes the input LinkedList is already sorted in non-descending order 
	(i.e.,such that each element is greater than or equal to the one that is before it, and inserts the 
	input int value into the correct location of the list. 
	Note that the method does not return anything, but rather modifies the input LinkedList as a side effect. 
	If the input LinkedList is null, this method should simply terminate.*/
	
	public static void insertSorted(LinkedList<Integer> list, int value) {
		int index = 0;
		
		if(list == null) {
			return;
		}
		for(Integer valueInList: list) {
			if(valueInList < value) {
				index++;
			}	
		}
		list.add(index, value);
	}
	

	/*This method removes all instances of the N largest values in the LinkedList. 
	Because the values are Strings, you will need to use the String class’ compareTo 
	method to find the largest elements; see the Java API for help with that method. 
	If the input LinkedList is null or if N is non-positive, this method should simply 
	return without any modifications to the input LinkedList. Keep in mind that if any 
	of the N largest values appear more than once in the LinkedList, 
	this method should return remove all instances, so it may remove more than N 
	elements overall. 
	The other elements in the LinkedList should not be modified and their order
	must not be changed.*/
	
	public static void removeMaximumValues(LinkedList<String> list, int N) {
		ArrayList<Integer>compare = new ArrayList<Integer>();
		ArrayList<Integer>duplicate = new ArrayList<Integer>(); 
		int index; int compValue;
		int numOfDuplicates;
		int numOfRemoved = 0;
		int curCount = 0; int endCount;
		
		if(list == null || N < 0 || list.isEmpty()) {
			return;
		}
        
        if(list.size() <= N) {
			list.clear();
			return;
		}
		for(int i = 0; i < list.size(); i++) {
			compare.add(list.get(i).compareTo(list.get(0)));
		}
		for(int i = 0; i < list.size(); i++) {
			numOfDuplicates = 0;
			duplicate.add(i,numOfDuplicates);
			for(int j = 0; j < list.size(); j++) {
				if(list.get(i).compareTo(list.get(j)) == 0 && (i != j)) {
					numOfDuplicates++;
				}
			}
			duplicate.set(i,numOfDuplicates);
		}
		while(numOfRemoved != N) {
			compValue = -100000;
			index = 0;
			for(int i = 0; i < list.size(); i++) {
				if(compare.get(i) > compValue) {
					index = i;
					compValue = compare.get(i);
				}
			}
			endCount = duplicate.get(index); // how many duplicates there are
			if(curCount >= 0 && curCount < endCount) {
				curCount++;
			}else{
				numOfRemoved++;
			}
			list.remove(index);
			compare.remove(index);
			duplicate.remove(index);
		}
	}
	
	/*This method determines whether any part of the first LinkedList contains all 
	elements of 
	the second in the same order with no other elements in the sequence, i.e.
	it should return true if the second LinkedList is a subsequence of the first,
	and false if it is not. 
	The method should return false if either input is null or empty.*/
	
	public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {

		ArrayList<Boolean> firstIndexMatch = new ArrayList<Boolean>();
		int endIndex;

		if(one == null || two == null || one.isEmpty() || two.isEmpty()) {
			return false;
		}

		for(int value : one) {
			if(value == two.getFirst()) {
				firstIndexMatch.add(true);
			}else {
				firstIndexMatch.add(false);
			}
		}
		for(int i = 0; i < one.size(); i++) {
			if(firstIndexMatch.get(i) == true) {
				if((i + two.size()) > (one.size())) { // if out of bounds
					endIndex = one.size();
				}else{
					endIndex = i + two.size();
				}
				if(one.subList(i, endIndex).equals(two)){
					return true;
				}
			}
		}
		return false;
	}
}
