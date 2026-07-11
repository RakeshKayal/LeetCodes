class Solution {

   
    public int countCompleteComponents(int n, int[][] edges) {


        List<List<Integer>> adj= new ArrayList<>();

        for(int i=0;i<n;i++)adj.add(new ArrayList<>());

        for(int it[]: edges){
            int u=it[0];
            int v=it[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }


        int visit[]=new int [n];
        int count=0;

        for(int i=0;i<n;i++){

            if(visit[i]!=1){

                int[] count1 = {0};
                int[] edgeCount = {0};

                dfs(i,-1,visit,adj,count1,edgeCount);
                int a=count1[0];
                int b=edgeCount[0];
                a=a*(a-1);

                b=b/2;
                if((a/2)==b){
                    count++;
                }

                
            }
        }
        return count;
        
    }

    public void dfs(int node,int p,int[] visit, List<List<Integer>>adj,int []c,int e[]){
        visit[node]=1;
        c[0]++;
        
        for(Integer it : adj.get(node)){
             e[0]++;

            if(visit[it]!=1){
               
                dfs(it, node, visit, adj,c,e);
            }
            
        }

       
        

    }
}