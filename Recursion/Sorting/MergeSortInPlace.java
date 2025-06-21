import java.util.*;

public class MergeSortInPlace {
    public static void main(String[] args) {
        int[] arr = { 8, 3, 4, 12, 5, 6 };

        System.out.println("Before Sorting");
        System.out.println(Arrays.toString(arr));

        mergeSort(arr, 0, arr.length);

        System.out.println("After Sorting");
        System.out.println(Arrays.toString(arr));

    }

    static void mergeSort(int[] arr, int s, int e) {     // end is exclusive here
        if (e - s == 1) {  
            return;
        }

        int m = s + (e - s) / 2;

        mergeSort(arr, s, m);
        mergeSort(arr, m, e);

        merge(arr, s, m, e);
    }

    static void merge(int[] arr, int s, int m, int e) {
        int[] mix = new int[e - s];

        int i = s;
        int j = m;
        int k = 0;

        while (i < m && j < e) {
            if (arr[i] <= arr[j]) {
                mix[k] = arr[i++];
            } else {
                mix[k] = arr[j++];

            }
            k++;
        }

        // it may be possible that one of the arrays is not traversed completely
        // copy the remaining elements
        while (i < m) {
            mix[k++] = arr[i++];
        }

        while (j < e) {
            mix[k++] = arr[j++];
        }

        for(int l=0; l<mix.length; l++){
            arr[s+l] = mix[l];
        }

    }
}