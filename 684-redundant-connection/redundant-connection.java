class Solution {
    public int[] findRedundantConnection(int[][] edges) {
         int n=edges.length;

         int[] parent=new int[n+1];
         for(int i=1;i<=n;i++)
         {
             parent[i]=i;
         }

         for(int[] edge:edges)
         {
            int node1=edge[0];
            int node2=edge[1];

            if(find(parent,node1)==find(parent,node2))
            {
                return edge;
            }

            union(parent,node1,node2);
         }

         return new int[0];
    }

    public void union(int[] parent,int node1,int node2)
    {
        int root1=find(parent,node1);
        int root2=find(parent,node2);
        if(root1!=root2)
        {
            parent[root1]=root2;
        }
    }

    public int find(int[] parent,int node)
    {
        if(parent[node]!=node)
        {
            parent[node]=find(parent,parent[node]);
        }
        return parent[node];
    }
}