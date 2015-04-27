// Refer geeksforgeeks : http://www.geeksforgeeks.org/find-pythagorean-triplet-in-an-unsorted-array/
/**
 * This program can be also be solved using hashmap based approach but it requires O(n) auxiliary space.
 */

import java.util.Scanner;

/**
 * Class to find out whether a pythagorean triplet exists in
 * a given input array.
 * @author Gaurav
 */
class PythagoreanTriplet {

	/**
	 * Find whether Pythagorean triplet exists in given array or not.
	 * @param inputArray Input array.
	 * @throws NullPointerException if input array is null.
	 * @throws IllegalArgumentException if input array length is 0.
	 * @return true if there's a pythagorean triplet, false otherwise.
	 */
	static final boolean isPythagoreanTripletExist(int inputArray[]) {
		
		// Store result.
		boolean result = false;
		
		/**
		 * index Index to loop through array.
		 * desiredSum Sum which is desired for Pythagorean triplet i.e. square(c)
		 * start Starting index of array when searching triplet.
		 * end Ending index of array.
		 */
		int index, desiredSum, start, end;
		
		// Boundary condition.
		if (inputArray == null) {
			throw new NullPointerException("Input array is null.");
		} else if (inputArray.length == 0) {
			throw new IllegalArgumentException("Input array length is 0.");
		} else {
			
			// If there are less than 2 elements, returns false.
			if (inputArray.length == 1 || inputArray.length == 2) {
				return result;
			} else {
				
				// Firstly, square each element.
				for (index = 0; index < inputArray.length; index++) {
					inputArray[index] = (int) Math.pow(inputArray[index], 2);
				}
				
				// Now, sort the elements.
				Sorting.HeapSort(inputArray);
				
				// Problem reduces to finding 2 values whose sum exists in array.
				// Start from the last element.
				for (index = 2; index < inputArray.length; index++) {
					
					desiredSum = inputArray[index];
					
					for (start = 0, end = index; start < end;) {
						
						// If triplet found, just return.
						if (inputArray[start] + inputArray[end] == desiredSum) {
							System.out.println("Triplet found : " + Math.sqrt(inputArray[start]) + " " + Math.sqrt(inputArray[end]) + " " + Math.sqrt(desiredSum));
							result = true;
							break;
						} else if (inputArray[start] + inputArray[end] < desiredSum) {
							start++;
						} else {
							end--;
						}
					}
				}
				
				return result;
			}
		}
	}
	
	public static void main(String[] args) {
		
		/**
		 * inputArray Input array.
		 * numberOfElements Number of elements in array.
		 * index Index to loop through array.
		 */
		int inputArray[], numberOfElements, index;
		
		// Get Scanner for input.
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter number of elements: ");
		numberOfElements = scanner.nextInt();
		
		inputArray = new int[numberOfElements];
		
		System.out.println("Enter array");
		
		for (index = 0; index < numberOfElements; index++) {
			inputArray[index] = scanner.nextInt();
		}
		
		// Check Pythagorean triplets.
		if (isPythagoreanTripletExist(inputArray)) {
			System.out.println("Pythagorean triplets exist.");
		} else {
			System.out.println("No Pythagorean triplets exist.");
		}
	}
}
