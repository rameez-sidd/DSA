// Find number of digits in a number in some Base-b.

public class NumOfDigits {
    public static void main(String[] args) {
        int n = 34567;
        int base = 2;

        int digits = (int)(Math.log(Math.abs(n))/Math.log(base)) + 1;

        System.out.println("Number of digits in " + n + " in Base-" + base + " is: " + digits);
    }
}
