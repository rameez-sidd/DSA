public class FindMinInArray {
    public static void main(String[] args) {
        int[] arr = {11, 40, 98, 21, 30, 7, 32, 12, 90, 72};
        int minElement = min(arr);
        System.out.println(minElement);

    }
    static int max(int[] arr){
        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    static int min(int[] arr){
        int min = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
}
