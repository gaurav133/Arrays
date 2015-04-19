//Refer geeksforgeeks : http://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/

import java.util.HashMap;
import java.util.Scanner;

public class SubArrayZeroSum {

    public boolean isSubArrayZeroSumExists(int arr[]) {
        
        int element, sum = arr[0];
        
        //Define a hashmap.
        HashMap<Integer, Integer> map = new HashMap<>();
        
        //Traverse the array.
        for (int i = 0; i < arr.length;) {
            
            map.put(sum, 0);
            sum += arr[i++];
            
            if (map.containsKey(sum)) {
                return true;
            }
        }
        return false;
    }
    
    public static void main (String[] args) {
        SubArrayZeroSum subArray = new SubArrayZeroSum();
        int num1, array1[], i;
        boolean result;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter number of elements in array 1:");
        num1 = scanner.nextInt();
        
        array1 = new int[num1];
        
        System.out.println("Enter array:");
        for (i = 0; i < array1.length; i++) {
            array1[i] = scanner.nextInt();
        }
        
        result = subArray.isSubArrayZeroSumExists(array1);
        
        System.out.println("Subarray with zero sum exists: " + result);
        scanner.close();
    }
}
