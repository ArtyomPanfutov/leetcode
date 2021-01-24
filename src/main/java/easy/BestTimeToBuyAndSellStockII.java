package easy;

/**
 * 122. Best Time to Buy and Sell Stock II
 *
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int valley = prices[0];
        int peak = prices[0];
        int maxProfit = 0;
        int size = prices.length - 1;

        int i = 0;
        while (i < size) {
            while (i < size && prices[i] >= prices[i + 1]) i++;

            valley = prices[i];

            while (i < size && prices[i] <= prices[i + 1]) i++;

            peak = prices[i];
            maxProfit += peak - valley;
        }

        return maxProfit;
    }
}
