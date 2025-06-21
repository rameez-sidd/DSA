// Find all the factors of a given number.

import java.util.ArrayList;

public class Factors {
    public static void main(String[] args) {
        int n = 20;
        factors2(n);
    }

    // Brute Force
    // static void factors(int n){
    //     for(int i=1; i<=n; i++){
    //         if(n%i == 0){
    //             System.out.print(i + " ");
    //         }
    //     }
    // }

    // Optimized [ O(sqrt(N)) ]
    static void factors(int n){
        for(int i=1; i*i<=n; i++){
            if(n%i == 0){
                if(n/i == i){
                    System.out.print(i + " ");
                } else{
                    System.out.print(i + " " + (n/i) + " ");

                }
            }
        }
    }

    // Optimized both time & space complexity will be  [ O(sqrt(N)) ] 
    // For printing the factors in sequence
    static void factors2(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i*i<=n; i++){
            if(n%i == 0){
                if(n/i == i){
                    System.out.print(i + " ");
                } else{
                    System.out.print(i + " ");
                    list.add(n/i);

                }
            }
        }

        for(int i=list.size()-1; i>=0; i--){
            System.out.print(list.get(i) + " ");
        }
    }
}
