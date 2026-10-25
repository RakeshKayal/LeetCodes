class Solution {
    static int dr[]={0,0,-1,1};
    static int dc[]={1,-1,0,0};
    public int closedIsland(int[][] grid) {

        int n=grid.length;
        int m=grid[0].length;

        int visit[][]= new int [n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    
                    if(grid[i][j]==0 && visit[i][j]==0){
                        component(grid, i, j, visit);
                    }
                }else{
                    continue;
                }
            }
        }

        int c=0;
        int co[][]=new int[n][m];


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(grid[i][j]==0 && visit[i][j]==0){
                   
                   if(co[i][j]==0){
                    c++;
                    markCompo(grid, i, j, co);
                   }
                    

                }
            }
        }

        return c;

        
        
    }

    public void markCompo(int grid[][],int r, int c,  int co[][]){
        co[r][c]=1;

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(valid(nr,nc, grid.length,grid[0].length) && co[nr][nc]==0 && grid[nr][nc]==0 ){
                markCompo(grid,nr,nc,co);
            }
        }

    }


    public void component(int grid[][],int r, int c, int [][] visit){
        visit[r][c]=1;

        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(valid(nr,nc, grid.length,grid[0].length) && visit[nr][nc]==0 && grid[nr][nc]==0){
                component(grid,nr,nc,visit);
            }
        }
    }

    public boolean valid(int nr, int nc, int n, int m){
        return nr>=0 && nr<n && nc>=0 && nc<m;
    }
}