class Solution {
    public int maxActiveSectionsAfterTrade(String s) {


        List<Integer> l= new ArrayList<>();
        
        int o=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') o++;          
        }

        int i=0;
        while(i<s.length()){

            if(s.charAt(i)=='0'){
                int st= i;
                while(i<s.length() && s.charAt(i)=='0'){
                    i++;
                }
                l.add(i-st);
            }else{
                i++;
            }
        }

        int max=0;
        for(int j=1;j<l.size();j++ ){
            max=Math.max(max,(l.get(j-1)+l.get(j)));
        }
        return max+o;

        
        
    }
}