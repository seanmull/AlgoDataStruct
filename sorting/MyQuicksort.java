package sorting;

import java.util.Arrays;

public class MyQuicksort {
	
	
	public static int[] quicksort(int[] arr, int lo, int hi) {
		if(lo < hi) {
			int p = partition(arr, lo, hi);
			//System.out.println(Arrays.toString(arr));
			quicksort(arr,lo,p-1);
			quicksort(arr,p+1,hi);
		}
		return arr;
	}
	
	
	
	public static int partition(int[] arr, int lo, int hi) {
		int i = lo;
		int tmp;
		for(int j = lo; j < hi; j++) {
			if(arr[j] < arr[hi]) {
				tmp = arr[j];
				arr[j] = arr[i];
				arr[i] = tmp;
				i++;
			}
		}
		tmp = arr[i];
		arr[i] = arr[hi];
		arr[hi] = tmp;
		return i;
	}


	public static void main(String[] args) {
		int[] a = {2,4,3,4,6,1};
		System.out.println(Arrays.toString(quicksort(a,0,a.length-1)));
	}	

}
