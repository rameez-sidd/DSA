import java.util.Arrays;

public class MergeSort{
    public static void main(String[] args) {
        int[] arr = {8, 3, 4, 12, 5, 6};
        System.out.println(Arrays.toString(arr));
        int[] sortedArray = mergeSort(arr);
        System.out.println(Arrays.toString(sortedArray));

    }

    static int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }

        int mid = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));   // here, the last argument is exclusive
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    static int[] merge(int[] first, int[] second){
        int[] mix = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i<first.length && j<second.length) {
                if(first[i] <= second[j]){
                    mix[k] = first[i++];
                } else {
                    mix[k] = second[j++];

                }
                k++;
        }

        // it may be possible that one of the arrays is not traversed completely
        // copy the remaining elements
        while (i<first.length) {
            mix[k++] = first[i++];
        }

        while (j<second.length) {
            mix[k++] = second[j++];
        }

        return mix;
    }
}