package ctci.chapter8.questions;

/**
 * 8.1 Triple Step: A child is running up a staircase with n steps and can hop either 1, 2, or 3 steps at a time.
 * Implement an algorithm to count how many possible ways the child can take the stairs.
 */
public class TripleStep {

    /**
     * Solution to triple step using recursion and memoization to optimize.
     * @param n
     * @return how many possible ways the child can take the stairs.
     */
    public static int tripleStepRecursive(int n) {
        return tripleStepRecursive(n, new int[n+1]);
    }

    private static int tripleStepRecursive(int n, int[] memo) {
        if (n < 0) {
            return 0;
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (memo[n] == 0) {
            memo[n] = tripleStepRecursive(n-1) + tripleStepRecursive(n-2) + tripleStepRecursive(n-3);
        }

        return memo[n];
    }

    /**
     * Solution to triple step done bottom up, iteratively.
     * @param n
     * @return how many possible ways the child can take the stairs.
     */
    public static int tripleStepIterative(int n) {
        if (n < 0) {
            return 0;
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        // initialize values, starting at n == 3
        int minus1 = 2;
        int minus2 = 1;
        int minus3 = 1;
        int solution = 0;

        // Build up until reaching, keeping track of past few values seen.
        for (int i = 3; i <= n; i++) {
            solution = minus1 + minus2 + minus3;
            minus3 = minus2;
            minus2 = minus1;
            minus1 = solution;
        }

        return solution;
    }

}
