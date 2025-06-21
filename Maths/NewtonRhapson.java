// Find the square root of a number using Newton Rhapson Method

// Newton Rhapson:
// root = (X + N/X)/2
// where X is the assumed root

public class NewtonRhapson {
    public static void main(String[] args) {
        int n = 40;

        System.out.println(sqrt(n));
    }

    static double sqrt(int n){
        double X = n;

        double root;
        while (true) {
            root = 0.5 * (X + (n/X));
            if(Math.abs(root - X) < 0.1){
                break;
            }

            X = root;
        }

       
        return root;
        
    }
}
