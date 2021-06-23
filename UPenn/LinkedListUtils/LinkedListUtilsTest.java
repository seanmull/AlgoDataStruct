import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class LinkedListUtilsTest {
	LinkedList<Integer> list = new LinkedList<Integer>();
	LinkedList<String> strlist = new LinkedList<String>();
	ArrayList<Integer>duplicate = new ArrayList<Integer>(); 
	LinkedList<Integer> nullList = null;
	int value;
	int numOfDuplicates = 0;
	LinkedList<Integer> sublist = new LinkedList<Integer>();
	LinkedList<Integer> notsublist = new LinkedList<Integer>();

	@Before
	public void setUp() throws Exception {
		for(int i= 0; i < 10; i++) {
			list.add(i);
			if(i >= 3 && i <= 8) {
				sublist.add(i);
			}
		}
		for(int i = 3; i < 20; i++) {
			notsublist.add(i);
		}
		strlist.add("hemlo");
		strlist.add("hello");
		strlist.add("meklo");
		strlist.add("flag");
		strlist.add("hello");
	}
	@Test
	public void testInsertSorted() {
		LinkedListUtils.insertSorted(list, 15);
		for(int i= 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	@Test
	public void testRemoveMaximumValues() {
		System.out.println("Original List:");
		for(int i= 0; i < strlist.size(); i++) {
			System.out.print(strlist.get(i)+ " ");
			System.out.println(strlist.get(i).compareTo(strlist.get(0)));
		}
		LinkedListUtils.removeMaximumValues(strlist, 3);
		System.out.println("Modified List:");
		for(int i= 0; i < strlist.size(); i++) {
			System.out.print(strlist.get(i)+ " ");
			System.out.println(strlist.get(i).compareTo(strlist.get(0)));
		}
		System.out.println("Duplicates Status:");
		for(int i = 0; i < strlist.size(); i++) {
			duplicate.add(i,0);
			numOfDuplicates = 0;
			for(int j = 0; j < strlist.size(); j++) {
				if(strlist.get(i).compareTo(strlist.get(j)) == 0 && (i != j)) {
					numOfDuplicates++;
				}
			}
			duplicate.set(i,numOfDuplicates);
		}
		for(int i= 0; i < strlist.size(); i++) {
			System.out.print(strlist.get(i)+ " ");
			System.out.println(duplicate.get(i));
		}
	}

	@Test
	public void testContainsSubsequence() {
		assertTrue(LinkedListUtils.containsSubsequence(list, sublist));
		assertFalse(LinkedListUtils.containsSubsequence(list, notsublist));
	}

}
