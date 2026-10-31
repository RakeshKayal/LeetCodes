class Solution {
    static int mod = (int) 1e9 + 7;

    public int uniquePaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
       
        Integer[][][] dp = new Integer[n][m][3];
        return f(0, 0, grid, -1, dp);
    }

    public int f(int i, int j, int[][] g, int d, Integer[][][] dp) {
        
        if (i >= g.length || j >= g[0].length) {
            return 0;
        }

        
        if (i == g.length - 1 && j == g[0].length - 1) {
            return 1;
        }

      
        int dIdx = d + 1;
        if (dp[i][j][dIdx] != null) {
            return dp[i][j][dIdx];
        }

        int right = 0;
        int down = 0;

       
        if (d == -1) {
            
            if (j + 1 < g[0].length) {
                if (g[i][j + 1] == 1) {
                    right = f(i + 1, j + 1, g, 1, dp); 
                } else {
                    right = f(i, j + 1, g, 1, dp);
                }
            }
            
           
            if (i + 1 < g.length) {
                if (g[i + 1][j] == 1) {
                    down = f(i + 1, j + 1, g, 0, dp); 
                } else {
                    down = f(i + 1, j, g, 0, dp);
                }
            }

            return dp[i][j][dIdx] = (down + right) % mod;

       
        } else if (d == 1 && g[i][j] == 1) {
           
            if (j + 1 < g[0].length) {
                if (g[i][j + 1] == 1) {
                    right = f(i + 1, j + 1, g, 1, dp);
                } else {
                    right = f(i, j + 1, g, 1, dp);
                }
            }
            return dp[i][j][dIdx] = right % mod;

     
        } else if (d == 0 && g[i][j] == 1) {
           
            if (i + 1 < g.length) {
                if (g[i + 1][j] == 1) {
                    down = f(i + 1, j + 1, g, 0, dp);
                } else {
                    down = f(i + 1, j, g, 0, dp);
                }
            }
            return dp[i][j][dIdx] = down % mod;

       
        } else {
            if (j + 1 < g[0].length) {
                if (g[i][j + 1] == 1) {
                    right = f(i + 1, j + 1, g, 1, dp);
                } else {
                    right = f(i, j + 1, g, 1, dp);
                }
            }

            if (i + 1 < g.length) {
                if (g[i + 1][j] == 1) {
                    down = f(i + 1, j + 1, g, 0, dp);
                } else {
                    down = f(i + 1, j, g, 0, dp);
                }
            }

            return dp[i][j][dIdx] = (down + right) % mod;
        }
    }
}
