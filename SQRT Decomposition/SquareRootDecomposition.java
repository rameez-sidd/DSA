import java.util.Arrays;

public class SquareRootDecomposition {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 7, 6, 3, 1, 4, 8};
        int n = arr.length;


        // build the block array
        int sqrt = (int) Math.sqrt(n);

        int blockId = -1;

        int[] block = new int[sqrt + 1];

        for(int i=0; i<n; i++){

            // new block starting
            if(i % sqrt == 0){
                blockId++;
            }
            block[blockId] += arr[i];
        }
        System.out.println(Arrays.toString(block));

        System.out.println("SUM(2, 7): " + query(block, arr, 2, 7, sqrt));

    }

    public static int query(int[] block, int[] arr, int l, int r, int sqrt) {
        if(l < 0 || r >= arr.length || l > r) {
            throw new IllegalArgumentException("Invalid range");
        }
        int ans = 0;

        // left part
        while (l % sqrt !=0 && l < r && l != 0) {
            ans += arr[l];
            l++;
            
        }

        // middle part
        while (l + sqrt <= r) {
            ans += block[l / sqrt];
            l += sqrt;
        }

        // right part
        while (l <= r) {
            ans += arr[l];
            l++;
        }

        return ans;
    }

    public static void update(int[] block, int[] arr, int index, int value, int sqrt) {
        if(index < 0 || index >= arr.length) {
            throw new IllegalArgumentException("Invalid index");
        }
        
        // update the block
        block[index / sqrt] += (value - arr[index]);
        arr[index] = value;
    }
}
