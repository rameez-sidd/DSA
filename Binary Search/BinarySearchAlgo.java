public class BinarySearchAlgo{
    public static void main(String[] args){
        int[] sortedArray = {2, 4, 9, 11, 12, 16, 20, 36, 45, 90};
        int ans = binaySearch(sortedArray, 91);
        System.out.println(ans);
    }
    static int binaySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            // find the middle element
            // mid = (start + end)/2
            //might be possible that (start + end) exceeds the range of int in JAVA
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