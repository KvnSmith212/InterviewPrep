package leetcode.array;

/**
 * Brute force O(n^2)
 *
 * Keep two indeces, i and j
 *      For every i, and for every j...
 *          Check that i does not equal j.
 *          return [i,j] when i + j equals target.
 */
public class TwoSumSolution implements TwoSum {
    @Override
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(i != j && nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }
}
