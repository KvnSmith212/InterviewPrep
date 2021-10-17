package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Hashset solution O(n)
 *
 * Keep a hashmap where ( key -> target - nums[i], value -> i )
 * For every index i...
 *      Calculate required difference to reach target.
 *      Does the required difference exist as a key in the hashset?
 *          yes -> pull the index from the hashset, return the two values.
 *          no -> put nums[i] into the hashset as key with the index as the value.
 */
public class TwoSumOptimized implements TwoSum {
    @Override
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> requiredForTarget = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int required = target - nums[i];
            if (requiredForTarget.containsKey(required)) {
                return new int[]{requiredForTarget.get(required), i};
            } else {
                requiredForTarget.put(nums[i], i);
            }
        }

        return new int[]{};
    }
}
