class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] cnt = new int[3];

        for (int stone : stones) {
            cnt[stone % 3]++;
        }

        int c0 = cnt[0];
        int c1 = cnt[1];
        int c2 = cnt[2];

        // Only one of remainder 1 or remainder 2 exists
        if (c1 == 0 || c2 == 0) {
            return Math.max(c1, c2) > 2 && c0 % 2 == 1;
        }

        // Both remainder 1 and 2 exist
        return Math.abs(c1 - c2) > 2 || c0 % 2 == 0;
    }
}