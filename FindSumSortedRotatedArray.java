// Refer geeksforgeeks : http://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/

import java.util.Scanner;

/**
 * Program to find whether there exist 2 values whose sum exists in a given sorted + rotated array.
 * @author gaurav
 */
class FindSumSortedRotatedArray {

    /**
     * Helper method to find starting point of the sorted + rotated array.
     * @param inputArray Input array.
     * @param startIndex Starting index for array while finding.
     * @param endIndex End index for array while finding.
     */
     static final int findStartingPosition(int inputArray[], int startIndex, int endIndex) {
        
        // If only 1 element is left.
        if (startIndex == endIndex)
            return startIndex;
        
        // If array is not rotated.
        if (startIndex > endIndex) {
            return startIndex;
        }
        
        // Calculate middle index based on startIndex and endIndex.
        int middleIndex = (startIndex + endIndex) / 2;
        
        // If middle element is minimum.
        if (middleIndex > startIndex && inputArray[middleIndex] < inputArray[middleIndex - 1]) {
            return middleIndex;
        } else if (inputArray[middleIndex] < inputArray[endIndex]) {
            return findStartingPosition(inputArray, startIndex, middleIndex - 1);
        } else {
            return findStartingPosition(inputArray, middleIndex + 1, endIndex);
        }
    }
    
    /**
     * Method to find whether there exist 2 values in array whose sum is equal to given sum.
     * @param inputArray input array.
     * @param sumToFind Sum to find in array.
     * @throws NullPointerException if input array is null.
     * @throws IllegalArgumentException if input array length is 0.
     * @return true if there exists 2 values in array, whose sum exists in array, false otherwise.
     */
     static final boolean isSumExistArray(int inputArray[], int sumtoFind) {
         
         // Store result.
         boolean result = false;
         
         // Starting position and ending position for array.
         int startingPosition, endingPosition;
         
         // Boundary condition.
         if (inputArray == null) {
             throw new NullPointerException("Array is null");
         } else if (inputArray.length == 0) {
             throw new IllegalArgumentException("Array length is 0");
         } else {
             // If length is 1 or 2, return false.
             if (inputArray.length == 1 || inputArray.length == 2) {
                 System.out.println("Array length must be greater than or equal to 3.");
                 return false;
             } else {
                 startingPosition = findStartingPosition(inputArray, 0, inputArray.length - 1);
                 
                 if (startingPosition == 0) {
                     endingPosition = inputArray.length - 1;
                 } else {
                     endingPosition = startingPosition - 1;
                 }
                 
                 while (startingPosition != endingPosition) {
                     
                     // If sum found, just return.
                     if (inputArray[startingPosition % (inputArray.length)] + inputArray[endingPosition % (inputArray.length)] == sumtoFind) {
                         result = true;
                         break;
                     } else if (inputArray[startingPosition] + inputArray[endingPosition] < sumtoFind) {
                         startingPosition = (startingPosition + 1) % (inputArray.length);
                     } else {
                         endingPosition--;
                         
                         if (endingPosition == -1) {
                             endingPosition = inputArray.length - 1;
                         }
                     }
                 }
                 
                 return result;
             }
         }
    }
          
     // Main method.
     public static void main(String[] args) {
         /**
          * inputArray Input array.
          * numberOfElements Number of elements in array.
          * index Index to loop through array.
          * sumToFind Sum which is to be found out.
          */
         int inputArray[], numberOfElements, index, sumToFind;
         
         // Get Scanner for input.
         Scanner scanner = new Scanner(System.in);
         
         System.out.println("Enter number of elements: ");
         numberOfElements = scanner.nextInt();
         
         inputArray = new int[numberOfElements];
         
         System.out.println("Enter array (sorted)");
         
         for (index = 0; index < numberOfElements; index++) {
             inputArray[index] = scanner.nextInt();
         }
         
         System.out.println("Enter sum to find");
         sumToFind = scanner.nextInt();
         
         if (isSumExistArray(inputArray, sumToFind)) {
             System.out.println("Sum exists in array");
         } else {
             System.out.println("Sum doesn't exist in array");
         }
         
         // Close resource.
         scanner.close();
     }
}
