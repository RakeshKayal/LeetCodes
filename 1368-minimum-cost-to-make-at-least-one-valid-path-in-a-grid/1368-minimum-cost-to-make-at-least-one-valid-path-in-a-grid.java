class Solution {

    class pair{
        int r;
        int c;
        int cost;

        pair(int r, int c, int cost){
            this.r=r;
            this.c=c;
            this.cost=cost;
        }
    }

    static int dr[]={-1,1,0,0};
    static int dc[]={0,0,-1,1};
    public int minCost(int[][] grid) {

        int n=grid.length;
        int m=grid[0].length;


        int visit[][]= new int[n][m];

        for(int it[]: visit){
            Arrays.fill(it,(int)1e9);
        }
        PriorityQueue<pair> pq= new PriorityQueue<>((a,b)->a.cost-b.cost);


        pq.add(new pair(0,0,0));
        visit[0][0]=0;


        while(!pq.isEmpty()){

            pair p= pq.poll();

            int r=p.r;
            int c=p.c;
            int co=p.cost;

            if(visit[r][c]<co) continue;

            for(int i=0;i<4;i++){

                int nr=r+dr[i];
                int nc= c+dc[i];

                if(isValid(nr,nc,n,m)){

                    int cost;

                    if(grid[r][c]==1 && (nr==r  && nc==c+1)){
                        cost=co;
                    } 
                    else if( grid[r][c]==2 && (nr==r &&nc==c-1)){
                        cost=co;
                        }
                    else if(grid[r][c]==3 &&(nr==r+1 && nc==c)){
                       cost=co;
                    }
                    else if(grid[r][c]==4 && (nr==r-1 && nc==c)){
                        cost=co;
                    }else{

                    cost=co+1;
                    }

                    if(visit[nr][nc]>cost){
                        visit[nr][nc]=cost;
                        pq.add(new pair(nr,nc,cost));
                    }

                }
            }

        }
         return visit[n-1][m-1];
        
    }

    public boolean isValid(int nr, int nc, int n, int m){
        return nr>=0 && nr<n && nc>=0 &&nc<m;
    }
}