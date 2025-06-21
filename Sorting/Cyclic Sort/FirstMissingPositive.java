// #amazon #leetcode-hard:41
// Given an unsorted integer numsay nums. Return the smallest positive integer that is not present in nums.
// You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, -1};
        int answer = findMissingPositive(nums);
        System.out.println("First Missing Positive : " + answer);
    }

    static int findMissingPositive(int[] nums){
        int n = nums.length;
        int i=0;
        while(i<n){
            int correctIdx = nums[i] - 1;
            if(nums[i] > 0 && nums[i] <= n && nums[i] != nums[correctIdx]){
                swap(nums, i, correctIdx);
            }
            else{
                i++;
            }
        }


        //search for first missing positive
        for (int idx = 0; idx < n; idx++) {
            if(nums[idx] != idx + 1){
                return idx + 1;
            }
        }


        return n+1;


    }

    static void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
