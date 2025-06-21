
public class PowerOf4 {
    public static void main(String[] args) {
        int n = -64;
        System.out.println(isPowerOfFour(n));
    }

    public static boolean isPowerOfFour(int n) {
        long num = Math.abs((long)n);
        System.out.println(num);
        if (num == 0) {
            return false;
        }
        // first checking it is a power of 2
        int digits = (int) (Math.log(num) / Math.log(2)) + 1;
        if ((num & (num - 1)) == 0) {
            if (digits % 2 == 1) {
                return true;
            }
        }

        return false;
    }

}
