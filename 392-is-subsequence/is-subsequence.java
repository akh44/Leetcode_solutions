class Solution {
    public boolean isSubsequence(String s, String t) {
        int j=0;
        int k=t.length();
        char[] c=s.toCharArray();
        char[] d=t.toCharArray();
        for(int i=0;i<k&&j<s.length();i++)
        {
              if(d[i]==c[j])
              {
                j++;
              }
        }
        if(j==s.length())
        {
            return true;
        }
        return false;
    }
}