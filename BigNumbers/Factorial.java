package BigNumbers;

import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        BigInteger ans = fact(40);
        System.out.println(ans);
    }

    static BigInteger fact(int num){
        BigInteger ans = new BigInteger("1");

        for(int i=2; i<=num; i++){
            ans = ans.multiply(BigInteger.valueOf(i));
        }

        return ans;
    }
}
