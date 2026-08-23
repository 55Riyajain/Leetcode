class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int mid = n / 2;

        int leftSum = 0, rightSum = 0;
        int leftQ = 0, rightQ = 0;

        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);

            if (i < mid) {
                if (ch == '?') {
                    leftQ++;
                } else {
                    leftSum += ch - '0';
                }
            } else {
                if (ch == '?') {
                    rightQ++;
                } else {
                    rightSum += ch - '0';
                }
            }
        }

        // Alice gets the last unmatched move
        if ((leftQ + rightQ) % 2 == 1) {
            return true;
        }

        // If Bob can perfectly balance the sums, Alice loses
        return leftSum - rightSum != (rightQ - leftQ) / 2 * 9;
    }
}