//Refer GeeksforGeeks : http://www.geeksforgeeks.org/maximum-sum-path-across-two-arrays/

import java.util.Scanner;

public class MaxSumTwoArrays {
    
    public int returnMaxSum(int arr1[], int arr2[]) {
        int temp1, temp2, sum;
        
        sum = 0;
        temp1 = arr1[0];
        temp2 = arr2[0];
        
        int i,j;
        i = j = 0;
        
        //Traverse while both arrays exist.
        
        while (i < arr1.length - 1 && j < arr2.length - 1) {
            
            if (arr1[i] < arr2[j]) {
                i++;
                temp1 += arr1[i];
            } else if (arr1[i] > arr2[j]) {
                j++;
                temp2 += arr2[j];
            } else {
                i++;
                j++;
                sum += (temp1 > temp2 ? temp1 : temp2);
                temp1 = arr1[i];
                temp2 = arr2[j];
            }
        }
        
        if (i == arr1.length - 1) {
            while (j < arr2.length) {
                j++;
                if (j == arr2.length)
                    break;
                temp2 += arr2[j];
            }
        }
        
        if (j == arr2.length - 1) {
            while (i < arr1.length) {
                i++;
                
                if (i == arr1.length)
                    break;
                temp1 += arr1[i];
            }
        }
        
        sum += (temp1 > temp2 ? temp1 : temp2);
        
        return sum;
    }
    
    public static void main (String[] args) {
        MaxSumTwoArrays sumArrays = new MaxSumTwoArrays();
        int num1, num2, array1[], array2[], i, j, maxSum;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter number of elements in array 1:");
        num1 = scanner.nextInt();
        
        array1 = new int[num1];
        
        System.out.println("Enter elements for array 1:");
        for (i = 0; i < num1; i++) {
            array1[i] = scanner.nextInt();
        }
        
        System.out.println("Enter number of elements in array 2:");
        num2 = scanner.nextInt();
        
        array2 = new int[num2];
        
        System.out.println("Enter elements for array 2:");
        for (i = 0; i < num2; i++) {
            array2[i] = scanner.nextInt();
        }
        
        maxSum = sumArrays.returnMaxSum(array1, array2);
        
        System.out.println("Maximum sum is: " + maxSum);
        
        //Free up resources.
        scanner.close();
        
    }
}
