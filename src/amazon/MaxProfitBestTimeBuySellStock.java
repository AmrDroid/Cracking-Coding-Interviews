package amazon;

public class MaxProfitBestTimeBuySellStock {

//    Say you have an array for which the ith element is the price of a given stock on day i.
//
//    If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
//    design an algorithm to find the maximum profit.

    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices == null || prices.length == 0) return 0;
        int min = prices[0];
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < prices.length; i++){
            int money = prices[i] - min;
            if(money > max) max = money;
            if(prices[i] < min) min = prices[i];
        }

        return max;

    }

//    Best Time to Buy and Sell Stock II
//    Say you have an array for which the ith element is the price of a given stock on day i.
//    Design an algorithm to find the maximum profit. You may complete as many transactions as you like
//    (ie, buy one and sell one share of the stock multiple times). However, you may not engage
//    in multiple transactions at the same time (ie, you must sell the stock before you buy again).
    public int maxProfit2(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices == null || prices.length == 0) return 0;
        int hold = 0;
        boolean have = false;
        int earn = 0;
        for(int i = 0; i < prices.length - 1; i++){
            int money = prices[i + 1] - prices[i];
            if(money > 0){
                if(!have){
                    hold = prices[i];
                    have = true;
                }
            }
            else if(money < 0){
                if(have){
                    earn += prices[i] - hold;
                    have = false;
                }
            }
        }
        if(have) earn += prices[prices.length - 1] - hold;

        return earn;

    }

































    public static int maxProfit3(int[] prices)
    {
        int n = prices.length;
        int cost = 0;
        int maxCost = 0;

        if (n == 0) {
            return 0;
        }

        // store the first element of array in a variable

        int min_price = prices[0];

        for (int i = 0; i < n; i++) {

            // now compare first element with all the
            // element of array and find the minimum element

            min_price = Math.min(min_price, prices[i]);

            // since min_price is smallest element of the
            // array so subtract with every element of the
            // array and return the maxCost

            cost = prices[i] - min_price;

            maxCost = Math.max(maxCost, cost);
        }
        return maxCost;
    }

    // Driver Code
    public static void main(String[] args)
    {
        // stock prices on consecutive days
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit3(prices));
    }
}
