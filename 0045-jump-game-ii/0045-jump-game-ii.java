class Solution {
    public int jump(int[] nums) {

        int n= nums.length;
        if(n==1){
            return 0;
        }

        // PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));

        // pq.add(new int[]{0,0});
        

        // while(!pq.isEmpty()){

        //     int[] v= pq.poll();
        //     int idx=v[0];
        //     int st=v[1];
        //     if(idx==n-1){
        //         return st;
        //     }
 
        //     for(int i=0;i<=nums[idx];i++){
        //         if(idx+i<n){
        //         pq.add(new int[]{i+idx,st+1});
        //         }else{
        //             break;
        //         }
        //     }
           
        // }
        // return -1;


        int max=0;
        int cur=0;
        int step=0;
        for(int i=0;i<n;i++){
            //int s=(nums[i]+i)>n ?0 :nums[i]+i;
            max=Math.max(max,nums[i]+i);
            if(i==cur){
                step++;
                cur=max;
            }
            if(cur>=n-1){
                return step;
            }
        }
        return step;
        
    }
}