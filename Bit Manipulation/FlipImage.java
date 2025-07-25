// Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.
// To flip an image horizontally means that each row of the image is reversed.
// For example, flipping [1,1,0] horizontally results in [0,1,1].
// To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
// For example, inverting [0,1,1] results in [1,0,0].

import java.util.Arrays;

public class FlipImage {
    public static void main(String[] args) {
        int[][] image = {{1,1,0,0},
                         {1,0,0,1},
                         {0,1,1,1},
                         {1,0,1,0}};

        for(int[] row: image){
            System.out.println(Arrays.toString(row));
        }

        int[][] flippedImage = flipAndInvertImage(image);


        System.out.println("\nAfter flipping");
        for(int[] row: flippedImage){
            System.out.println(Arrays.toString(row));
        }


    }

    public static int[][] flipAndInvertImage(int[][] image) {
        int n = image[0].length;
        for(int[] row: image){
            // reverse the row
            for(int i=0; i<(n+1)/2; i++){
                int temp = row[i] ^ 1;
                row[i] = row[n-i-1] ^ 1;
                row[n-i-1] = temp;
            }
        }

        return image;
        
    }
}
