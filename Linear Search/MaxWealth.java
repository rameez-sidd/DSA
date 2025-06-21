
public class MaxWealth {
    public static void main(String[] args) {
        int[][] accounts = {
            {1, 2, 3},
            {4, 9, 2},
            {2, 2, 1}
        };
        int MaxWealth = maximumWealth(accounts);
        System.out.println("Maximum Wealth : " + MaxWealth);
    }   
    static int maximumWealth(int[][] accounts){
        int ans = Integer.MIN_VALUE;
        for(int person = 0; person<accounts.length; person++){
            int sum = 0;
            for(int acc = 0; acc<accounts[person].length; acc++){
                sum += accounts[person][acc];
            }
            if(sum > ans){
                ans = sum;
            }
        }
        return ans;
    }
}
