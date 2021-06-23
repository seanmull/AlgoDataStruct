package sorting;

public class BinarySearch {

	private static boolean BinarySearch(int [] a, int lo, int hi, int target) {
		if(lo >= hi) return false;
		int mid = (lo + hi)/2;
		if(a[mid] == target) return true;
		return BinarySearch(a, lo, mid, target) || BinarySearch(a, mid+1, hi, target);
	}
	
	private static boolean BinarySearch2(int [] a, int lo, int hi, int target) {
		while(hi > lo) {
			int mid = (lo + hi)/2;
			if(a[mid] == target) 		return true;
			else if(a[mid] > target) 	hi = mid;
			else 						lo = mid + 1;
		}
		return false;
	}
	
	private static boolean LinearSearch(int [] a, int target) {
		for(int num : a) if(num == target) return true;
		return false;
	}

	public static void main(String[] args) {
		int[] nums = new int[119999999];
		//System.out.println(nums.length);
		for(int i = 0; i < nums.length; i++) {
			nums[i] = i;
			//System.out.println(i);
		}
		//System.out.println(Arrays.toString(nums));
		//System.out.println(BinarySearch(nums,0,nums.length - 1, 109999999));
		//System.out.println(LinearSearch(nums, 109999999));
		System.out.println(BinarySearch2(nums,0,nums.length - 1, 109999999));

	}

}
