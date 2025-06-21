import java.util.Arrays;

public class InsertionSortAlgo {

    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 4, 2};
        System.out.println("Before Sorting : " + Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("After Sorting : " + Arrays.toString(arr));
    }

    static void insertionSort(int[] arr){
        int n = arr.length;

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j>0; j--){
                if(arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
                }
                else{
                    break;
                }
            }
        }
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}