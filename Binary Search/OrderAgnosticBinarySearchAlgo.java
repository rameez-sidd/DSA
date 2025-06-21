public class OrderAgnosticBinarySearchAlgo {
    public static void main(String[] args) {
        int[] arr = {90, 45, 36, 23, 18, 14, 11, 9, 8, 3, -4};
        int target = 87;
        int ans = orderAgnosticBinarySearch(arr, target);
        System.out.println(ans);
    }
    static int orderAgnosticBinarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        boolean isAsc = arr[start] < arr[end];
        // if(arr[start] < arr[end]){
        //     // Ascending Order
        // }
        // else{
        //     // Descending Order
        // }
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
