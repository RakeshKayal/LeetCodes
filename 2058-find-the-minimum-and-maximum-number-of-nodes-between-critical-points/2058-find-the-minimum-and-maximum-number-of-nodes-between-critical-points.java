/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        ListNode ptr=head;
        List<Integer> l= new ArrayList<>();
        
        while(ptr!=null){
            l.add(ptr.val);
            ptr=ptr.next;
        }
        int n=l.size();

        
        List<Integer> critical= new ArrayList<>();
        for(int i=1;i<n-1;i++){
           if((l.get(i-1)<l.get(i) && l.get(i+1)<l.get(i)) || (l.get(i-1)>l.get(i) && l.get(i+1)>l.get(i))){
            critical.add(i+1);
           }
        }
        int n1=critical.size();
        if(n1<2) return new int[]{-1,-1};

        critical.sort((a,b)->Integer.compare(a,b));
       int max=critical.get(critical.size()-1)-critical.get(0);

        int min=Integer.MAX_VALUE;
        for(int i=0;i<n1-1;i++){
          min=Math.min(min,(critical.get(i+1)-critical.get(i)));
        }
        return new int[]{min,max};
        
    }
}