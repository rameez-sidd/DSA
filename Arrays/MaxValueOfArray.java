import java.util.Arrays;

public class MaxValueOfArray {
    public static void main(String[] args) {
        int[] arr = {1, 39, 29, 12, 94, 343, 90, 10, 48};
        System.out.println(Arrays.toString(arr));
        System.out.println("Maximum value is : " + max(arr));
        System.out.println("Maximum value in range : " + maxInRange(arr, 6, 8));
    }
    static int max(int[] arr){
        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
    static int maxInRange(int[] arr, int s, int e){
        int max = arr[s];
        for(int i=s+1; i<=e; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
}
