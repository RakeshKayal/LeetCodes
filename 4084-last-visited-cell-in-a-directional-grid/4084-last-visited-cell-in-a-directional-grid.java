class Solution {
    public int[] lastVisitedCell(char[][] grid) {

        Queue<int[]> q= new ArrayDeque<>();


        int n= grid.length;
        int m= grid[0].length;


        if(grid[0][0]=='L'){
            return new int []{0,0};
        }


        int visit[][]= new int [n][m];

        visit[0][0]=1;
        q.add(new int[]{0,0});
        while(!q.isEmpty()){

            int []node= q.poll();
            char c1=grid[node[0]][node[1]];
            int r=node[0];
            int c=node[1];


            if(c1=='R'){
                int nr=r;
                int nc=c+1;
                if( notValid(nr,nc,n,m)==false  || visit[nr][nc]==1){
                    return new int[]{r,c};
                }else{
                    q.add(new int []{nr,nc});
                    visit[nr][nc]=1;
                }

            }else if (c1=='L'){

                 int nr=r;
                int nc=c-1;
                if(notValid(nr,nc,n,m)==false  || visit[nr][nc]==1){
                    return new int[]{r,c};
                }else{
                    q.add(new int []{nr,nc});
                    visit[nr][nc]=1;
                }

            }else if(c1=='U'){

                 int nr=r-1;
                int nc=c;
                if(notValid(nr,nc,n,m)==false  || visit[nr][nc]==1){
                    return new int[]{r,c};
                }else{
                    q.add(new int []{nr,nc});
                    visit[nr][nc]=1;
                }

            }else if(c1=='D'){

                 int nr=r+1;
                int nc=c;
                if(notValid(nr,nc,n,m)==false  || visit[nr][nc]==1){
                    return new int[]{r,c};
                }else{
                    q.add(new int []{nr,nc});
                    visit[nr][nc]=1;
                }

            }
        }

        return new int []{};
        
    }
    public boolean  notValid(int nr, int nc, int n, int m){

        return nr>=0 && nr<n && nc>=0 && nc<m;
    }
}