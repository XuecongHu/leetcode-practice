package greedy;

/**
 * Created by 胡学聪 on 2017/2/20.
 */
public class _122BestTimeToBuyAndSellStockII {

    /**
     * 贪心算法
     * 题意表明不能同时进行多个交易，所以股票必须卖掉才能买入，不断地买入卖出，使得利润最大。
     * 以{7,1,5,3,6,4}为例，假设从较低价格的股价（1）出发，当发现股价（3）开始下降时，
     * 马上抛售下降前的最高值（贪心），而不是等待有可能出现的更高值（6）。
     * 这是因为即使在局部高峰后面出现了更高股价，假设是x1,x2,...,xi,xi+1,...,xn(xi+1 < xi), 由于允许多次交易，
     * xn - x1 < xi - x1 + xn - xi+1。所以，当出现下降股价时，必然要抛售股票。
     * 所以最终来看，该序列的最高利润组成就是把序列中的所有连续上升的区间找出。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;

        int maximumProfit = 0;
        int priceIndex = 0;
        while(priceIndex < prices.length){
            int greaterIndex = priceIndex;
            while(greaterIndex < prices.length - 1 && prices[greaterIndex+1] >= prices[greaterIndex])
                greaterIndex++;

            if(greaterIndex != priceIndex)
                maximumProfit += prices[greaterIndex] - prices[priceIndex];
            priceIndex = greaterIndex + 1;
        }
        return maximumProfit;
    }

    public int maxProfitOfficialAnswer(int[] prices){
        int maxProfit = 0;
        for(int i=0; i<prices.length-1; i++){
            if(prices[i] < prices[i+1])
                maxProfit += prices[i+1] - prices[i];
        }
        return maxProfit;
    }
}
