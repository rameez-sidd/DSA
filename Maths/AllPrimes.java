// Given a number N, find all the numbers less than or equal to N, that are Prime.

public class AllPrimes {
    public static void main(String[] args) {
        int n = 40;

        // Initially all the indices will be false
        boolean[] primes = new boolean[n+1];

        sieve(n, primes);
    }

    // We have assumed if the index is false, means number is prime
    static void sieve(int n, boolean[] primes){
        for(int i=2; i*i <= n; i++){
            if(!primes[i]){
                for(int j=i*2; j<=n; j+=i){
                    primes[j] = true;
                }
            }
        }

        for(int i=2; i<=n; i++){
            if(!primes[i]){
                System.out.print(i + " ");
            }
        }
    }
}
