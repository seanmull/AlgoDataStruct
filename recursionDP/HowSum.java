package recursionDP;

//import java.util.ArrayList;
import java.util.Arrays;

public class HowSum {
	public static int[] sum;
	
	public static void main(String[] args) {
	sum = new int[0];
	int[] num = new int[] {2,4};
	HowSums(4, num);
	System.out.println(Arrays.toString(sum));

}

public static boolean HowSums(int targetNum, int[] nums) {
	
	//base cases
	if(targetNum == 0) {
		return true;
	}
	if(targetNum < 0) return false;

	for(int num: nums) {
		if(HowSums(targetNum - num, nums)) {
			sum = addToArray(num, sum);
			//System.out.println(Arrays.toString(sum) + " " + targetNum + " " + num);
			return true;
		}
	
	}

	return false;
} 

public static int[] addToArray(int num, int[] a) {
	int[] tmp = new int[a.length + 1];
	for(int i = 0; i < a.length; i++) {
		tmp[i] = a[i];
	}
	tmp[a.length] = num;
	return tmp;
}
	
	

	/*public static void main(String[] args) {
		int[] num = new int[] {2,3,4};
		ArrayList <Integer> returnArr = new ArrayList <Integer> ();
		System.out.println(HowSums(9, num, returnArr));

	}
	
	public static ArrayList <Integer> HowSums(int targetNum, int[] nums, ArrayList <Integer> r) {
		//System.out.println(r);
		if(targetNum == 0) return r;
		if(targetNum < 0) return null;
		for(int num: nums) {
			if(HowSums((targetNum - num), nums, r) != null) {
				r.add(num);
				return r;
			}
		}
		return null;
		
		
		//return [1,2];

	} */ 
	

	
	//        500
	//     /         \
	//     7          4   

}
