class Solution {
    public void reverseString(char[] s) {
        int i=0;
        int j=s.length-1;
        while(j>i)
        {
            char tmp=s[i];
            s[i++]=s[j];
            s[j--]=tmp;

        }
    }
}