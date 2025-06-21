public class SearchInRange {
    public static void main(String[] args) {
        int[] arr = {1, 4, 98, 21, 45, 87, 32, 12, 90, 72};
        int ans = searchRange(arr, 4, 2, 7);
        System.out.println(ans);
    }
    static int searchRange(int[] arr, int target, int start, int end){
        if(arr.length==0){
            return -1;
        }
        for(int i=start; i<=end; i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
}
