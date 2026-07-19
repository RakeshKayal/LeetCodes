class Solution {
    public String smallestSubsequence(String s) {


           int n=s.length();
        int fre[]= new int[26];

        for(int i=0;i<n;i++){
            fre[s.charAt(i)-'a']++;    //O(n)
        } 


     Stack<Character> st= new Stack<>();
     int fre1[]= new int[26];

    for(int i=0;i<n;i++){   //O(n)
         int c = s.charAt(i) - 'a';
        fre[c]--;  

        if (fre1[c] == 1) continue;

        while(!st.isEmpty()&& fre[st.peek()-'a']> 0 && s.charAt(i)-'a'<st.peek()-'a' && fre1[s.charAt(i)-'a']==0){
              fre1[st.pop() - 'a'] = 0;  // in wrostCase it take O(n)

        }
        fre1[s.charAt(i) -'a']++;
       
        st.push(s.charAt(i));
    }

     StringBuilder ans = new StringBuilder();
    while (!st.isEmpty()) ans.append(st.pop());  //O(n)
    ans.reverse();  //O(n)
    return ans.toString();
    }
}