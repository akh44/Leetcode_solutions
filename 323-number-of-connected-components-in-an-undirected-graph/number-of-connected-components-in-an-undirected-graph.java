class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited=new boolean[n];
        int components=0;

        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                components++;
                bfs(graph,visited,i);
            }
        }

        return components;
    }

    public void bfs(List<List<Integer>> graph,boolean[] visited,int start)
    {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        visited[start]=true;

        while(!queue.isEmpty())
        {
            int node=queue.poll();
            for(int neighbour: graph.get(node))
            {
                if(!visited[neighbour])
                {
                    visited[neighbour]=true;
                    queue.add(neighbour);
                }
            }
        }
    }
        
    }
