class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max_so_far=0;
        int max=0;
        int min=0;
        int min_so_far=0;
        for(int num:nums)
        {
            max_so_far=Math.max(0,max_so_far+num);
            max=Math.max(max,max_so_far);

            min_so_far=Math.min(0,min_so_far+num);
            min=Math.min(min,min_so_far);
        }
        return Math.max(max,Math.abs(min));
    }
}