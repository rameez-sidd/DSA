// An array arr is a mountain if the following properties hold:
// 1. arr.length >= 3
// 2. There exists some i with 0 < i < arr.length - 1 such that:
// 3. arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
// 4. arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
// Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

// You must solve it in O(log(arr.length)) time complexity.
// Input: arr = [0,2,1,0]
// Output: 1
public class PeakInMountainArray{
    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 0};
        int ans = peak(arr);
        System.out.println(ans);
    }
    static int peak(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            int mid = start + (end-start)/2;
            if(arr[mid] > arr[mid+1]){  // in the decreasing part of the array
                // this may be the answer but look in left
                // this is why end != mid-1
                end = mid; 
            }
            else if(arr[mid] < arr[mid+1]){  // in the increasing part of the array
                // because we know that arr[mid+1] > arr[mid] 
                // this is why start is one index right to mid
                start = mid + 1;
            }
    
        }
        // In the end both start and end point to the largest number because of the 2 checks above
        // start and end are always trying to find max element in the above 2 checks
        // hence, when they are pointing to just one element, that is the max one because that is what the checks say
        // More Elaboration : At every point of time for start and end, they have the best possible answer till that time
        // and if we are saying that only one item is remaining, hence because of above line that is the best possible answer
        return end;

    }
}
