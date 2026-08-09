class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        // suffix[i] = total stones from i to n-1
        int[] suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        // dp[i][M] = maximum stones current player can get
        // starting from index i with current M
        int[][] dp = new int[n][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int M = 1; M <= n; M++) {

                // If we can take all remaining piles
                if (i + 2 * M >= n) {
                    dp[i][M] = suffix[i];
                    continue;
                }

                int best = 0;

                // Try taking X piles, where 1 <= X <= 2M
                for (int X = 1; X <= 2 * M && i + X <= n; X++) {

                    // Stones we take now
                    int current = suffix[i] - suffix[i + X];

                    // Opponent gets the best possible result
                    // from the remaining piles
                    int opponent = dp[i + X][Math.max(M, X)];

                    // We want to maximize our stones
                    best = Math.max(best, current + suffix[i + X] - opponent);
                }

                dp[i][M] = best;
            }
        }

        return dp[0][1];
    }
}