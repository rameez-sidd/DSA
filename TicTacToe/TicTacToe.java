package TicTacToe;

import java.util.Scanner;



public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;
        boolean playerWon = false;

        Scanner s = new Scanner(System.in);

        while (!gameOver && !playerWon) {
            displayBoard(board);
            System.out.print("Player " + player + " enter: ");
            int box = s.nextInt();

            int row = getMapping(box)[0];
            int col = getMapping(box)[1];

            System.out.println();

            if (board[row][col] == ' ') {
                // place the elment
                board[row][col] = player;
                playerWon = hasWon(board, player);
                gameOver = gameIsOver(board);

                if (playerWon) {
                    displayBoard(board);
                    System.out.println("\nPlayer " + player + " has Won!\n");
                } else if (gameOver) {
                    displayBoard(board);
                    System.out.println("\nGame Over!\n");
                } else {
                    player = (player == 'X') ? 'O' : 'X';
                }

            } else {
                System.out.println("Invalid move. Try again!\n");
            }
        }
    }

    static boolean gameIsOver(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean hasWon(char[][] board, char player) {

        // check the rows
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        // check the cols
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // check the diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    static void displayBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            System.out.print("| ");
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
            if (row < board.length - 1) {

                System.out.println("-------------");
            }
        }
    }

    static int[] getMapping(int box){
        switch (box) {
            case 1:
                return new int[]{0,0};
            case 2:
                return new int[]{0,1};
            case 3:
                return new int[]{0,2};
            case 4:
                return new int[]{1,0};
            case 5:
                return new int[]{1,1};
            case 6:
                return new int[]{1,2};
            case 7:
                return new int[]{2,0};
            case 8:
                return new int[]{2,1};
            case 9:
                return new int[]{2,2};
        
            default:
                break;
        }

        return new int[]{-1, -1};
    }

}
