// *
// * *
// * * *
// * * * *

public class Pattern2 {
    public static void main(String[] args) {
        int n = 4;
        triangle(n, 0);
    }

    static void triangle(int r, int c){
        if(r==0){
            return;
        }
        if(c < r){
            triangle(r, c+1);
            System.out.print("* ");
        } else{
            triangle(r-1, 0);
            System.out.println();
        }
    }
}
