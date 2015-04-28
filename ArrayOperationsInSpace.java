/**
 * Refer geeksforgeeks: http://www.geeksforgeeks.org/rearrange-array-arrj-becomes-arri-j/
 * Refer geeksforgeeks: http://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
 * Refer geeksforgeeks: http://www.geeksforgeeks.org/find-the-maximum-repeating-number-in-ok-time/
 * Refer geeksforgeeks: http://www.geeksforgeeks.org/majority-element/
 */

import java.util.HashMap;
import java.util.Scanner;

/**
 * Class to solve different questions of arrays in O(1) space.
 * @author gaurav
 */

class ArrayOperationsInSpace {

    static final class Result {
        
        final int countRepeatingElements;
        final HashMap<Integer, Integer> repeatingElements;
        
        /**
         * Constructor to initialize Result object with given parameters.
         * @param count Count of repeating elements in array.
         * @param repeatingElements Array of repeating elements.
         */
        Result(int count, HashMap<Integer, Integer> repeatingElements) {
            
            // Initialize hashmap.
            this.repeatingElements = new HashMap<Integer, Integer>();
            
            this.countRepeatingElements = count;
            this.repeatingElements.putAll(repeatingElements);
        }
    }
    /**
     * Method to find maximum repeating number in an array in O(n) time and O(1) space.
     * @param inputArray Input array. Range of input array elements (varies from 0 to length-1).
     * @throws NullPointerException if input array is null.
     * @throws IllegalArgumentException if input array length is 0.
     * @return Maximum repeating element.
     */
    static final int findMaxRepeatingNumber(int inputArray[]) {
        
        // Store maximum repeating element.
        // Index to loop through array.
        int maxRepeatElement, index;

        // Maximum count in array.
        int max, maxIndex;
        
        // Boundary condition.
        if (inputArray == null) {
            throw new NullPointerException("Array is null");
        } else if (inputArray.length == 0) {
            throw new IllegalArgumentException("Array length is 0");
        } else {
        
            if (inputArray.length == 1) {
                maxIndex = inputArray[0];
            } else {
             // For each inputArray[i], add length to inputArray[inputArray[i]].
                // This gives the original element at index i using (inputArray[i] % length).
                for (index = 0; index < inputArray.length; index++) {
                    
                    inputArray[inputArray[index] % inputArray.length] += inputArray.length;
                }
                
                maxIndex = inputArray[0];
                max = inputArray[0];
                
                // Find the maximum element in this array now, to get the maximum repeating element.
                for (index = 1; index < inputArray.length; index++) {
                    
                    if (max < inputArray[index]) {
                        max = inputArray[index];
                        maxIndex = index;
                    }
                }
            }
            
            // Find maximum repeating element.
            maxRepeatElement = maxIndex;
        
            // Return maximum repeating element.
            return maxRepeatElement;
        }
    }
    
    /**
     *  Method to set inputArray[i] = j if inputArray[j] = i in O(n) time and O(1) space.
     *  Elements are in the range 0 to inputArray.length - 1.
     *  @param inputArray Input array.
     *  @throws NullPointerException if input array is null.
     *  @throws IllegalArgumentException if input array length is 0.
     */
    static final void replaceArrayIByJ(int inputArray[]) {
        
        // Index to loop through array.
        int index;
        
        // Boundary condition.
        if (inputArray == null) {
            throw new NullPointerException("Array is null");
        } else if (inputArray.length == 0) {
            throw new IllegalArgumentException("Array length is 0");
        } else {
        
            if (inputArray.length == 1) {
                return;
            } else {
                
                /**
                 *  if inputArray[1] = 0, we need to set inputArray[0] = 1.
                 *  Suppose inputArray[0] = 3, then we need to update 3 to 1, such that we find 3 when needed.
                 *  Set inputArray[0] = (3 + 1*4) = 7. We get oldValue using 7%4 = 3, new value using 7/4 = 1. 
                 */
                for (index = 0; index < inputArray.length; index++) {
                    
                    inputArray[inputArray[index] % inputArray.length] += inputArray.length*index;
                }
                
                // Update array to new values.
                for (index = 0; index < inputArray.length; index++) {
                    inputArray[index] /= inputArray.length;
                }
                
                System.out.print("Array after changing values:");
                for (index = 0; index < inputArray.length; index++) {
                    System.out.print(" " + inputArray[index]);
                }
            }
        }
    }
    
    /**
     * Moore's Voting algorithm. [O(n) time and O(1) auxiliary space]
     * Method to find majority element in a given array (occurrence greater than (inputArray.length/2) times).
     * This method fails if no element is majority element. 
     * @param inputArray input array.
     * @throws NullPointerException if input array is null.
     * @throws IllegalArgumentException if input array length is 0.
     * @return majority element if it exists, -1 otherwise.
     */
    static final int findMajorityElement(int inputArray[]) {
        
        /**
         * @param currentCandidate Current candidate for majority occurrence consideration.
         * @param candidateCount count of present candidate in array.
         * @param index Index to loop through array.
         * @param majorityElement Majority element in array if it exists, -1 otherwise.
         */
        int currentCandidate, candidateCount, index, majorityElement = -1;
        
        // Boundary condition.
        if (inputArray == null) {
            throw new NullPointerException("Array is null");
        } else if (inputArray.length == 0) {
            throw new IllegalArgumentException("Array length is 0");
        } else {
        
            if (inputArray.length == 1) {
                majorityElement = inputArray[0];
            } else {
                
                /**
                 * As a first step, we find the candidate which may be the majority element if it exists.
                 */
                
                currentCandidate = inputArray[0];
                candidateCount = 1;
                
                for (index = 1; index < inputArray.length; index++) {
        
                    // If current index element is equal to currentCandidate, increment candidate count.
                    if (inputArray[index] == currentCandidate) {
                        candidateCount++;
                    } else if (inputArray[index] != currentCandidate) {
                        
                        // Decrement currentCandidate's count if present value doesn't match it and count is > 1.
                        if (candidateCount > 1) {
                            candidateCount--;
                        } else {
                            // Choose a new candidate, as previous candidate count was 1.
                            currentCandidate = inputArray[index];
                            candidateCount = 1;
                        }
                    }
                }
                
                candidateCount = 0;
                /**
                 * As second step, check whether chosen element is majority element.
                 */
                for (index = 0; index < inputArray.length; index++) {
                    
                    if (inputArray[index] == currentCandidate) {
                        candidateCount++;
                    }
                }
                
                if (candidateCount > inputArray.length/2) {
                    majorityElement = currentCandidate;
                } else {
                    majorityElement = -1;
                }
            }
            
            // Finally, return the majority element.
            return majorityElement;
        }
    }
    
    /**
     * Method to find repeating elements in an array and their count.
     * Each element of array varies from 0 to inputArray.length - 1.
     * @param inputArray input array.
     * @throws NullPointerException if input array is null.
     * @throws IllegalArgumentException if input array length is 0.
     * @return result Result object containing array of repeating elements, and their count.
     */
    static final Result findRepeatingElements(int inputArray[]) {
        
        // Index to loop through array.
        int index;

        // Store result.
        Result result = null;

        // HashMap to hold repeated elements.
        HashMap<Integer, Integer> repeatedElementsMap = new HashMap<>();

        // Count to store count of repeated elements.
        int count = 0;

        // Boundary condition.
        if (inputArray == null) {
            throw new NullPointerException("Array is null");
        } else if (inputArray.length == 0) {
            throw new IllegalArgumentException("Array length is 0");
        } else {

            /**
             * Idea is to replace inputArray[index] with -inputArray[index].
             * Whenever we encounter negative value at an index, means that
             * index is repeated.
             */
            for (index = 0; index < inputArray.length; index++) {

                if (inputArray[Math.abs(inputArray[index] % inputArray.length)] > 0) {
                    inputArray[Math.abs(inputArray[index] % inputArray.length)] = -inputArray[Math
                            .abs(inputArray[index] % inputArray.length)];
                } else if (inputArray[Math.abs(inputArray[index]
                        % inputArray.length)] == 0) {
                    inputArray[Math.abs(inputArray[index] % inputArray.length)] = -inputArray.length;
                } else {

                    // Repeating element.
                    int key = Math.abs(inputArray[index]
                            % inputArray.length);

                    // It's repeated. Add to result.
                    if (result == null) {
                        repeatedElementsMap.put(key, 0);

                        result = new Result(++count, repeatedElementsMap);
                    } else {

                        // Get new result.
                        result = constructNewResult(result, key);
                    }

                }
            }
            return result;
        }

    }
    
    /**
     * Helper method to construct new results based on old results.
     * @param oldResult Old result object.
     * @param key Key to add in repeatingElements map.
     * @throws NullPointerException if oldResult is null.
     * @return newResult New result on basis of updated hashmap, or reference to old one, in case there's no updation in map.
     */
    static final Result constructNewResult(Result oldResult, int key) {
        
        // Result to return.
        Result newResult;
        
        // Boundary condition.
        if (oldResult == null) {
            throw new NullPointerException("Old result is null");
        } else {
            
            // Check whether key already exists in oldResult.
            if (oldResult.repeatingElements.containsKey(key)) {
                return oldResult;
            } else {
                
                // Make new map.
                HashMap<Integer, Integer> newMap = new HashMap<>();
                newMap = oldResult.repeatingElements;
                
                newMap.put(key, 0);
                
                newResult = new Result(oldResult.countRepeatingElements + 1, newMap);
                return newResult;
            }
        }
    }
    // Main method.
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
        
        System.out.println("Enter array :");
        
        for (index = 0; index < numberOfElements; index++) {
            inputArray[index] = scanner.nextInt();
        }
        
        //System.out.println("Maximum repeating element is: " + findMaxRepeatingNumber(inputArray));
        //replaceArrayIByJ(inputArray);
        
        // Find majority element in array.
        /*if (findMajorityElement(inputArray) == -1) {
            System.out.println("There's no majority element.");
        } else {
            System.out.println("Majority element is: " + findMajorityElement(inputArray));
        }*/
        
        // Find repeating elements and their count.
        Result result = findRepeatingElements(inputArray);
        if (result == null) {
            System.out.println("No repeating elements found in array");
        } else {
            System.out.println("Repeating elements are: " + result.repeatingElements + " and their count: " + result.countRepeatingElements);
        }
        // Close resource.
        scanner.close();
    }
}
