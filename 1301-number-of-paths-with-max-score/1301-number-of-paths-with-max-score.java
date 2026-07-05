class Solution {

    static int dr[]={0,-1,-1};
    static int dc[]={-1,-1,0};
    static int MOD=(int)1e9+7;
    public int[] pathsWithMaxScore(List<String> board) {

        int n=board.size();
        char[][] c_board=new char[n][n];

        for(int j=0;j<board.size();j++){

            for(int i=0;i<board.get(j).length();i++){
                char a=board.get(j).charAt(i);
                c_board[j][i]=a;
            }
        }

        // class pair{
        //     int row;
        //     int col;
        //     int sum;
        //     pair(int row, int col, int sum){
        //         this.row=row;
        //         this.col=col;
        //         this.sum=sum;

        //     }
        // }


        // Queue<pair> q= new ArrayDeque<>();
        // q.add(new pair(n-1,n-1,0));

        // int max=-1;
        // int path=0;

        // while(!q.isEmpty()){

        //     pair p= q.poll();
        //     int r=p.row;
        //     int c=p.col;
        //     int s=p.sum;

        //     if(c_board[r][c]=='E'){

        //         if(max<s){
        //             max=s;
        //             path=1;
        //         }else if(max==s){
        //             path++;
        //         }
        //     }

        //     for( int i=0;i<3;i++){
        //         int nr=r+dr[i];
        //         int nc=c+dc[i];



        //         if(isValid(nr,nc,n) && c_board[nr][nc]!='X'){

        //             int ns = Character.isDigit(c_board[nr][nc]) ? c_board[nr][nc] - '0' : 0;

        //             q.add(new pair(nr,nc,((s+ns)%MOD)));


        //         }
        //     }

        // }
        // if(max==-1){
        //     max=0;
        // }
        //  return new int[]{max,path};


        int best[][]= new int [n][n];
        
        for( int[] it : best){
            Arrays.fill(it,-1);
        }

        int ways[][]= new int [n][n];

        f(n-1,n-1,n,c_board,best,ways);

        int max=best[n-1][n-1]==Integer.MIN_VALUE?0:best[n-1][n-1];
        int path=ways[n-1][n-1];
        return new int []{max,path};
        


        
        
    }


    public int f(int r, int c,int n, char c_board[][],int best[][],int ways[][]){
        if(r==0 && c==0){
            best[0][0]=0;
            ways[0][0]=1;
            return 0;
        }

        if(!isValid(r,c,n)){
            return Integer.MIN_VALUE;
        }
        if(c_board[r][c]=='X'){
            return Integer.MIN_VALUE;
        }

        if(best[r][c]!=-1){
            return best[r][c];
        }


        int digit=(Character.isDigit(c_board[r][c]) ? c_board[r][c] - '0' : 0);
        int bestNext=Integer.MIN_VALUE;
        int w=0;


        for(int i=0;i<3;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            int sub=f(nr,nc,n,c_board,best,ways);

            if(sub==Integer.MIN_VALUE) continue;

            if(sub>bestNext){
                bestNext=sub;
                w=ways[nr][nc];
            }else if(sub==bestNext){
                w=((w+ways[nr][nc])%MOD);
            }
        }

        if(bestNext==Integer.MIN_VALUE){
            best[r][c]=Integer.MIN_VALUE;
            ways[r][c]=0;
            return Integer.MIN_VALUE;
        }
        best[r][c]=digit+bestNext;
        ways[r][c]= w;
        return best[r][c];


    }

    public boolean isValid(int nr, int nc, int n){

        return nr>=0 && nr<n && nc>=0 && nc<n;
    }
}