class Solution {
 public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        // Traverse the entire grid
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') { // Found a new island
                    islandCount++;
                    dfs(grid, r, c); // Mark the entire island as visited
                }
            }
        }

        return islandCount;
    }

    private void dfs(char[][] grid, int r, int c) {
        // Boundary conditions and water checks
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }

        // Mark the cell as visited by setting it to '0'
        grid[r][c] = '0';

        // Explore all four directions
        dfs(grid, r + 1, c); // Down
        dfs(grid, r - 1, c); // Up
        dfs(grid, r, c + 1); // Right
        dfs(grid, r, c - 1); // Left
        
    }
}