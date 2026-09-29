class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        PriorityQueue<int[]> q= new PriorityQueue<>((a,b)->
         Integer.compare(b[0],a[0])
        );

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                q.add(new int []{grid[i][j],i});
            }
        }

        long sum=0;

        while(k!=0 && !q.isEmpty()){
            int [] a= q.poll();
            int s=a[0];
            int r=a[1];
          

            if(limits[r]!=0){
                sum+=s;
                limits[r]--;
                k--;
            }
            
        }
        return sum;
    }
}