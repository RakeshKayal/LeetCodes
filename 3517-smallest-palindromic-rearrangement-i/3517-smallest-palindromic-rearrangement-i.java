class Solution {
    public String smallestPalindrome(String s) {

        int a[]= new int[26];

        for(int i=0;i<s.length();i++){
            a[s.charAt(i)-'a']++;
        }

        StringBuilder sb= new StringBuilder();

        int n=s.length();
        if(n<=1){ return s;}
        
        char mid = '\0';

        
        for(int i=0;i<26;i++){
            while (a[i] >= 2) {          
                sb.append((char) (i + 'a'));
                a[i] -= 2;
            }
            if(a[i]==1){
                mid=(char)(i+'a');

            }
        }

        String ans= sb.toString();
       
         String rev= sb.reverse().toString();
        
        
        if(n%2==0){
            return ans+rev;
        }

       


        return ans+ mid +rev;


        
    }
}