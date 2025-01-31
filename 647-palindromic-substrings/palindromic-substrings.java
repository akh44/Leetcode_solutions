class Solution {
    public int countSubstrings(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            ans+=expandaroundcenter(s,i,i);
            ans+=expandaroundcenter(s,i,i+1);
        }
        return ans;
    }

    public int expandaroundcenter(String s,int left,int right)
    {
        int count=0;
        int n=s.length();
        while(left>=0&&right<n&&s.charAt(left)==s.charAt(right))
        {
            count++;
            left--;
            right++;
        }
        return count;
    }
}