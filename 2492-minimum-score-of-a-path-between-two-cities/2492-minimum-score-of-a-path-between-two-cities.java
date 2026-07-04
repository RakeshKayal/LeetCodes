class d3 {
    List<Integer> rank =new ArrayList<>();
    List<Integer> parent= new ArrayList<>();
    List<Integer> size= new ArrayList<>();

    d3(int n){
        for (int i = 0; i < n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);

        }
    }


    public  int findRoot(int u){

        if (u==parent.get(u)){
            return u;
        }
        int set= findRoot(parent.get(u));
        parent.set(u,set);
        return  parent.get(u);

    }

    public  void unionByRanks(int u, int v){

        int pv= findRoot(u);
        int pu= findRoot(v);

        if (pu==pv) return;

        if (rank.get(pu)==rank.get(pv)){

            parent.set(pv,pu);
            rank.set(pu, rank.get(pu)+1);

        }
        else if (rank.get(u)> rank.get(v)){
            parent.set(pv,pu);


        }else {
            parent.set(pu,pv);

        }



    }

    public  void  unionSize(int u, int v){
        int pu=findRoot(u);
        int pv= findRoot(v);
        if (pu==pv) return;
        if (size.get(pu)>= size.get(pv)){
            size.set(pu, size.get(pu)+size.get(pv));
            parent.set(pv,pu);

        }else {
            size.set(pv, size.get(pu)+size.get(pv));
            parent.set(pu,pv);
        }
    }


}

class Solution {
    public  static  int minScore(int n, int[][] roads) {

        d3 ob = new d3(n + 1);

        
        for (int[] it : roads) {
            ob.unionByRanks(it[0], it[1]);
        }

        
        int min = Integer.MAX_VALUE;
        int root1 = ob.findRoot(1);

        for (int[] it : roads) {
            if (ob.findRoot(it[0]) == root1) {
                min = Math.min(min, it[2]);
            }
        }

        return min;

    }
}