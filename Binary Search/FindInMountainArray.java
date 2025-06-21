// Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.
// Input: array = [1,2,3,4,5,3,1], target = 3
// Output: 2
public class FindInMountainArray {
    public static void main(String[] args) {
        int[] mountainArr = {1, 2, 4, 5, 3, 1};
        int target = 3;
        int ans = findInMountainArray(mountainArr, target);
        System.out.println(ans);
    }
    static int findInMountainArray(int[] arr, int target){
        int peak = peakIndexMountainArray(arr);
        int firstTry = binaySearch(arr, target, 0, peak);
        if(firstTry!=-1){
            return firstTry;
        }
        else{
            return orderAgnosticBinarySearch(arr, target, peak+1, arr.length-1);
        }
    }
    static int peakIndexMountainArray(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            int mid = start + (end-start)/2;
            if(arr[mid] > arr[mid+1]){  // in the decreasing part of the array
                end = mid; 
            }
            else if(arr[mid] < arr[mid+1]){  // in the increasing part of the array
                start = mid + 1;
            }
    
        }
        return end;

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
    static int orderAgnosticBinarySearch(int[] arr, int target, int start, int end){
        boolean isAsc = arr[start] < arr[end];
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(isAsc){
                if(target < arr[mid]){
                    end = mid-1;
                }
                else if(target > arr[mid]){
                    start = mid+1;
                }
            }
            else{
                if(target < arr[mid]){
                    start = mid+1;
                }
                else if(target > arr[mid]){
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}
