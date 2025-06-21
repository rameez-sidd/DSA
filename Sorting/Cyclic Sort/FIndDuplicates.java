// #amazon #microsoft #leetcode:287
// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
// There is only one repeated number in nums, return this repeated number.
// You must solve the problem without modifying the array nums and uses only constant extra space.

public class FIndDuplicates {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 2, 2 };
        int answer = findDuplicates(nums);
        System.out.println("Duplicate number : " + answer);
    }

    static int findDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {

            if (nums[i] != i + 1) {
                int correctIdx = nums[i] - 1;
                if (nums[i] != nums[correctIdx]) {
                    swap(nums, i, correctIdx);
                } 
                else {
                    return nums[i];
                }
            }
            else{
                i++;
            }

            
        }
        return -1;


    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
