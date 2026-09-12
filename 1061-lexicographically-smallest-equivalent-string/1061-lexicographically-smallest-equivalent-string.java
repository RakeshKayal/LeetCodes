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
    }

    public List<Integer> get_all_child(int parent) {
        int root = findPath(parent);
        List<Integer> members = new ArrayList<>();
        for (int i = 0; i < rank.size(); i++) {
            if (findPath(i) == root) {
                members.add(i);
            }
        }
        return members;
    }
}

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        DisjointSet ds = new DisjointSet(26);

        for (int i = 0; i < s1.length(); i++) {

            int u = s1.charAt(i) - 'a';
            int v = s2.charAt(i) - 'a';
            ds.unionByRank(u, v);

        }

        String ans = "";
        for (int i = 0; i < baseStr.length(); i++) {

            int p = baseStr.charAt(i) - 'a';

            List<Integer> l = ds.get_all_child(p);
            Collections.sort(l); // or l.sort(null);

            ans += (char) (l.get(0) + 'a');
        }
        return ans;

    }
}