public class Concept {
    public static void main(String[] args) {
        fun(5);
        System.out.println();
      
    }

    static void fun(int n){
        if(n == 0){
            return;
        }

        System.out.print(n + " ");

        // (n--) vs (--n)

        // Goes into infinite loop
        //fun(n--);  


        // Does the work
        fun(--n);
    }
}
