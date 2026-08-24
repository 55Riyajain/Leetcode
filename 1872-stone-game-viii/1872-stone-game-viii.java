class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

        // Calculate total sum
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int dp = sum;

        // Work backwards by removing stones from the sum
        for (int i = n - 1; i >= 2; i--) {
            sum -= stones[i];
            dp = Math.max(dp, sum - dp);
        }

        return dp;
    }
}