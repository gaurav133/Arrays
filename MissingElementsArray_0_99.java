import java.util.Scanner;

// Refer geeksforgeeks: http://www.geeksforgeeks.org/print-missing-elements-that-lie-in-range-0-99/

/**
 * Program to find missing elements in range of 0-99 in input array.
 * 
 * @author jain.g
 */
class MissingElementsArray_0_99 {

	/**
	 * Prints missing elements from 0-99 in given array.
	 * @param inputArray Input array.
	 * @throws NullPointerException if input array is null.
	 * @throws IllegalArgumentException if input array length is 0.
	 */
	static final void printMissingElements0to99(int inputArray[]) {

		// Maintain a boolean array to mark elements from 0-99 which are present.
		boolean markElements[] = new boolean[100];

		// Index to loop through array.
		int endIndex, index;

		// Boundary condition.
		if (inputArray == null) {
			throw new NullPointerException("Input array is null.");
		} else if (inputArray.length == 0) {
			throw new IllegalArgumentException("Input array length is 0.");
		} else {

			// Mark elements from 0-99 which are present.
			for (index = 0; index < inputArray.length; index++) {
				if (inputArray[index] < 100) {
					markElements[inputArray[index]] = true;
				}
			}

			endIndex = index = 0;

			// Now print missing numbers.
			while (index < 100) {
				
				// If elements missing, check how many after this are also missing.
				if (markElements[index] == false) {

					endIndex = index + 1;
					while (endIndex < 100 && markElements[endIndex] == false) {
						endIndex++;
					}
					
					// If endIndex and index are same, it's only 1 element.
					if (index == endIndex - 1) {
						System.out.println(index);
					} else {
						System.out.println(index + "-" + (endIndex - 1));
					}
					
					index = endIndex;
				} else {
					index++;
				}
			}
		}
	}

	// Main method.
	public static void main(String[] args) {

		/**
		 * inputArray Input array. numberOfElements Number of elements in array. index Index to loop
		 * through array. elementToFind Element whose position is to be found. position Position of
		 * elementToFind if it is found, else -1 (default).
		 */
		int inputArray[], numberOfElements, index;

		// Get Scanner for input.
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter number of elements: ");
		numberOfElements = scanner.nextInt();

		inputArray = new int[numberOfElements];

		System.out.println("Enter array: ");

		for (index = 0; index < numberOfElements; index++) {
			inputArray[index] = scanner.nextInt();
		}

		printMissingElements0to99(inputArray);

		// Close resource.
		scanner.close();

	}
}
