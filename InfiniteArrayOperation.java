import java.util.Scanner;

// Refer geeksforgeeks: http://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/

/**
 * Program to find position of an element in infinite sorted array.
 * @author jain.g
 */
class InfiniteArrayOperation {

	/**
	 * Method to find position of a given value in an infinitely sorted array.
	 * @param inputArray Input array which is sorted
	 * @param elementToFind Element to find in this array.
	 * @throws NullPointerException if input array is null.
	 * @throws IllegalArgumentException if input array length is 0.
	 * @return position of element if found, else -1.
	 */
	static final int returnPositionInArray(int inputArray[], int elementToFind) {
		
		/**
		 * result To store resulting index if element is found. Default value is -1.
		 * lowIndex Low Index while traversing.
		 * highIndex High Index while traversing.
		 */
		int result = -1, lowIndex, highIndex; 
		
		// Boundary condition.
		if (inputArray == null) {
			throw new NullPointerException("Input array is null.");
		} else if (inputArray.length == 0) {
			throw new IllegalArgumentException("Input array length is 0.");
		} else {
			
			lowIndex = 0;
			highIndex = 1;
			
			// Set low index to high index and double high index, while element to find is still greater.
			// This ensures we find a range in which element exists in O(logp) time where p is position of element.
			while (inputArray[highIndex] < elementToFind) {
				lowIndex = highIndex;
				highIndex *= 2;
			}
			
			result = BinarySearch(inputArray, lowIndex, highIndex, elementToFind);
			// Now we have range in which element exists.
			
			return result;
		}
	}
	
	/**
	 * Binary Search algorithm to find a given key in sorted array.
	 * @param inputArray Input array.
	 * @param lowIndex Start index of range in which to find.
	 * @param highIndex End index of range in which to find.
	 * @param elementToFind Element to find.
	 * @return Position of element in array if found, else -1.
	 */
	static final int BinarySearch(int inputArray[], int lowIndex, int highIndex, int elementToFind) {
		
		// Middle index to get subArrays in binary search.
		int middleIndex;
		
		// Base case for recursion.
		if (lowIndex > highIndex) {
			return -1;
		} else {
			
			middleIndex = (lowIndex + highIndex)/2;
			
			if (inputArray[middleIndex] == elementToFind) {
				return middleIndex + 1;
			} else if (inputArray[middleIndex] < elementToFind) {
				return BinarySearch(inputArray, middleIndex + 1, highIndex, elementToFind);
			} else {
				return BinarySearch(inputArray, lowIndex, middleIndex - 1, elementToFind);
			}
		}
	}
	
	// Main method.
	public static void main(String[] args) {
		
		/**
		 * inputArray Input array.
		 * numberOfElements Number of elements in array.
		 * index Index to loop through array.
		 * elementToFind Element whose position is to be found.
		 * position Position of elementToFind if it is found, else -1 (default).
		 */
		int inputArray[], numberOfElements, index, elementToFind, position;
		
		// Get Scanner for input.
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter number of elements: ");
		numberOfElements = scanner.nextInt();
		
		inputArray = new int[numberOfElements];
		
		System.out.println("Enter array (sorted)");
		
		for (index = 0; index < numberOfElements; index++) {
			inputArray[index] = scanner.nextInt();
		}
		
		System.out.println("Enter element to find: ");
		elementToFind = scanner.nextInt();
		
		position = returnPositionInArray(inputArray, elementToFind);
		
		if (position == -1) {
			System.out.println("Element not found"); 
		} else {
			System.out.println("Element found, position: " + position);
		}
		
	}
}
