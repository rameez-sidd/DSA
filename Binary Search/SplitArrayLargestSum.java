// Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

// Return the minimized largest sum of the split.

// A subarray is a contiguous part of the array.
// Input: nums = [7,2,5,10,8], k = 2
// Output: 18
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 10, 8};
        int k = 2;
        int ans = splitArray(arr, k);
        System.out.println(ans);
    }
    static int splitArray(int[] arr, int k){
        int start = 0;  // max element in the array
        int end = 0;    // sum of all elements of array
        for(int i=0; i<arr.length; i++){
            start = Math.max(start, arr[i]);  // in the end of the loop this will contain the max element
            end += arr[i];
        }

        // binary search
        while (start < end){
            // try for the middle as potential ans
            int mid = start + (end-start)/2;

            // calculate how many pieces you can divide this in with this max sum
            int sum = 0;
            int pieces = 1;
            for(int element : arr){
                if(sum + element > mid){
                    // you cannot add this in this subarray, make new one
                    // say you add this element in new subarray, then sum = element
                    sum = element;
                    pieces++;
                }
                else{
                    sum += element;
                }
            }
            if(pieces > k){
                // we need bigger sum so shift start to mid+1
                start = mid + 1;
            }
            else{
                // we need smaller sum so shift end to mid
                // remember that even if pieces=k then also we need ti shift the end because we need minimized sum
                // and because of the same reason we have done end=mid [not mid-1]
                // as mid can be the possible answer
                end = mid;
            }

        }
        return end;
    }
}
