
public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        queens(board, 0);
    }

    static int queens(boolean[][] board, int row) {
        if (row == board.length) {
            display(board);
            System.out.println();
            return 1;
        }

        int count = 0;

        // placing the queen and checking for every row and column
        for(int col = 0; col < board.length; col++){
            // place the queen if it is safe
            if(isSafe(board, row, col)){
                board[row][col] = true;
                count += queens(board, row + 1);
                board[row][col] = false;

            }
        }

        return count;
    }

    static boolean isSafe(boolean[][] board, int row, int col){
        // check vertical row
        for(int i=0; i<row; i++){
            if(board[i][col]){
                return false;
            }
        }

        // left diagonal
        for(int i=1; i<=Math.min(row, col); i++){
            if(board[row-i][col-i]){
                return false;
            }
        }

        // right diagonal
        for(int i=1; i<=Math.min(row, board.length - col - 1); i++){
            if(board[row-i][col+i]){
                return false;
            }
        }

        return true;

    }

    static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print(" Q ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }
}
