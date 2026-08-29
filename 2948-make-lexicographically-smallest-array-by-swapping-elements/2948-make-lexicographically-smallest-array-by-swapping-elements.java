import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        int[][] pairs = new int[n][2];

        // Store value and its original index
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        // Sort according to values
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = nums.clone();

        int start = 0;

        while (start < n) {
            int end = start;

            // Find all values that belong to the same connected group
            while (end + 1 < n &&
                    (long) pairs[end + 1][0] - pairs[end][0] <= limit) {
                end++;
            }

            // Get all original indices of this group
            List<Integer> indices = new ArrayList<>();

            for (int i = start; i <= end; i++) {
                indices.add(pairs[i][1]);
            }

            // Sort indices so smaller values go to earlier positions
            Collections.sort(indices);

            // Values are already sorted because pairs is sorted
            for (int i = 0; i < indices.size(); i++) {
                result[indices.get(i)] = pairs[start + i][0];
            }

            start = end + 1;
        }

        return result;
    }
}