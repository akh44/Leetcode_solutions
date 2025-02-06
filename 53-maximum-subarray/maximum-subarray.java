class Solution {
    public int maxSubArray(int[] nums) {
        
       int curr=0;
       int sum=Integer.MIN_VALUE;
       for(int num:nums)
       {
         curr=Math.max(num,curr+num);
         sum=Math.max(curr,sum);
       }
       return sum;

    }

}