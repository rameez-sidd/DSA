public class DigitSum {
    public static void main(String[] args) {
        int n = 7929;

        System.out.println(digitSum(n));
    }

    static int digitSum(int n){
        if(n == 0){
            return 0;
        }

        return digitSum(n/10) + n%10;
    }
}
