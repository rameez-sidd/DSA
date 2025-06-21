
public class RotationCount {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int ans = countRotation(arr);
        System.out.println(ans);
    }
    static int countRotation(int[] arr){
        int pivot = findPivot(arr);
        return (pivot+1);
    }

    // Use this when array contains no duplicates
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

    // Use this when array contains duplicates
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
}
