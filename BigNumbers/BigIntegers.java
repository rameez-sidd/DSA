package BigNumbers;

import java.math.BigInteger;

public class BigIntegers {
    public static void main(String[] args) {
        BigInteger A = BigInteger.valueOf(3920302);   // it can take values only in the range of integer
        BigInteger B = new BigInteger("293489238492849140928459728720991"); // it can take larger values

        System.out.println(A);
        System.out.println(B);

        // constants
        BigInteger constZero = BigInteger.ZERO;
        BigInteger constOne = BigInteger.ONE;
        BigInteger constTwo = BigInteger.TWO;
        BigInteger constTen = BigInteger.TEN;

        System.out.println(constZero);
        System.out.println(constOne);
        System.out.println(constTwo);
        System.out.println(constTen);

        //arithmetics
        System.out.println(A.add(B));
        System.out.println(A.multiply(B));
        System.out.println(A.subtract(B));
        System.out.println(B.divide(A));

        // comparison
        if(A.compareTo(B) > 0){
            System.out.println("A is bigger than B");
        } else {
            System.out.println("B is bigger than A");

        }

        // conversion
        BigInteger num = BigInteger.valueOf(123949);    // this is converting int value to BigInteger
        int n = num.intValue();   // this is converting BigInteger to int value


    }
}
