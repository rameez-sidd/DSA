// Floor of a number = Greatest number in an array which is less than or equal to target number
// E.g. arr = [2, 3, 5, 9, 14, 16, 18], target = 8
// output = 5
public class FloorOfANumber {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int target = 1;
        int ans = findFloor(arr, target);
        System.out.println(ans);
    }
    static int findFloor(int[] arr, int target){
        // What if the target is smaller than the smallest number in the array
        if(target < arr[0]){
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
        // start <= end ===> When the while loop breaks (start > end) ====> start = end + 1
        // when target is not found ===> previous small number is at end
        return arr[end];
    }
}
