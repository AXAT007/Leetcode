class Pair{
    int a;
    int b;
    Pair(int x,int y){
        a=x;
        b=y;
    }
}
    
    class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int [][] ans=new int[mat.length][];
        for(int i=0;i<mat.length;i++){
            ans[i]=new int[mat[i].length];
        }
        ArrayDeque<Pair> q=new ArrayDeque<>();
        int one =0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                int val=mat[i][j];
                if(val==0){
                    ans[i][j]=0;
                    q.offer(new Pair(i,j));
                }
                else{
                    one++;
                }
            }
        }
        int count=1;
        while(one>0&& !q.isEmpty()){
            
            int size=q.size();
            while(one>0&&size>0){
                int i=q.peek().a;
                int j=q.peek().b;
                q.poll();
               if(isValid(mat,i+1,j)){
                    ans[i+1][j]=count;
                    one--;
                    mat[i+1][j]=0;
                    q.offer(new Pair(i+1,j));
                }
                  if(isValid(mat,i-1,j)){
                    one--;
                    
                    mat[i-1][j]=0;
                    ans[i-1][j]=count;
                    q.offer(new Pair(i-1,j));
                }
                  if(isValid(mat,i,j+1)){
                    one--;
                    
                    mat[i][j+1]=0;
                    ans[i][j+1]=count;
                    q.offer(new Pair(i,j+1));
                }
                  if(isValid(mat,i,j-1)){
                    one--;
                    mat[i][j-1]=0;
                    ans[i][j-1]=count;
                    q.offer(new Pair(i,j-1));
                }
                size--;
            }
            count++;
        }
        return ans;
    }
    boolean isValid(int [][] mat,int i,int j){
        if(i>=0&&j>=0&&i<mat.length&&j<mat[i].length&&mat[i][j]==1){
            return true ;
        }
        return false;
    }
}