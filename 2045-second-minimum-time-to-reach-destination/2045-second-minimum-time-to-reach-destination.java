class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        

       List<List<Integer>> adj= new ArrayList<>();

       for(int i=0;i<n;i++){
           adj.add(new ArrayList<>());

       }

       for (int[] it : edges){
           int u= it[0]-1;
           int v=it[1]-1;

           adj.get(u).add(v);
           adj.get(v).add(u);
       }


       int d1[]=new int[n];
       int d2[]= new int[n];

        for (int i = 0; i <n ; i++){
            d1[i]=(int) 1e9;
            d2[i]=(int) 1e9;
        }

        class pair{
            int timePass;
            int node;
            pair(int timePass, int node){
                this.timePass=timePass;
                this.node=node;
            }
        }

        PriorityQueue<pair> q= new PriorityQueue<>((a,b)->a.timePass-b.timePass);
        q.add(new pair(0,0));
        d1[0]=0;

        while (!q.isEmpty())
        {
            pair p= q.poll();
            int timePass= p.timePass;
            int node= p.node;
           if (node == n - 1 && d2[node] != (int) 1e9) {
                return d2[node];
            }
            if (d2[node] < timePass) continue;


            int div = timePass / change;
            int waitTime = 0;

            if (div % 2 != 0) {
                waitTime = (div + 1) * change - timePass;
            }

            int departureTime = timePass + waitTime;
            int ntime = departureTime + time;

            for (Integer it: adj.get(node)){

                if (ntime < d1[it]) {
                    d2[it] = d1[it];
                    d1[it] = ntime;
                     q.add( new pair(ntime,it));

                } else if (ntime > d1[it] && ntime < d2[it]) {
                    d2[it] = ntime;
                     q.add( new pair(ntime,it));

                }
             


            }



        }

        // System.out.println("time : "+d2[n-1]);
        // return d2[n-1];
        return -1;
    }
}