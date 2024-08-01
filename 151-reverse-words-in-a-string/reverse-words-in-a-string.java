class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String[] str=s.split("\\s+");
        int left=0;
        int right=str.length-1;
        while(left<right)
        {
            String temp=str[left];
            str[left]=str[right];
            str[right]=temp;
            left++;
            right--;
        }

        return String.join(" ",str);
    }
}