// theres a 3 x 3 matrix and a person is at point (0,0) and he needs to reach at point (2,2). He can, for now, only move in directions RIGHT and DOWN. How many ways are there to do so, return the count.

import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
    public static void main(String[] args) {
        System.out.println(count(3, 3));

        paths("", 3, 3);

        ArrayList<String> ans = pathsList("", 3, 3);
        System.out.println(ans);

        ArrayList<String> ans2 = pathsListDiagonal("", 3, 3);
        System.out.println(ans2);

        boolean[][] maze = {
            {true, true, true},
            {true, false, true},
            {true, true, true}

        };

        pathWithObstacles("", maze, 0, 0);


        boolean[][] maze2 = {
            {true, true, true},
            {true, true, true},
            {true, true, true}

        };

        pathBacktracking("", maze2, 0, 0);
        
        int[][] path = new int[maze2.length][maze2[0].length];

        pathBacktrackingPrint("", maze2, 0, 0, path, 1);
    }

    static int count(int r, int c){
        if(r == 1 || c == 1){
            return 1;
        }

        int left = count(r-1, c);
        int right = count(r, c-1);

        return left + right;
    }

    static void paths(String p, int r, int c){
        if(r == 1 && c == 1){
            System.out.println(p);
            return;
        }

        if(r > 1){
            paths(p + "D", r-1, c);
        }
        if(c > 1){
            paths(p + "R", r, c-1);

        }

        
    }

    static ArrayList<String> pathsList(String p, int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        
        ArrayList<String> ans = new ArrayList<>();

        if(r > 1){
            ans.addAll(pathsList(p + "D", r-1, c));
        }
        if(c > 1){
            ans.addAll(pathsList(p + "R", r, c-1));

        }

        return ans;

        
    }


    // If we can also go Diagonal
    static ArrayList<String> pathsListDiagonal(String p, int r, int c){
        if(r == 1 && c == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        
        ArrayList<String> ans = new ArrayList<>();
        
        if(r > 1 && c > 1){
            ans.addAll(pathsListDiagonal(p + "d", r-1, c-1));

        }
        if(r > 1){
            ans.addAll(pathsListDiagonal(p + "D", r-1, c));
        }
        if(c > 1){
            ans.addAll(pathsListDiagonal(p + "R", r, c-1));

        }

        return ans;

        
    }

    // Till this point we were considering that the matrix is numbered like this:
    //   3  2   1
    //   2
    //   1


    // But now we will see normal ordering and also Maze with obstacles. A boolean matrix where false means obstacle
    static void pathWithObstacles(String p, boolean[][] maze, int r, int c){

        if(r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }

        if(!maze[r][c]){
            return;
        }

        if(r < maze.length - 1){
            pathWithObstacles(p + "D", maze, r+1, c);
        }
        if(c < maze[0].length - 1){
            pathWithObstacles(p + "R", maze, r, c+1);

        }

        
    }


    // Now, were allowed to go in every direction and well see Backtracking here.


    static void pathBacktracking(String p, boolean[][] maze, int r, int c){

        if(r == maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }

        if(!maze[r][c]){
            return;
        }

        // I am considering this cell in my path, so marking it as false
        maze[r][c] = false;

        if(r < maze.length - 1){
            pathBacktracking(p + "D", maze, r+1, c);
        }
        if(c < maze[0].length - 1){
            pathBacktracking(p + "R", maze, r, c+1);

        }
        if(r > 0){
            pathBacktracking(p + "U", maze, r-1, c);
        }
        if(c > 0){
            pathBacktracking(p + "L", maze, r, c-1);
        }


        // here, the function will be over.
        // so before the function gets removed, also remove the changes that were made by the function
        maze[r][c] = true;

        
    }


    static void pathBacktrackingPrint(String p, boolean[][] maze, int r, int c, int[][] path, int step){

        if(r == maze.length-1 && c == maze[0].length-1){
            path[r][c] = step;
            for(int[] arr: path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if(!maze[r][c]){
            return;
        }

        // I am considering this cell in my path, so marking it as false
        maze[r][c] = false;
        path[r][c] = step;

        if(r < maze.length - 1){
            pathBacktrackingPrint(p + "D", maze, r+1, c, path, step+1);
        }
        if(c < maze[0].length - 1){
            pathBacktrackingPrint(p + "R", maze, r, c+1, path, step+1);

        }
        if(r > 0){
            pathBacktrackingPrint(p + "U", maze, r-1, c, path, step+1);
        }
        if(c > 0){
            pathBacktrackingPrint(p + "L", maze, r, c-1, path, step+1);
        }


        // here, the function will be over.
        // so before the function gets removed, also remove the changes that were made by the function
        maze[r][c] = true;
        path[r][c] = 0;

        
    }
}
