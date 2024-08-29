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
    public int goodNodes(TreeNode root) {
        
            return countGoodNodes(root,root.val);
    }

        private int countGoodNodes(TreeNode node,int maxsoFar)
        {
            int numofGoodNodes=0;

            if(node!=null)
            {
                if(node.val>=maxsoFar)
                {
                    maxsoFar=node.val;
                    numofGoodNodes++;
                }
                numofGoodNodes+=countGoodNodes(node.left,maxsoFar);
                numofGoodNodes+=countGoodNodes(node.right,maxsoFar);
            }

            return numofGoodNodes;
        }


    }
