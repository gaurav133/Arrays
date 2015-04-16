import java.util.Scanner;

//Refer to GeeksForGeeks post: http://www.geeksforgeeks.org/find-number-zeroes/

public class ArrayCountZeros {

    // Wrapper function.
    public int countZerosWrapper(int arr[]) {

        // Boundary case, array length 0.
        if (arr.length == 0) {
            System.out.println("Array length is 0");
            return 0;
        } else {
            return (arr.length - countZeros(arr, 0, arr.length - 1));
        }
    }

    public int countZeros(int arr[], int low, int high) {

        int mid;

        if (low > high) {
            return 0;
        } else {
            mid = (low + high) / 2;

            // Boundary cases.. 000 or 111.. just return.
            if (arr[low] == 0) {
                return low;
            } else if (arr[high] == 1) {
                return (high - low + 1);
            } else {

                if (arr[mid] == 0 && arr[mid - 1] == 1) {
                    return mid;
                } else if (arr[mid] == 1 && arr[mid + 1] == 0) {
                    return mid + 1;
                } else {
                    if (arr[mid] == 0 && arr[mid - 1] == 0) {
                        return countZeros(arr, low, mid - 1);
                    } else {
                        return countZeros(arr, mid + 1, high);
                    }
                }
            }
        }

    }
    
    public static void main(String[] args) {
        ArrayCountZeros obj = new ArrayCountZeros();
        Scanner scanner = new Scanner(System.in);
        int array[], num;
        
        System.out.println("Enter number of elements:");
        num = scanner.nextInt();
        
        array = new int[num];
        
        System.out.println("Enter array:");
        for (int i = 0; i < num; i++) {
            array[i] = scanner.nextInt();
        }
        
        System.out.println("Zeros count: " + obj.countZerosWrapper(array));
        
    }
}
