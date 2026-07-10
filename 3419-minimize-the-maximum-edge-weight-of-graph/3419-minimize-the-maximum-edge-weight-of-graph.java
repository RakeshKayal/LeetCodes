class Solution {

    class pair{
        int node;
       
        int weight;

        pair(int node,  int weight){
            this.node=node;
           
            this.weight=weight;
        }
    }
    public int minMaxWeight(int n, int[][] edges, int threshold) {


        List<List<pair>> adj= new ArrayList<>();

        for( int i=0;i<n;i++) adj.add(new ArrayList<>());

        

        int l=Integer.MAX_VALUE;
        int r=Integer.MIN_VALUE;

        for(int it[]: edges){
            int u=it[0];
            int v=it[1];
            int w= it[2];

          
            l=Math.min(w,l);
            r=Math.max(w,r);

           
            adj.get(v).add(new pair(u,w));
        }

        int ans=-1;

        while(l<=r){
            int mid=(l+r)/2;

            if(canPossible(mid,adj,n)){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
        
    }

    public boolean canPossible(int max,List<List<pair>> adj, int n){


        int src=0;
        Set<Integer> s= new HashSet<>();

       
        class pair1{
            int node; int w;
            pair1(int node, int w){
                this.node=node;
                this.w=w;
            }
        } 

        Queue<pair1> q= new ArrayDeque<>();

        q.add(new pair1(src,0));
        s.add(0);
        while(!q.isEmpty()){
            pair1 p= q.poll();

            int node=p.node;
            int w=p.w;

            for(pair p1: adj.get(node)){
                int nextNode=p1.node;
              
                int w1=p1.weight;

               
                    

                if(!s.contains(nextNode) && w1<=max){
                s.add(nextNode);
                q.add(new pair1(nextNode,w1));
                }
            }
        }

        

        return  s.size()==n;



    }
    
}