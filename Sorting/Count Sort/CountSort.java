
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 3, 2, 5, 2};
        System.out.println("Original Array: " + Arrays.toString(arr));

        // countSort(arr);
        countSortHash(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));

    }

    static void countSort(int[] arr){
        if(arr == null || arr.length == 0) {
            return; 
        }

        int max = findMax(arr);

        int[] countArray = new int[max + 1];

        for(int num : arr){
            countArray[num]++;
        }

        int index = 0;
        for(int i = 0; i < countArray.length; i++){
            while(countArray[i] > 0){
                arr[index++] = i;
                countArray[i]--;
            }
        }
    }


    // Using HashMap
    static void countSortHash(int[] arr){
        if(arr == null || arr.length == 0) {
            return; 
        }

        int min = findMin(arr);     // more efficeint if we use min and max
        int max = findMax(arr);

        Map<Integer, Integer> countMap = new HashMap<>();

        for(int num : arr){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int index = 0;
        for(int i = min; i <= max; i++){
            int count = countMap.getOrDefault(i, 0);
            while(count > 0){
                arr[index++] = i;
                count--;
            }
        }
    }

    static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
