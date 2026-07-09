 class DisjointSet {

    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            size.add(1);
            parent.add(i);
        }

    }

    public int findPath(int u) {

        if (u == parent.get(u)) {
            return u;
        }

        int c = findPath(parent.get(u));
        parent.set(u, c);
        return parent.get(u);
    }

    public void unionByRank(int u, int v) {
        int pu = findPath(u);
        int pv = findPath(v);

        if (pv == pu)
            return;

        if (rank.get(pu) == rank.get(pv)) { // 3 con because the rank is only increase
            // when both are same
            parent.set(pv, pu);
            rank.set(pu, rank.get(pu) + 1);
        } else if (rank.get(pu) < rank.get(pv)) {
            parent.set(pu, pv);
        } else {
            parent.set(pv, pu);
        }
    }

    public void unionBySize(int u, int v) {
        int pu = findPath(u);
        int pv = findPath(v);

        if (pu == pv)
            return;

        if (size.get(pu) < size.get(pv)) { // size can be increase
            // when i get new u or v not in the set
            parent.set(pu, pv);
            size.set(pv, size.get(pv) + size.get(pu));
        } else { // >=
            parent.set(pv, pu);
            size.set(pu, size.get(pu) + size.get(pv)); // but size also increase here so two
            //condition
        }
    } // disjoint set..
}

class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {


        DisjointSet ds= new DisjointSet(n);

        for( int i=1;i<n;i++){
            int u1= nums[i-1];
            int v1=nums[i];
            int u=i-1;
            int v=i;

            if(Math.abs(u1-v1)<=maxDiff){
                ds.unionByRank(u,v);
            }
        }

        boolean ans[]= new boolean[queries.length];
        int k=0;


        for(int it[] :queries){

            int ui=it[0];
            int vi=it[1];


            if(ds.findPath(ui)==ds.findPath(vi)){
                ans[k++]=true;
            }else{
                ans[k++]=false;
            }
        }

        return ans;

    }
}