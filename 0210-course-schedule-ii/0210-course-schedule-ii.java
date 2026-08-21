class Solution {
    public int[] findOrder(int V, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int [] deg=new int[V];
        
        for (int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] pre: prerequisites){
            adj.get(pre[1]).add(pre[0]);
            deg[pre[0]]++;
            
        
        }
        Queue<Integer> q=new ArrayDeque<>();
        boolean [] visited=new boolean[V];
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(deg[i]==0&&!visited[i]){
                q.offer(i);
                visited[i]=true;
                while(!q.isEmpty()){

                    int x=q.poll();
                    ans.add(x);
                    for(int val:adj.get(x)){
                        deg[val]--;
                        if(deg[val]==0){
                            q.offer(val);
                            visited[val]=true;

                        }
                    }
                }           
            }
        }
    if(ans.size()!=V) return new int[0];     
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    } 
}