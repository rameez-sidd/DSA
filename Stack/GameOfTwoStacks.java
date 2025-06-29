// Alexa has two stacks of non-negative integers, stack a[n] and stack b[n] where index  denotes the top of the stack. Alexa challenges Nick to play the following game:

// In each move, Nick can remove one integer from the top of either stack (a) or stack (b).
// Nick keeps a running sum of the integers he removes from the two stacks.
// Nick is disqualified from the game if, at any point, his running sum becomes greater than some integer (maxSum) given at the beginning of the game.
// Nick's final score is the total number of integers he has removed from the two stacks.
// Given (a), (b), and (maxSum) for (g) games, find the maximum possible score Nick can achieve.

// Example

// a = [1, 2, 3, 4, 5]
// b = [6, 7, 8, 9]

// The maximum number of values Nick can remove is 4. There are two sets of choices with this result.

// Remove 1,2,3,4 from (a) with a sum of 10.
// Remove 1,2,3 from (a) and 6 from (b) with a sum of 12.

import java.util.Arrays;

public class GameOfTwoStacks {
    public static void main(String[] args) {
        int[] a = {4, 2, 4, 6, 1};
        int[] b = {2, 1, 8, 5};
        int maxSum = 10;
        System.out.println(score(a, b, maxSum));
    }

    static int score(int[] a, int[] b, int maxSum){
        int sum = 0;
        int moves = 0;

        return helper(a, b, maxSum, sum, moves) - 1;
    }

    static int helper(int[] a, int[] b, int maxSum, int sum, int moves){
        if(sum > maxSum){
            return moves;
        } 

        if(a.length == 0 || b.length == 0){
            return moves;
        }

        int ans1 = helper(Arrays.copyOfRange(a, 1, a.length), b, maxSum, sum + a[0], moves+1);
        int ans2 = helper(a, Arrays.copyOfRange(b, 1, a.length), maxSum, sum + b[0], moves+1);

        return Math.max(ans1, ans2);

    }
}

