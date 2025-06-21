// #amazon #leetcode:268
// Given an array of n distinct numbers in the range [0, n]. return the only number in the range that is missing from the array


public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {3, 1, 0, 2};
        int n = 4;
        int answer = findMissingNumber(arr, n);
        System.out.println("Missing number : " + answer);
    }

    static int findMissingNumber(int[] arr, int n){
        int i=0;
        while(i<n){
            int correctIdx = arr[i];
            if(arr[i] < n && arr[i] != arr[correctIdx]){
                swap(arr, i, correctIdx);
            }
            else{
                i++;
            }
        }

       

        //search for first missing number
        for (int j = 0; j < n; j++) {
            if(arr[j] != j){
                return j;
            }
        }

        //when n is not available in the array
        return n;
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
