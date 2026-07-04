class Solution {
    public long[] minTimeMaxPower(int n, int[][] edges, int power, int[] cost, int source, int target) {

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] it : edges) {
            int u = it[0];
            int v = it[1];
            int t = it[2];
            adj.get(u).add(new int[]{v, t});
        }

        class tuple {
            int node;
            long time;
            int p;
            tuple(int node, long time, int p) {
                this.node = node;
                this.time = time;
                this.p = p;
            }
        }

        // tie-break on time first, then on p (lower power used = higher remaining power)
        PriorityQueue<tuple> q = new PriorityQueue<>((a, b) ->
            a.time != b.time ? Long.compare(a.time, b.time) : Integer.compare(a.p, b.p)
        );

        // visited must be per (node, powerUsed) -- NOT just per node
        boolean visit[][] = new boolean[n][power + 1];

        q.add(new tuple(source, 0, 0));

        while (!q.isEmpty()) {

            tuple t = q.poll();
            int node = t.node;
            long time = t.time;
            int pow = t.p;

            if (pow > power) continue;
            if (visit[node][pow]) continue;

            if (node == target) {
                // time  p
                return new long[]{time, power - pow};
            }

            visit[node][pow] = true;

            for (int it[] : adj.get(node)) {

                int next = it[0];
                long ts = it[1];

                int newPow = pow + cost[node];
                if (newPow > power) continue;
                if (visit[next][newPow]) continue;

                q.add(new tuple(next, time + ts, newPow));
            }
        }

        return new long[]{-1, -1};
    }
}