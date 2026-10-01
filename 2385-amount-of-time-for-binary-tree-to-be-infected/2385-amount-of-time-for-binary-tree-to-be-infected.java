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
    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
          dfs(root,map,-1);
        ArrayDeque<Integer> q=new ArrayDeque<>();
        q.offer(start);
HashSet<Integer> visited=new HashSet<>();
        visited.add(start);
                int time=-1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int u=q.poll();
                for(int v:map.get(u)){
                    if(visited.add(v)){
                        q.offer(v);
                    }
                }
            }
            time++;
        }
        return time;
    }

    void dfs(TreeNode root, HashMap<Integer,List<Integer>> map, int parent) {
        if (root == null)
            return;
        map.putIfAbsent(root.val, new ArrayList<>());
        if (root.left != null) {
            map.get(root.val).add(root.left.val);
        }
        if (root.right != null) {
            map.get(root.val).add(root.right.val);
        }
        if (parent != -1) {
            map.get(root.val).add(parent);
        }
        dfs(root.left, map, root.val);
        dfs(root.right, map, root.val);
    }
}