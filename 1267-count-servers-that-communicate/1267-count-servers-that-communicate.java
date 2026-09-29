class Solution {
    public int countServers(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int [] rowParent=new int[n];
        int [] colParent=new int[m];
        int [] visited=new int[n*m];
        Arrays.fill(rowParent,-1);
        Arrays.fill(colParent,-1);

int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){

                    int curr=i*m+j;
                    if(rowParent[i]==-1){
                        rowParent[i]=curr;
                    }
                    else{
                        int p=rowParent[i];
                        if(visited[curr]==0){
                            visited[curr]=1;
                            count++;
                        }
                        if(visited[p]==0){
                            visited[p]=1;
                            count++;
                        }
                    }
                    if(colParent[j]==-1){
                        colParent[j]=curr;
                    }
                    else{
                        int p=colParent[j];
                        if(visited[curr]==0){
                            visited[curr]=1;
                            count++;
                        }
                        if(visited[p]==0){
                            visited[p]=1;
                            count++;
                        }
                    }                    
                }
            }
        }
        return count;
    }
}