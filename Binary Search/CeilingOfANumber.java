// Ceiling of a number = Smallest element in an array which is greater than or equal to target
// An array and a target will be given you have to find the Ceiling of that target number from the array
// E.g. arr = [2, 3, 5, 9, 14, 16, 18], target = 4
// output = 5
public class CeilingOfANumber{
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int target = 19;
        int ans = findCeiling(arr, target);
        System.out.println(ans);
    }
    static int findCeiling(int[] arr, int target){
        // What if the target is greater thena the greatest number in the array
        if(target > arr[arr.length-1]){
            return -1;
        }
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(target < arr[mid]){
                end = mid - 1;
            }
            else if(target > arr[mid]){
                start = mid + 1;
            }
            else{
                return arr[mid];
            }
        }
        // start <= end ===> When the while loop breaks ====> start = end + 1
        // when target is not found ===> next big number is at start
        return arr[start];
    }
}