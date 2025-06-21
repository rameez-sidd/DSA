public class ReverseNum {
    static int rev = 0;

    public static void main(String[] args) {
        int n = 2893;
        int ans = reverse2(n);
        System.out.println(ans);
    }


    static void reverse1(int n){
        if(n == 0){
            return;
        }

        int rem = n%10;
        rev = rev*10 + rem;
        reverse1(n/10);
        
    }


    static int reverse2(int n){
        // sometimes you might need some additional variables in the argument.
        // In that case, make helper function

        int digits = (int)(Math.log10(n)) + 1;
        return helper(n, digits);
    }

    static int helper(int n, int digits){
        if(n%10 == n){
            return n;
        }

        int rem = n%10;

        return (rem * (int)Math.pow(10, digits-1)) + helper(n/10, digits-1); 
    }
}
