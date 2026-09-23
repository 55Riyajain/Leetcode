class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        long total = 0;
        for (int num : nums) {
            total += num;
        }

        long target = total - x;

        // If we need to keep nothing
        if (target == 0) {
            return n;
        }

        // If target is negative, impossible
        if (target < 0) {
            return -1;
        }

        int left = 0;
        long sum = 0;
        int maxLength = -1;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            // Shrink window if sum becomes too large
            while (left <= right && sum > target) {
                sum -= nums[left];
                left++;
            }

            // Found a subarray with required sum
            if (sum == target) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        // No valid subarray found
        if (maxLength == -1) {
            return -1;
        }

        return n - maxLength;
    }
}