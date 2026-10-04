import java.util.*;

class Solution {
   
    class node {
        char c;
        int i;
        node(char c, int i) {
            this.c = c;
            this.i = i;
        }
    }

    public boolean checkValidString(String s) {
        List<Integer> star = new ArrayList<>();
        Stack<node> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == ')') {
                if (!st.isEmpty() && st.peek().c == '(') {
                    st.pop();
                } else if (!star.isEmpty()) {
                    star.remove(star.size() - 1); 
                } else {
                    return false; 
                }
            } else if (cur == '(') {
                st.push(new node(cur, i));
            } else {
                star.add(i);
            }
        }

       
        while (!st.isEmpty()) {
            node t = st.pop();
            int idx = t.i;
            
           
            int lb = bt(star, idx); 
            if (lb == -1) {
                return false;
            }
            star.remove(lb);
        }
        return true;
    }

   
    public int bt(List<Integer> l, int idx) {
        int lo = 0;
        int hi = l.size() - 1;
        int ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (l.get(mid) > idx) {
                ans = mid;      
                hi = mid - 1;  
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}
