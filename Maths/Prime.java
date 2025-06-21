public class Prime{
    public static void main(String[] args) {
        int n = 17;
        System.out.println(isPrime(n));
    }

    // APPROACH-1
    // static boolean isPrime(int n){
    //     if(n<=1){
    //         return false;
    //     }
    //     for(int i=2; i<n; i++){
    //         if(n%i == 0){
    //             return false;
    //         }
    //     }

    //     return true;
    // }

    // APPROACH-2

    static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i == 0){
                return false;
            }
        }

        // OR
        // for(int i=2; i*i<=n; i++){
        //     if(n%i == 0){
        //         return false;
        //     }
        // }

        return true;
    }
}