class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "";
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            int ones = 0;

            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    ones++;
                }

                if (ones == k) {
                    String curr = s.substring(i, j + 1);

                    if (curr.length() < minLen ||
                        (curr.length() == minLen && curr.compareTo(ans) < 0)) {
                        minLen = curr.length();
                        ans = curr;
                    }
                    break; // Further substrings starting at i will be longer
                }
            }
        }

        return ans;
    }
}