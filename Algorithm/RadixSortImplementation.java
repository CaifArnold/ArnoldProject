package Algorithm;
import java.util.Arrays;

public class RadixSortImplementation {
    public static void main(String[] args){

    }
    // Get the maximum value to determine the number of digits
    private static int getMax(int[] arr){
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
    // Counting sort based on a specific digit
    private static void countingSort(int[] arr,int exp){
        int n=arr.length;
        int[] output=new int[n]; // Output array
        int[] count=new int[10];  // Count array
        // Initialize count array
        for(int i=0;i<count.length;i++){
            count[i]=0;
        }
        // Store the count of occurrences of each digit
        for(int i=0;i<n;i++){
            int index=(arr[i]/exp)%10;
            count[index]++;
        }
        // Update count array so that it contains positions of digits in output
        for(int i=1;i<count.length;i++){
            count[i]+=count[i-1];
        }
        // Build the output array
        for(int i=n-1;i>=0;i--){
            int index=(arr[i]/exp)%10;
            output[count[index]-1]=arr[i];
            count[index]--;
        }
        // Copy the output array to the original array
        for(int i=0;i<n;i++){
            arr[i]=output[i];
        }
    }
    // Main function to implement Radix Sort
    public static void radixSort(int[] arr){
        // Find the maximum number to determine the number of digits
        int max=getMax(arr);
        // Perform counting sort for each digit
        for(int exp=1;max/exp>0;exp*=10){
            countingSort(arr,exp);
        }
    }

}

