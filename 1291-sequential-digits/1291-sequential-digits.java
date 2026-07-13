class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> list= new ArrayList<>();

        Queue<Integer> q= new ArrayDeque<>();
        for(int i=1;i<=8;i++){
            q.add(i);
        }


        while(!q.isEmpty()){

            int node=q.poll();

            if(node>high) break;

            if(node>=low && node<=high){
                list.add(node);
            }

            int last=node%10;
            if(last<9){
                q.add(node*10+last+1);
            }
        }
        return list;

        
        
    }
}