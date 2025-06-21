import java.util.Arrays;

// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
// If target is not found in the array, return [-1, -1].
// You must write an algorithm with O(log n) runtime complexity.

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
public class FirstAndLastPos {
    public static void main(String[] args) {
        int[] nums = {8, 8, 8, 8, 8, 8, 8, 10};
        int target = 8;
        int[] ans = searchRange(nums, target);
        System.out.println(Arrays.toString(ans));
    }
    static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        // suppose we find the element but we are not sure about whether it is first occurence or last or what
        // So, we need to search for the first occurence in the left section
        // and search for the last occurence in the right section
        // That's why we have run binary search twice for finding the first and last occurence
        // the function search() simply returns the first occurence (if we pass findStartIndex as true)
        // returns the last occurence (if we pass findStartIndex as false)
        int start = search(nums, target, true); // finding the first occurence of element
        int end = search(nums, target, false);  // finding the last occurence of element
        ans[0] = start;
        ans[1] = end;
        return ans;
    }

    // this function just returns the index value of target
    static int search(int[] nums, int target, boolean findStartIndex){
        int ans = -1;
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(target > nums[mid]){
                start = mid + 1;
            }
            else if(target < nums[mid]){
                end = mid - 1;
            }
            else{
                // possible answer
                ans = mid;
                if(findStartIndex){    // Shifting the pointers accordingly 
                    end = mid -1;      // when searching for first occurence 
                }
                else{
                    start = mid + 1;   // when searching for last occurence
                }
            }
        }
        return ans;
    }
}
