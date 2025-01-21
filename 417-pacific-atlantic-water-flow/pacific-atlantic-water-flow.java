class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }
        
        int m = heights.length;
        int n = heights[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        // Perform DFS from Pacific and Atlantic borders
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, pacific);
            dfs(heights, i, n - 1, atlantic);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, pacific);
            dfs(heights, m - 1, j, atlantic);
        }
        
        // Collect cells that can reach both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        
        return result;
    }
    
    private void dfs(int[][] heights, int r, int c, boolean[][] reachable) {
        reachable[r][c] = true;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            
            // Check bounds and flow conditions
            if (nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length 
                && !reachable[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                dfs(heights, nr, nc, reachable);
            }
        }
    }
}
