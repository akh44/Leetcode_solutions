class Solution {
    public int[][] kClosest(int[][] points, int k) {

      ArrayList<axis> list=new ArrayList<>();
      for(int i=0;i<points.length;i++)
      {
         axis obj = new axis(points[i][0],points[i][1]);
         list.add(obj);
      }
      Comparator<axis> cmp= new Comparator<axis>()
      {
            public int compare(axis a1, axis a2)
            {
                int d1= (a1.x * a1.x) + (a1.y * a1.y);
                int d2= (a2.x * a2.x) + (a2.y * a2.y);
                if(d1>d2)
                
                    return 1;
                
                else
                
                    return -1;
                
            }
      };

      Collections.sort(list,cmp);
     
      int ans[][]=new int[k][2];
      for(int i=0;i<k;i++)
      {
        ans[i][0]=list.get(i).x;
        ans[i][1]=list.get(i).y;
      }

      return ans;
    }
}
      
      class axis
      {
        int x;
        int y;
           public axis(int x,int y)
           {
            this.x=x;
            this.y=y;
           }
      }

