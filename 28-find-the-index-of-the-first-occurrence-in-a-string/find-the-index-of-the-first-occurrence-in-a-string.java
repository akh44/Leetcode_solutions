class Solution {
    public int strStr(String haystack, String needle) {

          if (needle.isEmpty()) {
            return 0;
        } 
        int n = haystack.length();
        int m = needle.length();
        
        for (int ws=0;ws<=n-m;ws++) 
        {
          for(int i=0;i<m;i++)
          {
            if(needle.charAt(i)!=haystack.charAt(ws+i))
            {
                break;
            }
            if(i==m-1)
            {
                return ws;
            }
          }
        }
           
        return -1;

    }
}