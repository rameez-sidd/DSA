// Finding square root of perfect squares.

public class PerfectSqrt {
    public static void main(String[] args) {
        int n = 40;
        System.out.println(sqrt(n));
    }

    static int sqrt(int n){
        int s = 0;
        int e = n;

        while (s <= e) {
            int m = s + (e-s)/2;
            if(m*m == n){
                return m;
            }
            else if(m*m > n){
                e = m-1;
            }
            else{
                s = m+1;
            }
        }

        return 0;
    }
}
