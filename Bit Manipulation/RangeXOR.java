// Find XOR of all numbers between a and b.

public class RangeXOR {
    public static void main(String[] args) {
        int a = 3;
        int b = 9;

        System.out.println("XOR from " + a + " till " + b + " is : " + rangeXOR(a, b));
        

    }

    static int rangeXOR(int a, int b){
        int ans = findXOR(b) ^ findXOR(a-1);

        return ans;
    }

    static int findXOR(int n){
        if(n % 4 == 0){
            return n;
        } else if(n % 4 == 1){
            return 1;
        } else if(n % 4 == 2){
            return n+1;
        } else{
            return 0;
        }
    }
}
