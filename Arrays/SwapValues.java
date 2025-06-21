import java.util.*;
public class SwapValues{
    public static void main(String[] args) {
        int[] arr = {1, 3, 23, 9, 18};
        System.out.println(Arrays.toString(arr));
        swap(arr, 0, 4);
        System.out.println(Arrays.toString(arr));
    }
    static void swap(int[] arr, int i1, int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}