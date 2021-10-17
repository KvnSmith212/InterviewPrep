package leetcode.array;

/**
 * Brute force, O(n^2)
 *
 * Double for loop through the prices, keeping index i,j where j is always > i.
 * Keep an int max profits.
 * For every i, loop through the j's checking profits.
 *      If profit > maxProfit, maxProfit = profit.
 *
 * Return maxProfit.
 */
public class BuySellStockSolution implements BuySellStock {
    @Override
    public int buySellStock(int[] prices) {
        int maxProfit = 0;

        if (prices.length < 2) {
            return 0;
        }

        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }
}
