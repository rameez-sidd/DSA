package BigNumbers;

import java.math.BigDecimal;

public class BigDecimals {
    public static void main(String[] args) {
        double a = 0.03;
        double b = 0.04;
        double c = b-a;
        System.out.println(c);  // gives some error

        BigDecimal A = new BigDecimal("0.03");
        BigDecimal B = new BigDecimal("0.04");
        BigDecimal C = B.subtract(A);
        System.out.println(C);


        BigDecimal R = new BigDecimal("389849.67100340");
        BigDecimal S = new BigDecimal("490103.658253");

        // operations
        System.out.println(R.add(S));
        System.out.println(R.subtract(S));
        System.out.println(R.multiply(S));
        // System.out.println(R.divide(S));
        System.out.println(R.pow(2));
        System.out.println(S.negate());

    }
}
