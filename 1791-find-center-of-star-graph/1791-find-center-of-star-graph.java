class Solution {
    public int findCenter(int[][] edges) {
        int n=edges.length+1;
        int [] count=new int[n+1];
        for(int[] e:edges){
            for(int ee:e){
                count[ee]++;
            }
        }
        int ans=0;
        for(int i=0;i<count.length;i++){
            if(count[i]>ans){
                ans=i;
            }
        }

        return ans;
    }
}