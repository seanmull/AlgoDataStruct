package recursionDP;

import java.util.ArrayList;

public class TowersOfHanoi {
	static ArrayList <Integer> A;
	static ArrayList <Integer> B;
	static ArrayList <Integer> C;
	public static void main(String[] args) {
		A = new ArrayList <Integer> ();
		A.add(3); A.add(2); A.add(1);
		B = new ArrayList <Integer> ();
		C = new ArrayList <Integer> ();
		move(3, A, C, B);
	}
	
	
	public static void move(int n, ArrayList<Integer> source, ArrayList<Integer> target, ArrayList<Integer> aux) {
		if(n > 0) {
			//Move n-1 disks from source to aux, so they are out of the way
			move(n - 1, source, aux, target);
			//Move nth disk from source to target
			if(source.size() != 0) {
				int movedDisk = source.remove(source.size()-1);
				target.add(movedDisk);
			}
			//Print progress
			System.out.println(A + " " +  B + " " + C);
			//Move n-1 disks that we left on aux on to target
			move(n - 1, aux, target, source);
		}
		
		

	}
	

}
