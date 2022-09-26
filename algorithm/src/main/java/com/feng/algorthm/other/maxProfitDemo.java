package com.feng.algorthm.other;

/**
 * @author
 * @time 2022/9/26 22:25
 * @Description- TODO
 */
public class maxProfitDemo {
    public int maxProfit(int[] prices) {
        int maxPrices = 0;
        int minPrices = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price<minPrices){
                minPrices = price;
            }
            if (maxPrices<price-minPrices){
                maxPrices = price - minPrices;
            }
        }

        return maxPrices;
    }
}
