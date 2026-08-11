import java.util.*;

class Solution {
    public int missingInteger(int[] nums) {

        // 1. Find sum of longest sequential prefix
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        // 2. Store all numbers in HashSet
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        // 3. Find smallest missing number >= sum
        while (set.contains(sum)) {
            sum++;
        }

        return sum;
    }
}