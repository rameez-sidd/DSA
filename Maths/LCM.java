// Find LCM of two given numbers

public class LCM {
    public static void main(String[] args) {
        int a = 24;
        int b = 36;

        System.out.println(LCM(a,b));
    }

    static int LCM(int a, int b){
        return (a*b)/recursiveGCD(a, b);
    }

    static int recursiveGCD(int a, int b){
        if(a == 0){
            return b;
        }
        return recursiveGCD(b%a, a);
    }
}
