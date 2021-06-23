package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {

	public static void main(String[] args) {
		/*Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
		 * and return an array of the non-overlapping intervals that cover all the intervals in the input.

		Example 1:

		Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
		Output: [[1,6],[8,10],[15,18]]
		Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
		Example 2:

		Input: intervals = [[1,4],[4,5]]
		Output: [[1,5]]
		Explanation: Intervals [1,4] and [4,5] are considered overlapping.
				
		Constraints:

		1 <= intervals.length <= 104
		intervals[i].length == 2
		0 <= starti <= endi <= 104*/
		
		//we are assuming the intervals are sorted.

		ArrayList <Integer[]> intervals = new ArrayList <Integer[]> ();
		intervals.add(new Integer[] {1,4});
		intervals.add(new Integer[] {4,5});
		
		//intervals.add(new Integer[] {2,6});
		//intervals.add(new Integer[] {8,10});
		//intervals.add(new Integer[] {15,18});
		
		for(int i = 0; i < intervals.size() - 1; i++) {
			//System.out.println(Arrays.toString(intervals.get(i)));
			for(int j = i + 1; j < intervals.size(); j++) {
				//System.out.println(Arrays.toString(intervals.get(j)));
				if(intervals.get(i)[1] >= intervals.get(j)[0]) {
					intervals.get(j)[0] = intervals.get(i)[0];
					intervals.remove(i);
					i--;
					break;
				}
			}
		}
		for(Integer[] interval : intervals) System.out.println(Arrays.asList(interval));
		
		//Runtime is n * n-1 which is n^2 runtime
	}

}
