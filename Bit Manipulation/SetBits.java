// Find the no. of set bits in a number

public class SetBits {
    public static void main(String[] args) {
        int n = 829910;
        System.out.println(Integer.toBinaryString(n));

        System.out.println("No. of Set bits: " + countSetBits(n));
    }

    static int countSetBits(int n){
        int count = 0;

        while(n > 0){
            n -= (n & -n);
            count++;
        }

        // Another way:

        // while (n > 0) {
        //     n = n & (n-1);
        //     count++;
        // }


        return count;
    }
}
