class Solution {
    public int longestConsecutive(int[] nums) {
      
        Set<Integer> set=new HashSet<Integer>();
        for(int num:nums)
        {
            set.add(num);
        }
        int longestStreak=0;

        for(int num:nums)
        {
            if(!set.contains(num-1))
            {
                int currnum=num;
                int currstreak=1;
                while(set.contains(currnum+1))
                {
                    currnum +=1;
                    currstreak+=1;
                }
                longestStreak=Math.max(longestStreak,currstreak);
            }
        }
        return longestStreak;
    }
}