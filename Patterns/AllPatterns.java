public class AllPatterns {

    public static void main(String[] args) {
        // pattern1(5);
        // pattern2(5);
        // pattern3(5);
        // pattern4(5);
        // pattern5(5);
        // pattern6(5);
        // pattern7(5);
        // pattern8(5);
        // pattern9(5);
        // pattern10(5);
        // pattern11(5);
        // pattern12(5);
        // pattern13(20);
        // pattern14(5);
        // pattern15(5);
        // pattern16(10);
        // pattern17(4);
        // pattern17Copy(4);
        // pattern18(6);
        // pattern19(6);
        // pattern20(10);
        // pattern21(5);
        // pattern22(10);
        pattern29(6);

    }

    static void pattern29(int n){
        for(int row = 1; row <= 2*n-1; row++){
            int stars = row <=n ? row : 2*n - row;
            int spaces = row <=n ? 2*(n-row) : 2*(row-n);

            for(int star = 1; star <= stars; star++){
                System.out.print("*");
            }

            for(int space = 1; space <= spaces; space++){
                System.out.print(" ");
            }

            for(int star = 1; star <= stars; star++){
                System.out.print("*");
            }

            
            System.out.println();
        }
    }

    static void pattern22(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                if ((row + col) % 2 == 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");

                }

            }

            System.out.println();
        }

    }

    static void pattern21(int n) {
        int val = 1;
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(val + " ");
                val++;
            }

            System.out.println();
        }

    }

    static void pattern20(int n) {
        for (int row = 1; row <= n; row++) {
            String space = row == 1 || row == n ? "*" : " ";
            System.out.print("*");
            for (int s = 1; s <= n - 2; s++) {
                System.out.print(space);
            }
            System.out.print("*");

            System.out.println();
        }

    }

    static void pattern19(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            for (int s = 1; s <= 2 * n - 2 * row; s++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }

            System.out.println();
        }
        for (int row = 2; row <= n; row++) {
            for (int col = 1; col <= n - row + 1; col++) {
                System.out.print("*");
            }
            for (int s = 1; s <= 2 * row - 2; s++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= n - row + 1; col++) {
                System.out.print("*");
            }

            System.out.println();
        }

    }

    static void pattern18(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n - row + 1; col++) {
                System.out.print("*");
            }
            for (int s = 1; s <= 2 * row - 2; s++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= n - row + 1; col++) {
                System.out.print("*");
            }

            System.out.println();
        }

        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            for (int s = 1; s <= 2 * n - 2 * row; s++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    static void pattern17Copy(int n) {

        // upper part
        for (int i = 1; i <= n; i++) {

            // spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // first half (decreasing)
            for (int k = i; k >= 1; k--) {
                System.out.print(k);
            }

            // second half (increasing)
            for (int k = 2; k <= i; k++) {
                System.out.print(k);
            }
            System.out.println();
        }

        // lower part
        for (int i = n - 1; i >= 1; i--) {

            // spaces
            for (int j = i; j <= n - 1; j++) {
                System.out.print(" ");
            }

            // first half (decreasing)
            for (int k = i; k >= 1; k--) {
                System.out.print(k);
            }

            // second half (increasing)
            for (int k = 2; k <= i; k++) {
                System.out.print(k);
            }
            System.out.println();
        }
    }

    static void pattern17(int n) {
        for (int row = 1; row <= 2 * n - 1; row++) {
            int totalColsInRow = row <= n ? 2 * row - 1 : 2 * (2 * n - row) - 1;
            int spaces = row <= n ? n - row : row - n;
            int val = row <= n ? row : 2 * n - row;

            for (int s = 1; s <= spaces; s++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= totalColsInRow; col++) {
                System.out.print(val);
                val = row <= n ? (col < row ? val - 1 : val + 1) : (col < 2 * n - row ? val - 1 : val + 1);

            }

            System.out.println();
        }
    }

    static void pattern16(int n) {
        for (int row = 0; row < n; row++) {
            int spaces = 2 * n - 2 * row - 2;
            for (int s = 1; s <= spaces; s++) {
                System.out.print(" ");
            }
            for (int col = 0; col <= row; col++) {
                int value = factorial(row) / (factorial(col) * factorial(row - col));
                System.out.print(value + "   ");
            }

            System.out.println();
        }
    }

    static void pattern15(int n) {
        for (int row = 1; row <= 2 * n - 1; row++) {
            int stars = row <= n ? 2 * row - 1 : 2 * (2 * n - row) - 1;
            int spaces = row <= n ? n - row : row - n;

            for (int s = 1; s <= spaces; s++) {
                System.out.print(" ");
            }
            for (int st = 1; st <= stars; st++) {
                String el = st == 1 || st == stars ? "*" : " ";
                System.out.print(el);
            }

            System.out.println();
        }
    }

    static void pattern14(int n) {
        for (int row = 1; row <= n; row++) {
            int spaces = row - 1;
            int stars = 2 * (n - row) + 1;
            for (int s = 1; s <= spaces; s++) {
                System.out.print(" ");
            }
            for (int st = 1; st <= stars; st++) {
                String el = row == 1 || st == 1 || st == stars ? "*" : " ";
                System.out.print(el);
            }

            System.out.println();
        }
    }

    static void pattern13(int n) {
        for (int row = 1; row <= n; row++) {
            int spaces = n - row;
            int stars = 2 * row - 1;
            for (int s = 1; s <= spaces; s++) {
                System.out.print(" ");
            }
            for (int st = 1; st <= stars; st++) {
                String el = st == 1 || st == stars || row == n ? "*" : " ";
                System.out.print(el);
            }

            System.out.println();
        }
    }

    static void pattern12(int n) {
        for (int row = 1; row <= 2 * n; row++) {
            int stars = row <= n ? n - row + 1 : row - n;
            int spaces = n - stars;
            for (int s = 1; s <= spaces; s++) {
                System.out.print(" ");
            }
            for (int st = 1; st <= stars; st++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    static void pattern11(int n) {
        for (int row = 1; row <= n; row++) {
            int stars = n - row + 1;
            int spaces = n - stars;
            for (int s = 1; s <= spaces; s++) {
                System.out.print(" ");
            }
            for (int st = 1; st <= stars; st++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    static void pattern10(int n) {
        for (int row = 1; row <= n; row++) {
            for (int space = 1; space <= n - row; space++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= row; star++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    static void pattern9(int n) {
        for (int row = 1; row <= n; row++) {
            for (int space = 1; space <= row - 1; space++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= 2 * (n - row) + 1; star++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    static void pattern8(int n) {
        for (int row = 1; row <= n; row++) {
            for (int space = 1; space <= n - row; space++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= 2 * row - 1; star++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    static void pattern7(int n) {
        for (int row = 1; row <= n; row++) {
            for (int spaces = 1; spaces <= row - 1; spaces++) {
                System.out.print(" ");
            }
            for (int stars = 1; stars <= n - row + 1; stars++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    static void pattern6(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n - row; col++) {
                System.out.print(" ");
            }
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    static void pattern5(int n) {
        for (int row = 1; row <= 2 * n - 1; row++) {
            int totalColsInRow = row > n ? 2 * n - row : row;
            for (int col = 1; col <= totalColsInRow; col++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    static void pattern4(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    static void pattern3(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= (n + 1) - row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern2(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern1(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}