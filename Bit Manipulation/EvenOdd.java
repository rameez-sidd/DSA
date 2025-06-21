public class EvenOdd{
    public static void main(String[] args) {
        int n = 64;
        System.out.println(n + " is " + evenOrOdd(n));
    }

    static String evenOrOdd(int n){
        if((n & 1) == 1) {
            return "Odd";
        } else{
            return "Even";
        }
    }
}