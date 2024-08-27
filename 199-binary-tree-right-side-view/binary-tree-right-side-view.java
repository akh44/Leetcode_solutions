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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> rightSide=new ArrayList<>();
        List<TreeNode> currlevel=new ArrayList<>();
        if(root!=null)
        {
           currlevel.add(root);
        }

        while(!currlevel.isEmpty())
        {
            rightSide.add(currlevel.get(currlevel.size()-1).val);
            List<TreeNode> nextlevel=new ArrayList<>();
            for(TreeNode var:currlevel)
            {
                if(var.left!=null)
                {
                    nextlevel.add(var.left);
                }
                if(var.right!=null)
                {
                    nextlevel.add(var.right);
                }
            }
            currlevel=nextlevel;

        }

        return rightSide;
    }
}