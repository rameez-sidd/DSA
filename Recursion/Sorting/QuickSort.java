import java.util.Arrays;

public class QuickSort{
    public static void main(String[] args) {
        int[] arr = { 8, 3, 4, 12, 5, 6 };

        System.out.println("Before Sorting");
        System.out.println(Arrays.toString(arr));

        quickSort(arr, 0, arr.length-1);

        System.out.println("After Sorting");
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }
        int s = low;
        int e = high;
        int mid = s + (e-s)/2;
        int pivot = arr[mid];

        while (s <= e) {
            // also a reason why if its already sorted, it will not swap
            while (arr[s] < pivot) {
                s++;
            }
            while (arr[e] > pivot) {
                e--;
            }

            if(s <= e){
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }
        }

        // now my pivot at its correct index, please sort two halves now
        quickSort(arr, low, e);
        quickSort(arr, s, high);
    }
}