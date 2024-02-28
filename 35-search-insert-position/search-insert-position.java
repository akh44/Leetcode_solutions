class Solution {
    public int searchInsert(int[] nums, int target) {
        int l=0,m;
        int size=nums.length;
        int h=(size-1);
        while(l<=h)
           {
               m=(l+h)/2;
               if(nums[m]==target)
               {
                   return m;
               }
               else if(nums[m]<target)
               {
                   l=m+1;
               }
               else if(nums[m]>target)
               {
                   h=m-1;
               }
           
           
    }
    return l;
}
 
}