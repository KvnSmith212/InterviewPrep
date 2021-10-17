package leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BuySellStockTest {

    List<BuySellStock> buySellStockImplementations = List.of(
            new BuySellStockSolution(),
            new BuySellStockOptimized()
    );

    /**
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
     */
    @Test
    void buySellStock_exampleOne() {
        int[] prices = {7,1,5,3,6,4};

        buySellStockImplementations.forEach(buySell -> {
            int result = buySell.buySellStock(prices);
            assertEquals(5, result);
        });
    }

    /**
     * Input: prices = [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transactions are done and the max profit = 0.
     */
    @Test
    void buySellStock_exampleTwo() {
        int[] prices = {7,6,4,3,1};

        buySellStockImplementations.forEach(buySell -> {
            int result = buySell.buySellStock(prices);
            assertEquals(0, result);
        });
    }

}