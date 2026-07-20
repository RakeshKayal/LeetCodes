/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static int count;
    public int countDominantNodes(TreeNode root) {
        count=0;

        f(root);
        return count;
        
    }

    public int f(TreeNode r){

        if(r==null){
            return Integer.MIN_VALUE;
        }



        int left=f(r.left);
        int right=f(r.right);

        if(r.val>=left && r.val>=right){
            count++;
        }

        return Math.max(r.val,Math.max(left,right));

        
    }
}