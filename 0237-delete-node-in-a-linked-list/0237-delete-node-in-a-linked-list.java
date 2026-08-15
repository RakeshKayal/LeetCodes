/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {

        ListNode p=node;

        node.val=node.next.val;
        while(p.next.next!=null){
            p.val=p.next.val;
            p=p.next;
        }
        p.val=p.next.val;
        p.next=null;
    }
}