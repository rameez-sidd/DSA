// Given an array of numbers in which every number appears twice, only one number appears once. Find that number.

public class FindUnique {
    public static void main(String[] args) {
        int[] a = {2, 3, 4, 1, 2, 1, 3, 10, 4};
        System.out.println("Unique number is: " + findUnique(a));
    }   
 
    static int findUnique(int[] a){
        int result = 0;
        for(int i : a){
            result ^= i;
        }

        return result;
    }
}
