import java.util.Arrays;

// Sorted Row-Wise and Column-Wise
// i.e. Each row is sorted and each column is sorted
public class SearchInMatrixSorted1 {    
    public static void main(String[] args) {
        int[][] mat = { {10, 20, 30, 40, 52},
                        {15, 25, 35, 45, 58},
                        {28, 29, 37, 49, 62},
                        {33, 34, 38, 50, 71} };
        int target = 58;
        int[] ans = search(mat, target);
        System.out.println(Arrays.toString(ans));
    }
    static int[] search(int[][] array2D, int target){
        int r = 0;
        int c = array2D[0].length-1;
        while(r < array2D.length && c >= 0){
            if(array2D[r][c] == target){
                return new int[] {r,c};
            }
            else if(array2D[r][c] < target){
                r++;
            }
            else{
                c--;
            }
        }
        return new int[] {-1, -1};

    }
}
