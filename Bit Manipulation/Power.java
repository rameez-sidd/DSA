// Find a^b.

public class Power {
    
    public static void main(String[] args) {
        int base = 9;
        int power = 8;

        int ans = 1;
        while(power > 0){
            if((power & 1) == 1){
                ans *= base;
            }

            base *= base;
            power = power >> 1;
        }

        System.out.println(ans);
    }
}
