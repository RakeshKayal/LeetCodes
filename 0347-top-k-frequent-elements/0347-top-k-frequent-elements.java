class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> m= new HashMap<>();

        class pair{
            int node;
            int fre;

            pair(int node,int fre){
                this.node=node;
                this.fre=fre;
            }
        }

        PriorityQueue<pair> q= new PriorityQueue<>((a,b)->b.fre-a.fre);

        for(int i=0;i<nums.length;i++){
            m.put(nums[i],m.getOrDefault(nums[i],0)+1);
        }

        for (Map.Entry<Integer, Integer> it : m.entrySet()) {
            q.add(new pair(it.getKey(),it.getValue()));
    
        }

        int ans[]= new int[k];
        int i=0;
        while(k-- >0){
            pair p= q.poll();
            ans[i++]=p.node;
        }
        return ans;

        
    }
}