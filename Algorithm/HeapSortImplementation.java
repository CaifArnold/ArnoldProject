package Algorithm;
import java.lang.Math;
import java.util.Arrays;


public class HeapSortImplementation {
    public static void main (String[] args){
        int[] arr1 = new int[1000];
        int size = arr1.length;
        generateArrayRandom(arr1, size);
        System.out.println("This is the origin array: " + Arrays.toString(arr1));
        buildHeap(arr1);
        System.out.println("This is the array after heapified: " + Arrays.toString(arr1));

    }

    public static int[] generateArrayRandom(int[] ranArr, int size){
        for(int i=0; i<size; i++){
            ranArr[i]= (int) (Math.random()*1000);
        }
        return ranArr;


    }

    public static void maxHeapify(int[] arr, int i) {
        int n = arr.length;
        int largest = i; // The current node
        int left = 2 * i + 1; // The left child
        int right = 2 * i + 2; // The right child

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            // Swap arr[i] and arr[largest]
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected sub-tree
            maxHeapify(arr, largest);
        }
    }

    public static void buildHeap(int[] arr) {
        int n = arr.length;
        int first = (n / 2) - 1; // The last parent node
        for (int i = first; i >= 0; i--) {
            maxHeapify(arr, i);
        }
    }



}
