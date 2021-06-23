package sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class Mergesort {
	public static int[] aux;
	
	public static void merge (int [] a, int lo, int mid, int hi) {
		int i = lo; int j = mid + 1;
		aux = new int[a.length];
		for(int l = 0; l < a.length; l++) aux[l] = a[l];
		for(int k = lo; k <= hi; k++) {
			if(i > mid) {
				a[k] = aux[j++];
			}else if(j > hi) {
				a[k] = aux[i++];				
			}else if(aux[i] > aux[j]) {
				a[k] = aux[j++];
			}else{
				a[k] = aux[i++];				
			}
		}
		
	}
	
	public static void sort (int [] a, int lo, int hi) {
		if(lo >= hi) return;
		int mid = (lo + hi)/2;
		sort(a,lo,mid);
		sort(a,mid+1,hi);
		merge(a,lo,mid,hi);
	}
	
	public static void main( String[] args) {
		int[] b = {4,3,2,7,1,3,4,0};
		sort(b,0,b.length-1);
		//merge(b,0,b.length/2,b.length-1);
		
		System.out.println(Arrays.toString(b));
		
	}

}
