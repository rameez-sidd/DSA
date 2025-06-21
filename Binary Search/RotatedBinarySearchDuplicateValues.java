
public class RotatedBinarySearchDuplicateValues {
    public static void main(String[] args) {
        int[] arr = {2, 9, 2, 2, 2, 2};
        int target = 2;
        int ans = search(arr, target);
        System.out.println(ans);
    }
    static int search(int[] arr, int target){
        int pivot = findPivotWithDuplicates(arr);
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
    static int findPivotWithDuplicates(int[] arr){
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
            // If elements at middle, start, end are equal then just skip the duplicates
            if(arr[mid] == arr[start] && arr[mid] == arr[end]){
                // What if these elements at start and end were the pivot??
                if(arr[start] > arr[start+1]){
                    return start;
                }
                start++;
                if(arr[end] < arr[end-1]){
                    return end-1;
                }
                end--;
            }
            // if left side is sorted, so pivot should be in right-half
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])){
                start = mid + 1;
            }
            else{
                end = mid - 1;
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
