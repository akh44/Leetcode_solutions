class Solution {
    public boolean makePalindrome(String s) {
        int count=0;
        int i=0;
        int j=s.length()-1;
        while(i<j)
        {
          if(s.charAt(i)==s.charAt(j))
          {
            i++;
            j--;
          }
          else
          {
            count++;
            if(count>2)
            {
                return false;
            }
            i++;
          j--;
          }
          

        }
      return true;
    }
}