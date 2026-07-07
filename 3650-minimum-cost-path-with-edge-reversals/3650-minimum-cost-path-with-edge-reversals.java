class Solution {

     class pair{
            int node;
            int cost;
            pair(int node, int cost){
                this.node=node;
                this.cost=cost;
            }
        }
    public int minCost(int n, int[][] edges) {


         List<List<pair>> adj= new ArrayList<>();

        for( int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int it[]:edges){
            int u=it[0];
            int v=it[1];
            int c=it[2];

            adj.get(u).add(new pair(v,c)); 
            adj.get(v).add(new pair(u,c*2));  
        }



       int m= Bfs(0,n-1, adj);
       return m==(int)1e9?-1:m;

        
    }

    public int Bfs(int src, int dest,List<List<pair>> adj){



        int dist[]= new int [dest+1];

        Arrays.fill(dist,(int)1e9);

        PriorityQueue<pair> q= new PriorityQueue<>((a,b)->a.cost-b.cost);


        q.add(new pair(src,0));
        dist[src]=0;

        while(!q.isEmpty()){

            pair p= q.poll();
            int node=p.node;
            int cost=p.cost;

            if(dist[node]<cost) continue;

            for(pair it: adj.get(node)){
                int v=it.node;
                int c=it.cost;

                int neCost=c+cost;
                if(dist[v]>neCost){
                    dist[v]=neCost;
                    q.add(new pair(v,neCost));
                }
            }
        }

        return dist[dest];
    }
}