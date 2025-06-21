// Given a number, find out whether it is a power of 2 or not.

public class PowerOf2 {
    public static void main(String[] args) {
        int n = 1024;

        System.out.println(isPowerof2(n));
    }

    static boolean isPowerof2(int n){
        if(n==0){
            return false;
        }
        return (n & (n-1)) == 0;
    }
}
