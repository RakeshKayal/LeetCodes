import java.util.*;

class Solution {
    static int dr[] = {0, 1};
    static int dc[] = {1, 0};
    
    
    class node {
        int r;
        int c;
        int bal; 
        
        node(int r, int c, int bal) {
            this.r = r;
            this.c = c;
            this.bal = bal;
        }
    }
    
    public boolean hasValidPath(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
      
        if (grid[0][0] == ')' || grid[n-1][m-1] == '(') return false;
        
       
        int maxBal = n * m; 
        
        
        boolean[][][] visit = new boolean[n][m][maxBal + 1];
        Queue<node> q = new ArrayDeque<>();
        
       
        q.add(new node(0, 0, 1));
        visit[0][0][1] = true;

        while (!q.isEmpty()) {
            node nsa = q.poll();
            int r = nsa.r;
            int c = nsa.c;
            int bal = nsa.bal;

           
            if (r == n - 1 && c == m - 1 && bal == 0) {
                return true;
            }

            for (int i = 0; i < 2; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    
                    int nextBal = bal + (grid[nr][nc] == '(' ? 1 : -1);
                    
                   
                    if (nextBal >= 0 && nextBal <= maxBal && !visit[nr][nc][nextBal]) {
                        visit[nr][nc][nextBal] = true;
                        q.add(new node(nr, nc, nextBal));
                    }
                }
            }
        }
        return false;
    }
}
