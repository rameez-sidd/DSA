// Selecting an element and put it on its correct index

import java.util.Arrays;

public class SelectionSortAlgo{
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 3, 10, 34, 78, 12, 56, 98, 54, 62, 43, 27};
        System.out.println("Before Sorting : " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("After Sorting : " + Arrays.toString(arr));
    }

    static void selectionSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // find the max element in the remaining array and swap with correct index
            int last = n-i-1;
            int maxIndex = getMax(arr, 0, last);
            swap(arr, maxIndex, last);
        }
    }

    static int getMax(int[] arr, int start, int end){
        int max = start;
        for(int i= start+1; i<=end; i++){
            if(arr[i] > arr[max]){
                max = i;
            }
        }
        
        return max;
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}