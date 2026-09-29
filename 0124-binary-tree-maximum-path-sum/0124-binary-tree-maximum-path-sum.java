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
//  /*
class Solution {
    int ans=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
         getSum(root);
         return ans;
    }

    int getSum(TreeNode node){
        if(node==null) return 0;
        int curr=node.val;
        int left=getSum(node.left); 
        if(left<0){
            left=0;
        }
        int right=getSum(node.right); 

        if(right<0){
            right=0;
        }
        int sum= left+right+curr;
        ans=Math.max(ans,sum);
        return curr+Math.max(left,right);
    }

    public int getMax(int a,int b,int c,int d){
        int m1=Math.max(a,b);
        int m2=Math.max(c,d);
        return Math.max(m1,m2);
    }
}

// */
/*
class Solution {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getSum(root);
        return ans;
    }

    int getSum(TreeNode node) {
        if (node == null) return 0;

        int curr = node.val;

        int left = getSum(node.left);
        int right = getSum(node.right);

        if (left < 0) {
            left = 0;
        }

        if (right < 0) {
            right = 0;
        }

        int sum = left + right + curr;

        ans = Math.max(ans, sum);

        return curr + Math.max(left, right);
    }
}
*/