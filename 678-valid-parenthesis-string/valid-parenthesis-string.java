class Solution {
    public boolean checkValidString(String s) {
            int open=0;
            int close=0;
            int length=s.length()-1;

            for(int i=0;i<=length;i++)
            {
                if(s.charAt(i)=='('||s.charAt(i)=='*')
                {
                    open++;
                }
                else
                {
                    open--;
                }

                if(s.charAt(length-i)==')'||s.charAt(length-i)=='*')
                {
                    close++;
                }
                else
                {
                    close--;
                }

                if(open<0||close<0)
                {
                    return false;
                }
            }
            return true;

        }

        
    }
