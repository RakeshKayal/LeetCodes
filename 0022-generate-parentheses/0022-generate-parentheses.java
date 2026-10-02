class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result= new ArrayList<>();

        String s[]= {"(",")"};
        StringBuilder s1= new StringBuilder();
        generated(0,n,s,s1,result);
        return  result;

    }

    private void generated(int index, int n,String[] s, StringBuilder s1, List<String> result) {

        if (index==n*2){
            if(valid(s1)){
                result.add(String.valueOf(s1));
            }
            return;
        }

        for (int i = 0; i < s.length; i++) {
            s1.append(s[i]);
            generated(index+1,n,s,s1,result);
            s1.deleteCharAt(s1.length()-1);
        }
    }

    private boolean valid(StringBuilder s1) {

        int l=0;
        int r=0;
        if (s1.charAt(0)==')'){
            return  false;
        }
        for (int i = 0; i < s1.length(); i++) {

            if (s1.charAt(i)=='(') {

                l++;
            }
            if (s1.charAt(i)==')') {
            r++;
            }
            if(r>l){
                return  false;
            }
        }
        return l==r;

    }
            
}