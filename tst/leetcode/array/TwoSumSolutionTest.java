package leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumSolutionTest {

    List<TwoSum> twoSumImplementations = List.of(
            new TwoSumSolution(),
            new TwoSumOptimized()
    );

    /**
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     */
    @Test
    void twoSum_exampleOne() {
        int[] nums = {2,7,11,15};
        int target = 9;

        twoSumImplementations.forEach(twoSum -> {
            int[] result = twoSum.twoSum(nums, target);
            assertArrayEquals(new int[]{0,1}, result);
        });
    }

    /**
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     */
    @Test
    void twoSum_exampleTwo() {
        int[] nums = {3,2,4};
        int target = 6;

        twoSumImplementations.forEach(twoSum -> {
            int[] result = twoSum.twoSum(nums, target);
            assertArrayEquals(new int[]{1,2}, result);
        });
    }

    /**
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     */
    @Test
    void twoSum_exampleThree() {
        int[] nums = {3,3};
        int target = 6;

        twoSumImplementations.forEach(twoSum -> {
            int[] result = twoSum.twoSum(nums, target);
            assertArrayEquals(new int[]{0,1}, result);
        });
    }
}