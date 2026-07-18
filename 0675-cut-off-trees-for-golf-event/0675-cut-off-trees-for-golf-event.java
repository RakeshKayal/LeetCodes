class Solution {

    static  int dr[]={-1,1,0,0};
    static int dc[]={0,0,-1,1};
    public int cutOffTree(List<List<Integer>> forest) {

        

        List<int[]> list= new ArrayList<>();


        for(int i=0;i<forest.size();i++){
            for(int j=0;j<forest.get(i).size();j++){

                if(forest.get(i).get(j)!=0 && forest.get(i).get(j)!=1){
                    list.add(new int[]{i,j,forest.get(i).get(j)});
                }
            }
        }


    list.sort((a, b) -> Integer.compare(a[2], b[2]));
        int move=0;

        int src=0;
        int srcc=0;

        for(int i=0;i<list.size();i++){
            //src 0, 0, desti=i;
            int[] dest=list.get(i);

            int desr=dest[0];
            int desc= dest[1];
            int m=bfs(src,srcc, desr,desc,forest);

            if(m==-1){
                return -1;
            }
            move+=m;
            src=desr;
            srcc=desc;
        }

        return move;


        
    }

    public int bfs(int r,int c, int desr,int desc,List<List<Integer>> forest){

      PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

q.add(new int[]{r, c, 0});
int n = forest.size();
int m = forest.get(0).size();
int visit[][] = new int[n][m];
visit[r][c] = 1;

while (!q.isEmpty()) {
    int it[] = q.poll();

    int row = it[0];
    int col = it[1];
    int move = it[2];

   
    if (row == desr && col == desc) {
        forest.get(row).set(col, 1); 
        return move;
    }

    for (int i = 0; i < 4; i++) {
        int nr = row + dr[i];
        int nc = col + dc[i]; 

        
        if (isValid(nr, nc, n, m) &&  forest.get(nr).get(nc) != 0 && visit[nr][nc] == 0) {
            q.add(new int[]{nr, nc, move + 1}); 
            visit[nr][nc] = 1;
        }
    }
}

return -1; 



        

        

    }

    public boolean isValid(int nr, int nc, int n, int m){

        return nr>=0 && nr<n && nc>=0 && nc<m;
    }
}