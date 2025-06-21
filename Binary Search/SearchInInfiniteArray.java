// Find the position of an element in a sorted array
// AMAZON INTERVIEW EXPERIENCE
public class SearchInInfiniteArray {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 12, 14, 18, 23, 28, 32, 39, 43, 49, 54, 65, 78, 90, 102, 139, 169, 180, 230, 300, 400, 500, 600, 650, 690, 708, 734, 812, 988, 999, 1003};
        int target = 65;
        int ans = findPosInfinite(arr, target);
        System.out.println(ans);
    }
    static int findPosInfinite(int[] arr, int target){
        // Take chunks of elements and move in chunks
        // The way we kept dividing the array into halves in BinarySearch and at last only one element remained
        // Here, we will move from bottom to up by taking a small chunk and doubling it until we are sure that 
        // the target element lies in between this chunk
        int start = 0;
        int end = 1;
        while(arr[end]<target){
            int prevStart = start;
            // new Start is one index right to previous End
            start = end+1;
            // doubling the size of Range : new End = prev End + 2*(size of previous Range)
            end = (end - prevStart + 1)*2  + end;
        } 
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
