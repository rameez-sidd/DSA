//  Find nth magic number.
//     let n = 6, binary representation of 6 is 110.
//     So, 6th magic number is : (1 * 5^3) + (1 * 5^2) + (0 * 5^1)

public class MagicNumber {
    public static void main(String[] args) {
        int n = 4;
        System.out.println("The magic number at position " + n + " is : " + magicNumber(n));
    }

    static int magicNumber(int n){
        int ans = 0;
        int base = 5;
        while(n>0){
            int last = n & 1;   // gives last bit from right
            ans += last * base;
            base = base * 5;
            n = n >> 1;  // right shift n by 1
        }

        return ans;
    }
}
