class Solution {
    static int dr[]={0,0,-1,1};
    static int dc[]={-1,1,0,0};
    public int countIslands(int[][] grid, int k) {

        int n= grid.length;
        int m= grid[0].length;

        List<Long> l= new ArrayList<>();

        int v[][]= new int [n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(grid[i][j]>0 && v[i][j]==0){
                    long sum=comp(i, j, grid, v, 0);
                    // System.out.println(sum);
                    l.add(sum);
                }
            }
        }

        int c=0;
        for(long it : l){
            if(it%k==0){
                c++;
            }
        }
        return c;
        
    }

    public long comp(int r, int c, int [][] g, int [][]v, long s){
        v[r][c]=1;
        s+=g[r][c];

        for(int k=0;k<4;k++){
            int nr=r+dr[k];
            int nc=c+dc[k];

            if(Valid(nr, nc, g.length, g[0].length) && v[nr][nc]==0 && g[nr][nc]>0){
                s= comp(nr,nc,g,v,s);
            }
        }
        return s;
    }

    public boolean Valid(int nr, int nc, int n, int m){
        return nr>=0 && nc>=0 && nr<n && nc<m;
    }
}