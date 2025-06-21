// Given a pascal triangle, find the sum of nth row.

public class PascalTriangle {

    // We know that,
    // nC0 + nC1 + nC2 + nC3 + ...... + nCn = 2^(n-1)
    // value of n starts with 0. Thus, for nth row, the sum is : 2^(n-1)
    // We know, a << b = a * 2^b
    // Therefore, 1 << (n-1) = 1 * 2^(n-1)

     public static void main(String[] args) {
        int n = 3;
        int ans = 1 << (n-1);

        System.out.println("Sum of " + n + "th row is: " + ans);
     }
}