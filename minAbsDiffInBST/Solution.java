/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int min = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        System.out.println(min);
        return min;
    }
    
    public void inorder(TreeNode current){
        if(current == null)return;
        inorder(current.left);
        if(prev != null){
            min = Math.min(min, current.val - prev.val);
            System.out.println(current.val+"-"+prev.val+";"+min);
        }
        prev = current;
        inorder(current.right);
    }
}