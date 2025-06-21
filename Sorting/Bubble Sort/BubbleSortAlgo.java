import java.util.Arrays;

public class BubbleSortAlgo{
    public static void main(String[] args) {
        int[] arr = {-1, 7, 0, -54, 8, 43};
        System.out.println("Before Sorting : " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("After Sorting : " + Arrays.toString(arr));
    }
    static void bubbleSort(int[] arr){
        int n = arr.length;
        boolean swapped;
        for(int i=0; i<n; i++){   // counter i will run for (n-1) times  (i.e. n-1 passes)
            // for each pass, greatest element will come at the last respective index
            swapped = false;
            for(int j=1; j<n-i; j++){   // j will run from 1 to (n-(i+1))
                // swap if the element is smaller than previous element
                if(arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            // if you did not swap for a particular value of i
            // it means the array is sorted
            // hence stop the loop  (Dont need to check further)
            if(!swapped){
                break;
            }
        }
    }
}