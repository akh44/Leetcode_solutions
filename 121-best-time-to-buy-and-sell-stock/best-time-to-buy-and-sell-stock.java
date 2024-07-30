class Solution {
    public int maxProfit(int[] prices) {
        int l_diff=0;
        int smallest=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++)
        {
            if(prices[i]<smallest)
            {
                smallest=prices[i];
            }
            else
            {
                l_diff=Math.max(l_diff,prices[i]-smallest);
            }
        }
        
        return l_diff;
    }
}