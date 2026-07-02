class Solution {

    static int dr[]={-1,1,0,0};
    static int dc[]={0,0,1,-1};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        class pair{
            int row;
            int col;
            int helth;
            pair(int row, int col, int helth){
                this.row=row;
                this.col=col;
                this.helth=helth;
            }
        }

        int n= grid.size();
        int m= grid.get(0).size();

        int a=0;

        if(grid.get(0).get(0)==1){
            a=1;
        }

        PriorityQueue<pair> q= new PriorityQueue<>((c,d)->c.helth-d.helth);

        int visit[][]= new int [n][m];
        
        visit[0][0]=1;
        q.add(new pair(0,0,a));
        int minHel=0;
        while(!q.isEmpty()){

            pair p= q.poll();

            int r= p.row;
            int c=p.col;
            int h=p.helth;
            if(r==n-1 && c==m-1){
                minHel=h;
                break;
            }

            for( int i=0;i<4;i++){
                int nr= r+dr[i];
                int nc=c+dc[i];

                if(isValid(nr,nc,n,m) && visit[nr][nc]!=1){
                    visit[nr][nc]=1;
                    q.add(new pair(nr,nc,grid.get(nr).get(nc)+h));
                }
            }
        }

        return minHel<health;
        
    }

    public boolean isValid( int nr, int nc, int n, int m){

        return nr>=0 && nr<n && nc>=0 && nc<m;
    }
}