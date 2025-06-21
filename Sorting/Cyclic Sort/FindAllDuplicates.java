// #leetcode:442
// Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.
// You must write an algorithm that runs in O(n) time and uses only constant extra space.

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> answer = new ArrayList<>();
        answer = findAllDuplicates(nums);
        System.out.println("Duplicate Numbers : " + answer);
    }

    static List<Integer> findAllDuplicates(int[] nums){
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

        List<Integer> answer = new ArrayList<>();

        // searching for the duplicate numbers
        for (int idx = 0; idx < n; idx++) {
            if(nums[idx] != idx + 1){
                answer.add(nums[idx]);
            }
        }
        return answer;

    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
