// #amazon #google
// There is an integer array nums sorted in ascending order (with distinct values).

// Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

// Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

// You must write an algorithm with O(log n) runtime complexity.

// #APPROACH - 1:
// 1. Find the pivot element
// 2. Apply Binary Search in left-half (0, pivot) 
// 3. If not find in left-half, Apply Binary Search in right-half (pivot+1, end)
public class SearchInRotatedArray{
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 5;
        int ans = search(arr, target);
        System.out.println(ans);
    }
    static int search(int[] arr, int target){
        int pivot = findPivot(arr);
        if(pivot == -1){  // case 1
            return binaySearch(arr, target, 0, arr.length-1);
        }
        if(arr[pivot] == target){  // case 2
            return pivot;
        }
        // Equal case is defined in this if statement because when 
        // arr[start] is itself the target then we need to search in the left-half
        if(target >= arr[0]){   // case 3
            return binaySearch(arr, target, 0, pivot-1);    // Searching in left-half
        }
        if(target < arr[0]){    // case 4
            return binaySearch(arr, target, pivot+1, arr.length-1);    // Searching in right-half
        }
        return -1;
    }
    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            // making sure mid+1 doesn't go out of bound
            if(mid < end && arr[mid] > arr[mid+1]){       // case 1
                return mid;
            }
            // making sure mid-1 doesn't go out of bound
            if(mid > start && arr[mid] < arr[mid-1]){       // case 2
                return mid-1;
            }
            if(arr[start] >= arr[mid]){      // case 3
                end = mid-1;
            }
            else if(arr[start] < arr[mid]){   // case 4
                start = mid+1;
            }
        }
        return -1;
        
    }
    static int binaySearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start + (end-start)/2;
            if(target < arr[mid]){
                end = mid - 1;
            }
            else if(target > arr[mid]){
                start = mid + 1;
            }
            else{
                return mid;
            }

        }
        return -1;
    }
}