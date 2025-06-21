import java.util.Arrays;

public class RecursiveSelectionSort {
    
    public static void main(String[] args) {
        int[] arr = {9, 12, 78, 45, 23, 65, 302, 51, 22, 17};
        System.out.println(Arrays.toString(arr));
        sort(arr, arr.length, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int r, int c, int max){
        if(r==0){
            return;
        }
        if(c < r){
            if(arr[c] > arr[max]){
                sort(arr, r, c+1, c);
            } else{
                sort(arr, r, c+1, max);

            }
        }
        else{
            int temp = arr[c-1];
            arr[c-1] = arr[max];
            arr[max] = temp;

            sort(arr, r-1, 0, 0);
        }
    }
}
