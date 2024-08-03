class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
       int jumps=0;
       int currend=0;
       int farthest=0;
       for(int i=0;i<n-1;i++)
       {
          farthest=Math.max(farthest,i+nums[i]);
          if(i==currend)
          {
            jumps++;
            currend=farthest;
          }
        
       }
       return jumps;

    }
}