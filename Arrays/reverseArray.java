import java.util.Arrays;

public class reverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        System.out.println(Arrays.toString(arr));
        reverse(arr);
        System.out.println(Arrays.toString(arr));

    }
    static void swap(int[] arr, int i1, int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
    static void reverse(int[] arr){           // Uses swap method
        // for(int i=0; i<arr.length/2; i++){
        //     swap(arr, i, arr.length-1-i);
        // }
        int s = 0;
        int e = arr.length-1;
        while(s<e){
            swap(arr, s, e);
            s++;
            e--;
        }
    }
}
