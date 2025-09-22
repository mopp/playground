void main() {
    // int[] prices = {7,1,5,3,6,4};
    // int[] prices = {7,1,5,3,1000,4};
    // int[] prices = {1,2,3,4,5};
    // int[] prices = {1,2,3,4,1000};
    // int[] prices = {1};
    // int[] prices = {6,1,3,2,4,7};
    int[] prices = {1,9,6,9,1,7,1,1,5,9,9,9};
    int ans = maxProfit(prices);
    System.out.printf("maxProfit = %d\n", ans);
}

int maxProfit(int[] prices) {
    int n = prices.length;
    int total = 0;

    for(int i = 1; i < n; i++){
        if(prices[i - 1] < prices[i]) {
            total += prices[i] - prices[i - 1];
        }
    }

    return total;
}

int maxProfit_first_accepted(int[] prices) {
    int profit = 0;
    int n = prices.length;

    int i = 0;
    while (i < n) {
        System.out.printf("day: %d, price: %d, profit: %d\n", i, prices[i], profit);

        // Find the day to sell.
        int sellDay = i;
        for (int j = i; j < n; j++) {
            // Sell on the last day when the prices never drops.
            if (j == n - 1) {
                if (prices[i] < prices[j]) {
                    sellDay = j;
                }
                break;
            }

            // Sell when the price drops.
            if (prices[j] > prices[j + 1]) {
                sellDay = j;
                break;
            }
        }

        profit += prices[sellDay] - prices[i];
        i = sellDay + 1;
    }

    return profit;
}
