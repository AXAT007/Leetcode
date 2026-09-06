class Solution {
    public int findJudge(int n, int[][] trust) {
        int [] ind=new int[n+1];
        int [] outd=new int[n+1];
        int count=0;

        for(int [] t:trust){
            ind[t[1]]++;
            outd[t[0]]++;
        }
     int judge=-1;
        for(int i=1;i<=n;i++){
            if(outd[i]==0) {
                if(judge!=-1){
                    return -1;
                }
                else{
                    judge=i;
                }
            }
        }
         if(judge==-1 || ind[judge]!=n-1){
            return -1;
        }
        return judge; 
        
    //     ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    //     int count=0;
    //    for(int i = 0; i <= n; i++){
    //         adj.add(new ArrayList<>());
    //     }
    //     for(int[] t : trust){
    //         adj.get(t[0]).add(t[1]);
    //     }
    //     int judge=-1;
    //     for(int i=1;i<=n;i++){
    //         if(adj.get(i).size()==0) {
    //             if(judge!=-1){
    //                 return -1;
    //             }
    //             else{
    //                 judge=i;
    //             }
    //         }
    //     }
    //     for(int i=1;i<=n;i++){
    //         for(int node:adj.get(i)){
    //             if(node==judge) count++;
    //         }
    //     }
        // return count==n-1?judge:-1;
    }
}