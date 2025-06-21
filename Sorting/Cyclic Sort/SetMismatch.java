// #leetcode:645
// You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
// You are given an integer array nums representing the data status of this set after the error.
// Find the number that occurs twice and the number that is missing and return them in the form of an array.

import java.util.Arrays;

public class SetMismatch {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] answer = findMismatch(nums);
        System.out.println("Mismatched : " + Arrays.toString(answer));
    }

    static int[] findMismatch(int[] nums){
        int n = nums.length;
        int i = 0;
        while(i < n){
            int correctIdx = nums[i] - 1;
            if(nums[i] != nums[correctIdx]){
                swap(nums, i, correctIdx);
            }
            else{
                i++;
            }

        }


        // searching for the disappeared numbers
        for (int idx = 0; idx < n; idx++) {
            if(nums[idx] != idx + 1){
                return new int[] {nums[idx], idx+1};
            }
        }
        return new int[] {-1, -1};
    }
    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}