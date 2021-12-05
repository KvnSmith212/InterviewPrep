package leetcode.array;

import java.util.stream.IntStream;

/**
 * One pass over the prices array, O(n).
 *
 * Keep the minimu price seen so far.
 * Keep the maximum profit seen so far.
 * For each index i in the prices array...
 *      If the price[i] < the minPrice, update minPrice.
 *      If the price[i] - minPrice > maxProfit, update maxProfit.
 */
public class BuySellStockOptimized implements BuySellStock {
    @Override
    public int buySellStock(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        var wrapper = new Object(){
            int maxProfit = 0;
            int minPrice = prices[0];
        };

        IntStream.of(prices).forEachOrdered(price -> {
            if(price < (wrapper).minPrice) {
                wrapper.minPrice = price;
            } else if (price - wrapper.minPrice > wrapper.maxProfit) {
                wrapper.maxProfit = price - wrapper.minPrice;
            }
        });

        return wrapper.maxProfit;
    }
}
