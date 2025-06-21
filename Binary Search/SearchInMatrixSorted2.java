import java.util.Arrays;

// Strictly Sorted
// [1,  2,  3,  4]
// [5,  6,  7,  8]
// [9,  10, 11, 12]
// [13, 14, 15, 16]
public class SearchInMatrixSorted2 {
    public static void main(String[] args) {
        int[][] mat = { 
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16} 
        };
        System.out.println(Arrays.toString(search(mat, 13)));
    }
    static int[] search(int[][] array2D, int target){
        int rows = array2D.length; 
        int cols = array2D[0].length; 
        if(cols == 0){
            return new int[]{-1, -1};
        }
        if(rows == 1){
            binarySearch(array2D, target, 0, cols-1, 0);
        }

        int rStart = 0;
        int rEnd = rows-1; 
        int midCol = (cols-1)/2; 

        // run the loop till 2 rows are remaining
        while(rStart < (rEnd-1)){ // while this is true it will have more than 2 rows. when it becomes we will have only 2 rows
            int mid = rStart + (rEnd - rStart)/2; 
            if(array2D[mid][midCol] == target){
                return new int[]{mid, midCol};
            }
            if(target > array2D[mid][midCol]){
                // Ignore rows above mid-row
                rStart = mid;
            }
            else{
                // Ignore rows below mid-row
                rEnd = mid;
            }
        }

        // Now, we have 2 rows
        // Check whether the target is in the col of 2 rows
        if(array2D[rStart][midCol] == target){
            return new int[]{rStart, midCol};
        }
        if(array2D[rStart + 1][midCol] == target){
            return new int[]{rStart+1, midCol};
        }

        // search in 1st part
        if(target < array2D[rStart][midCol]){
            return binarySearch(array2D, target, 0, midCol-1, rStart);
        }
        // search in 2nd part
        if(target > array2D[rStart][midCol] && target <= array2D[rStart][cols-1]){
            return binarySearch(array2D, target, midCol+1, cols-1, rStart);
        }
        // search in 3rd part
        if(target < array2D[rStart+1][midCol]){
            return binarySearch(array2D, target, 0, midCol-1, rStart+1);
        }
        // search in 4th part
        if(target > array2D[rStart+1][midCol] && target <= array2D[rStart+1][cols-1]){
            binarySearch(array2D, target, midCol+1, cols-1, rStart+1);
        }
        return new int[] {-1, -1};
    }

    // Search in the row between the cols provided
    static int[] binarySearch(int[][] array2D, int target, int cStart, int cEnd, int row){
        while(cStart <= cEnd){
            int mid = cStart + (cEnd-cStart)/2;
            if(array2D[row][mid] == target){
                return new int[]{row, mid};
            }
            if (array2D[row][mid] < target) {
                cStart = mid + 1;
            } 
            else {
                cEnd = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}
