package arrays;

public class ContainMostWater {

	public static void main(String[] args) {
		/*Given n non-negative integers a1, a2, ..., an , where 
		 * each represents a point at coordinate (i, ai). 
		 * n vertical lines are drawn such that the two endpoints 
		 * of the line i is at (i, ai) and (i, 0). 
		 * Find two lines, which, together with the x-axis 
		 * forms a container, such that the container 
		 * contains the most water.

		Notice that you may not slant the container.

		Example 1:

		Input: height = [1,8,6,2,5,4,8,3,7]
		Output: 49
		Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
		Example 2:

		Input: height = [1,1]
		Output: 1
		Example 3:

		Input: height = [4,3,2,1,4]
		Output: 16
		Example 4:

		Input: height = [1,2,1]
		Output: 2
		 

		Constraints:

		n == height.length
		2 <= n <= 3 * 104
		0 <= height[i] <= 3 * 104*/
		
		int height[] = new int[] {1,8,6,2,5,4,8,3,7};
		int areas[] = new int[height.length * height.length];
		int maxArea = 0;
		int lowerHeight;
		int areasIndex = 0;
		
		for(int startIndex = 0; startIndex < height.length - 1; startIndex++)
			for(int endIndex = startIndex + 1; endIndex < height.length; endIndex++) {
				lowerHeight = (height[startIndex] >= height[endIndex]) ? height[endIndex] : height[startIndex];
				areas[areasIndex] = lowerHeight * (endIndex - startIndex);
				areasIndex++;
			}
		for(int area : areas) if (area > maxArea) maxArea = area;
		
		System.out.println("The maximum area of water is " + maxArea);
		
		//Runtime and space are both 0(n^2) if we ignore constraints.
	}

}
