package sorting;

import java.util.Arrays;

public class Quicksort {
	public static int[] nums;

	public static void main(String[] args) {
		/*algorithm quicksort(A, lo, hi) is
    	if lo < hi then
        	p := partition(A, lo, hi)
        	quicksort(A, lo, p - 1)
        	quicksort(A, p + 1, hi)

		algorithm partition(A, lo, hi) is
    		pivot := A[hi]
    		i := lo
    		for j := lo to hi do
        		if A[j] < pivot then
            		swap A[i] with A[j]
            		i := i + 1
    		swap A[i] with A[hi]
    		return i*/
	//Sorting the entire array is accomplished by quicksort(A, 0, length(A) - 1).
		
	nums = new int[] {9, 2, 3, 6, 1, 4};
	quicksort(nums, 0, nums.length -1);
	System.out.println(Arrays.toString(nums));

	}
	public static void quicksort(int[] A, int lo, int hi) {
		int p;
		if(lo < hi) {
			p = partition(A, lo, hi);
			System.out.println("Split");
			quicksort(A, lo, p - 1);
			quicksort(A, p + 1, hi);
		}
	}
	
	public static int partition(int[] A, int lo, int hi) {
		int pivot = A[hi];
		int i = lo;
		int tmp;
		for(int j = lo; j < hi; j++) {
			if(A[j] < pivot) {
				System.out.println(Arrays.toString(nums));
				System.out.println("Swap "+ A[i] + " with " + A[j]);
				tmp = A[i];
				A[i] = A[j];
				A[j] = tmp;
				i++;
				//System.out.println(Arrays.toString(nums));

			}
		}
		System.out.println("Swap "+ A[i] + " with " + A[hi]);
		tmp = A[i];
		A[i] = A[hi];
		A[hi] = tmp;
		
		System.out.println(Arrays.toString(nums));
		return i;	
	}
	/*Take this array 
	9, 2, 3, 6, 1, 4

	First partition call
	i = lo = 0
	hi = 5
	loop from lo to hi
	2 < 4
	swap i with j
	swap 9 with 3
	3, 4, 9, 6, 1, 4
	i = 1
	1 < 4
	swap 4 with 1
	3, 1, 9, 6, 4, 4
	i = 2
	swap pivot(4) with 9
	3, 1, 4(P), 6, 4, 9*/

}
