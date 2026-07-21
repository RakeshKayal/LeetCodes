class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<Integer>> map=new HashMap<>();

        for(int i=0;i<strs.length;i++){
            String s=strs[i];
            char[]c= s.toCharArray();
            Arrays.sort(c);
            String as= new String(c);

            map.computeIfAbsent(as,k-> new ArrayList<>()).add(i);
        }

        List<List<String>> ans= new ArrayList<>();


        for(Map.Entry<String, List<Integer>> it : map.entrySet()){

            List<String> res= new ArrayList<>();

            List<Integer>a= it.getValue();
            for(int i=0;i<a.size();i++){
                res.add(strs[a.get(i)]);
            }
            ans.add(res);

        }
        return ans;
        
    }
}