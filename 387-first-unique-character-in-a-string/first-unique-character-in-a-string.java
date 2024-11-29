class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> m=new HashMap<>();
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            m.put(c,m.getOrDefault(c,0)+1);
        }
         
        for(int i=0;i<n;i++)
        {

            if(m.get(s.charAt(i))==1)
            return i;
        }

        return -1;
    }
}