// #google #leetcode:448
// Given an array nums of n integers where nums[i] is in the ranege [1, n], return an array of all the integers in the range that do not appear in nums

import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> answer = new ArrayList<>();
        answer = findDisappearedNums(nums);
        System.out.println("Disappeared Numbers : " + answer);
    }    

    static List<Integer> findDisappearedNums(int[] nums){
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

        // searching for the disappeared numbers
        for (int idx = 0; idx < n; idx++) {
            if(nums[idx] != idx + 1){
                answer.add(idx+1);
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
