package Algorithm;

import java.util.Arrays;

public class TestTwoAlgs {
    public static void main(String[] args){
        //construct two instances
        HeapSortImplementation h = new HeapSortImplementation();
        RadixSortImplementation r = new RadixSortImplementation();
        //generate the same arrays
        int[] arr1 = new int[1000];
        int size = arr1.length;
        generateArrayRandom(arr1, size);
        int[] arr2 = arr1.clone();
        long start1 = System.nanoTime();
        h.buildHeap(arr1);
        long end1 = System.nanoTime();
        long hTime = end1 - start1;
        long start2 = System.nanoTime();
        r.radixSort(arr1);
        long end2 = System.nanoTime();
        long rTime = end2 - start2;
        System.out.println("This is the origin array: " + Arrays.toString(arr1));
        System.out.println("This is the array after radixsort: " + Arrays.toString(arr2));
        System.out.println("This is the array after heapified: " + Arrays.toString(arr2));
        System.out.println("Time for heapSort alg: " + hTime + " nanosecond");
        System.out.println("Time for RadixSort: " + rTime + " nanosecond");
    }

    public static int[] generateArrayRandom(int[] ranArr, int size){
        for(int i=0; i<size; i++){
            ranArr[i]= (int) (Math.random()*1000);
        }
        return ranArr;
    }
}
