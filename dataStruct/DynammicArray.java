package dataStruct;

import java.util.Arrays;

public class DynammicArray {
	private int size = 0;
	private int cap = 0;
	private int[] vals;
	
	private DynammicArray() {
		vals = new int[1];
		cap++;
	}
	
	private void add(int element) { //add element to end
		size++;
		if(size > cap) {
			int[] tmp = new int[cap * 2]; 
			cap*= 2;
			for(int i = 0; i < vals.length; i++) tmp[i] = vals[i];
			vals = tmp;
		}
		vals[size - 1] = element;	
	}
	
	private void remove(int index) { //remove element from specifed index
		if(index > size) {
			System.out.println("Index greater then size");
			System.exit(0);
		}
		size--;
		int[] tmp = vals.clone();
		for(int i = vals.length - 1; i > index; i--) {
			vals[i - 1] = tmp[i];
		}
		vals[size] = 0;
		if(cap >= size * 2) {
			int[] tmp1 = new int[(int) (cap * (0.5))]; 
			cap = (int) (cap * (0.5));
			for(int i = 0; i < tmp1.length; i++) tmp1[i] = vals[i];
			vals = tmp1;
		}
	}
	
	private void print() { 
		String s = "[";
		for(int i = 0; i < size; i++) {
			if(i != size - 1) {
				s += vals[i] + ", ";
			}else {
				s += vals[i];
			}
		}
		s += "]";
		System.out.println(s);		
		
	}

	public static void main(String[] args) {
		DynammicArray myObj = new DynammicArray();
		myObj.add(6);
		myObj.add(12);
		myObj.add(8);
		System.out.println(myObj.size);
		System.out.println(myObj.cap);
		//System.out.println(Arrays.toString(myObj.vals));
		myObj.print();
		myObj.remove(0);
		System.out.println(myObj.size);
		System.out.println(myObj.cap);
		//System.out.println(Arrays.toString(myObj.vals));
		myObj.print();

	}

}
