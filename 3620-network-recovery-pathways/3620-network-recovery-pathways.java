import java.util.*;

class Solution {

    static class Pair {
        int node;
        int cost;

        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    public static int findMaxPathScore(int[][] edges, boolean[] online, long k) {

      
        if (edges == null || edges.length == 0) return -1;

        int n = online.length;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        int max = Integer.MIN_VALUE;

        for (int[] it : edges) {
            int u = it[0];
            int v = it[1];
            int cost = it[2];
            max = Math.max(max, cost);
            adj.get(u).add(new Pair(v, cost));
        }

        long l = 0;
        long r = max;
        long ans = -1;

        
        while (l <= r) {
            long mid = (l + r) / 2;

            if (canReach(0, n - 1, adj, online, mid, k)) {
                ans = mid;
                l = mid + 1;  
            } else {
                r = mid - 1;  
            }
        }

        return (int) ans;
    }

   
    private static boolean canReach(
            int src, int dest,
            List<List<Pair>> adj,
            boolean[] online,
            long minWeight, long k) {

        int n = adj.size();

       
        if (!online[src] || !online[dest]) return false;

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[src] = 0;

        
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.cost, b.cost)
        );
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.node;
            int cost = p.cost;

            
            if (cost > dist[node]) continue;

            for (Pair it : adj.get(node)) {
                int neighbour = it.node;
                int weight = it.cost;

              
                if (weight < minWeight) continue;

                
                if (neighbour != dest && !online[neighbour]) continue;

                long newCost = dist[node] + weight;

               
                if (newCost > k) continue;

                if (newCost < dist[neighbour]) {
                    dist[neighbour] = newCost;
                    pq.add(new Pair(neighbour, (int) newCost));
                }
            }
        }

        return dist[dest] <= k;
    }
}