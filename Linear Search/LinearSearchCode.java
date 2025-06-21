public class LinearSearchCode{
    public static void main(String[] args) {
        int[] arr = {1, 4, 98, 21, 45, 87, 32, 12, 90, 72};
        boolean ans = linearSearch2(arr, 32);
        System.out.println(ans);
    }

    // search and return true if element is found
    // if element is not found return false
    static boolean linearSearch2(int[] arr, int target){
        if(arr.length==0){
            return false;
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i]==target){
                return true;
            }
        }
        return false;
    }

    // search and return the index if element is found
    // if element is not found return -1
    static int linearSearch(int[] arr, int target){
        if(arr.length==0){
            return -1;
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
}