package Algorithm;
import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    // Main function to perform bucket sort
    public static void bucketSort(float[] arr) {
        int n=arr.length;
        if(n<=0) return;
        ArrayList<Float>[] buckets=new ArrayList[n];

        for(int i=0;i<n;i++) {
            buckets[i]=new ArrayList<>();
        }
        // Distributing input array values into buckets
        for(float num:arr) {
            int bucketIndex=(int)(num*n);
            if(bucketIndex>=n) bucketIndex=n-1; // Handle edge case
            buckets[bucketIndex].add(num);
        }
        // Sort individual buckets and concatenate the results
        int index=0;
        for(ArrayList<Float> bucket:buckets) {
            Collections.sort(bucket); // Sort the individual bucket
            for(float num:bucket) {
                arr[index++]=num; // Add sorted values back to the original array
            }
        }
    }

    public static float[] generateRandomFloat(float[] ranArr, int size, float min, float max){
        for(int i=0;i<ranArr.length;i++){
            ranArr[i]=(float)(Math.random()*(max-min));
        }
        return ranArr;
    }
    // Test the Bucket Sort function
    public static void main(String[] args) {
        float[] arr = new float[100];
        generateRandomFloat(arr,100,0.0f,1.0f);
        System.out.println("Original array:");
        printArray(arr);
        bucketSort(arr);
        System.out.println("Sorted array:");
        printArray(arr);
    }
    public static void printArray(float[] arr) {
        for (float num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
