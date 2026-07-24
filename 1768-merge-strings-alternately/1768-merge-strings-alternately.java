class Solution {
    public String mergeAlternately(String w1, String w2) {

        StringBuilder sb= new StringBuilder();
        boolean flag=true;
        int i=0;
        int j=0;
        int n=Math.min(w1.length() ,w2.length());
        while(i<n || j<n){

            if(flag){
                sb.append(w1.charAt(i));
                i++;
                flag=false;
            }else{
                sb.append(w2.charAt(j));
                j++;
                flag=true;
            }
        }

        while(i<w1.length()){
            sb.append(w1.charAt(i));
            i++;
        }
         while(j<w2.length()){
            sb.append(w2.charAt(j));
            j++;
        }

        return sb.toString();


        
        
    }
}