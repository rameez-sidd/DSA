// Find XOR of all numbers from 0 to n

public class XORtillN {
    public static void main(String[] args) {
        int n = 2;

        System.out.println(findXOR(n));
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
