public class DigitProd {
    public static void main(String[] args) {
        int n = 505;

        System.out.println(digitProd(n));
    }

    static int digitProd(int n){
        if(n == 0){
            return 1;
        }

        return (n%10) * digitProd(n/10);
    }
}
