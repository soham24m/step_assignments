/**
 * Category C - L2: Best Time to Buy and Sell Stock
 * Single-pass traversal tracking the running minimum price and the
 * best profit seen so far.
 */
public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int minPriceSoFar = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profitIfSoldToday = prices[i] - minPriceSoFar;
            if (profitIfSoldToday > maxProfit) {
                maxProfit = profitIfSoldToday;
            }
            if (prices[i] < minPriceSoFar) {
                minPriceSoFar = prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
