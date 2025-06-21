// Find the HCF of given two numbers.

public class GCD {
    public static void main(String[] args) {
        int a = 36;
        int b = 24;

        System.out.println(recursiveGCD(a,b));
    }

    static int GCD(int a, int b){
        int x = a;
        int y = b;

        while(x > 0){
            int rem = y%x;  
            y = x;    
            x = rem;    
        }

        return y;
    }

    static int recursiveGCD(int a, int b){
        if(a == 0){
            return b;
        }
        return recursiveGCD(b%a, a);
    }

}
