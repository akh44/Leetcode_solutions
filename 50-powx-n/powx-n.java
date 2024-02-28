class Solution {
    public double myPow(double x, int n) {
        
        double ans=(n >= 0? pypow(x,n):pypow(1/x,n));
        return ans;
    }

    public double pypow(double y, int k)
    {
        if(k==0)
        {
            return 1;
        }
        double p=pypow(y,k/2);
        if(k%2==0)
        {
            return p*p;
        }
        else
        {
        return p*p*y;
        }
    }
}