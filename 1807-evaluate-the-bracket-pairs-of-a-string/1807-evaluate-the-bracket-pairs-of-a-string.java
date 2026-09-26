class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        Map<String,String> m= new HashMap<>();

        for(List<String> st: knowledge){
            String K=st.get(0);
            String V=st.get(1);
            m.put(K,V);
        }


        Stack<Character> stack=new Stack<>();

        for(int i=0;i<s.length();i++){

            char cur= s.charAt(i);
            String g="";

            if(cur==')'){

            while(!stack.isEmpty() && stack.peek()!='(' ){
                g=stack.pop()+g;
            }
            if(stack.peek()=='('){
             stack.pop();
            }
            if(!m.containsKey(g)){
                stack.push('?');
            }else{
                String sa=m.get(g);
                int j=0;
                while(j<sa.length()){
                    stack.push(sa.charAt(j));
                    j++;
                }
            }
            }
            else{
                stack.push(cur);
            }
        }


      
       
       String ans="";

       while(!stack.isEmpty()){
        ans=stack.pop()+ans;

       }
       return ans;

        
    }
}