package greedy;

/**
 * Created by 胡学聪 on 2017/2/20.
 */
public class _122BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;

        int maximumProfit = 0;
        int pi = 1, minPi = 0;
        while(pi < prices.length){
            if(prices[pi] < prices[pi-1]){
                maximumProfit += prices[pi-1] - prices[minPi];
                minPi = pi;
            }else{
                if(pi == prices.length - 1)
                    maximumProfit += prices[pi] - prices[minPi];
            }
            pi++;
        }
        return maximumProfit;
    }
}
