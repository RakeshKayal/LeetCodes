class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        List<List<Integer>> ans = new ArrayList<>();

        int n = grid.length;
        int m = grid[0].length;

        k %= (n * m); 

        for (int l = 0; l < k; l++) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = grid[i][m - 1];  
            }

            for (int j = 0; j < n; j++) {
                for (int i = m - 2; i >= 0; i--) {  
                    grid[j][i + 1] = grid[j][i];
                }
            }

            grid[0][0] = a[a.length - 1];

            for (int i = 1; i < n; i++) {
                grid[i][0] = a[i - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            List<Integer> res = new ArrayList<>();

            for (int j = 0; j < m; j++) {  
                res.add(grid[i][j]);
            }
            ans.add(new ArrayList<>(res));
        }

        return ans;

    }
}