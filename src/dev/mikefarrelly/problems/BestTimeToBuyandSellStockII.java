package dev.mikefarrelly.problems;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimeToBuyandSellStockII {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,1,5,5,6}));
        System.out.println(maxProfit(new int[]{7}));
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(maxProfit(new int[]{}));
        System.out.println(maxProfit(null));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int profit = 0;
        int low = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price > low) {
                profit += price - low;
            }
            low = price;
        }

        return profit;
    }
}
