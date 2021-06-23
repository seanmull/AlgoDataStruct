package arrays;

import java.util.Arrays;

public class RotateImage {

	public static void main(String[] args) {
		/*You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

		You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
		DO NOT allocate another 2D matrix and do the rotation.

		Example 1:


		Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
		Output: [[7,4,1],[8,5,2],[9,6,3]]
		Example 2:


		Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
		Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
		Example 3:

		Input: matrix = [[1]]
		Output: [[1]]
		Example 4:

		Input: matrix = [[1,2],[3,4]]
		Output: [[3,1],[4,2]]
		 

		Constraints:

		matrix.length == n
		matrix[i].length == n
		1 <= n <= 20
		-1000 <= matrix[i][j] <= 1000*/
		
		int matrix[][] = new int[][] {{1,2,3},{4,5,6},{7,8,9}};//[[7,4,1],[8,5,2],[9,6,3]]
		//int matrix[][] = new int[][] {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
		//[[15,13,2,5],
		//[14,3,4,1],
		//[12,6,8,9],
		//[16,7,10,11]]
		int sizeOfArrays = matrix.length -1;
		int temp[] = new int[sizeOfArrays];
		int numOfLayers = matrix.length/2;
		  
		for(int layer = 0; layer < numOfLayers; layer++) {
			for(int pivotIndex = 0; pivotIndex < sizeOfArrays-(2*layer); pivotIndex++){ //pivots are going to be two less (one per side)
				temp[pivotIndex] = matrix[layer][pivotIndex + layer]; //store top (n - 1) - 2 * numberOfLayers
				matrix[layer][pivotIndex + layer] = matrix[sizeOfArrays-pivotIndex-layer][layer]; //top -> left
				matrix[sizeOfArrays- pivotIndex - layer][layer] = matrix[sizeOfArrays - layer][sizeOfArrays-pivotIndex-layer]; //left -> bottom
				matrix[sizeOfArrays - layer][sizeOfArrays-pivotIndex-layer] = matrix[pivotIndex + layer][sizeOfArrays - layer]; //bottom -> right
				matrix[pivotIndex + layer][sizeOfArrays - layer] = temp[pivotIndex]; //right -> stored top
			}
		}

		for(int[] array : matrix) System.out.println(Arrays.toString(array));
		
		//Complexity is n^2 since we touch each element.
	}

}
