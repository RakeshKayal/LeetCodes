class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        int n = envelopes.length;
        if (n == 1) {
            return 1;
        }

        // Arrays.sort(envelopes,(a,b)->{
        //     if(a[0]==b[0]){
        //         return Integer.compare(b[1],a[1]);
        //     }return Integer.compare(b[0],a[0]);
        // });

        // int dp[][]= new int [n+1][n+1];

        // for(int it[]: dp){
        //     Arrays.fill(it,-1);
        // }

        //return f(0,-1,envelopes,dp);

        return f1(envelopes);

    }

    public int f(int id, int pre, int[][] e, int[][] dp) {

        if (id == e.length) {
            return 0;
        }

        if (pre != -1 && dp[id][pre] != -1) {
            return dp[id][pre];
        }

        int take = 0;
        int not = 0 + f(id + 1, pre, e, dp);

        if (pre == -1 || (e[id][0] < e[pre][0] && e[id][1] < e[pre][1])) {
            take = 1 + f(id + 1, id, e, dp);
        }

        if (pre != -1) {
            dp[id][pre] = Math.max(take, not);
        }

        return Math.max(take, not);
    }

    public int f1(int[][] e) {

        int n = e.length;

        int c[] = new int[n];

        Arrays.sort(e, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int j = 0;
        for (int it[] : e) {
            int k = it[1];
            c[j++] = k;
        }

        List<Integer> l = new ArrayList<>();

        l.add(c[0]);

        for (int i = 1; i < n; i++) {

            if (c[i] > l.get(l.size() - 1)) {
                l.add(c[i]);
            } else {

                int id = lowerBound(l, c[i]);

                if (id != -1) {
                    l.set(id, c[i]);
                }
            }

        }
        return l.size();

    }

    public int lowerBound(List<Integer> a, int s) {

        int l = 0;
        int r = a.size() - 1;
        int ans = -1;

        while (l <= r) {

            int mid = (l + r) / 2;

            if (a.get(mid) >= s) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;

    }
}