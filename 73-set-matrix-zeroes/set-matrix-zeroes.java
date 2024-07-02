class Solution {
    public void setZeroes(int[][] matrix) {
        int r=matrix.length;
        int c=matrix[0].length;
        boolean[] row=new boolean[r];
        boolean[] column=new boolean[c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(matrix[i][j]==0)
                {
                    row[i]=true;
                    column[j]=true;
                }
            }
        }

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(row[i]||column[j])
                {
                    matrix[i][j]=0;
                }
            }
        }
    }
}