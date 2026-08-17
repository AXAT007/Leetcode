class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean [] visited=new boolean[isConnected.length];
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i< isConnected.length;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i< isConnected.length;i++){
            for(int j=0;j<isConnected[i].length;j++){
                if(isConnected[i][j]==1&& i!=j){
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        int count =0;
        ArrayDeque<Integer> q=new ArrayDeque<>();
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                
                q.offer(i);
                visited[i]=true;
                while(!q.isEmpty()){
                    int x=q.poll();
                    for(int val:list.get(x)){
                        if(!visited[val]){
                            q.offer(val);
                            visited[val]=true;
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}