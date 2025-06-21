//Use when there is a range from 1 to N

import java.util.Arrays;

public class CyclicSortAlgo {

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 1, 4};
        System.out.println("Before Sorting : " + Arrays.toString(arr));
        cyclicSort(arr);
        System.out.println("After Sorting : " + Arrays.toString(arr));
    }

    static void cyclicSort(int[] arr){
        int n = arr.length;

        int i=0;
        while(i<n){
            int correctIdx = arr[i] - 1;
            if(arr[i] != arr[correctIdx]){
                swap(arr, i, correctIdx);
            }
            else{
                i++;
            }
        }



        // OR

        // for(int i=0; i<n; i++){
        //     while (i != arr[i]-1) {
        //         swap(arr, i, arr[i]-1);
        //     }
        // }


    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}