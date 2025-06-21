import java.util.Arrays;

// Unsorted
public class SearchInMatrix {
    public static void main(String[] args) {
        int[][] mat = { {18, 9, 12},
                        {36, -4, 91},
                        {44, 33, 16} };
        int target = 91;
        int[] ans = search(mat, target);
        System.out.println(Arrays.toString(ans));
    }
    static int[] search(int[][] array2D, int target){
        for(int i=0; i<array2D.length; i++){
            for(int j=0; j<array2D[i].length; j++){
                if(array2D[i][j] == target){
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }
}
