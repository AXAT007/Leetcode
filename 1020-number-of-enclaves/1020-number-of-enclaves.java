class Pair{ 
    int a; 
    int b; 
    Pair(int x,int y){ 
        a=x; 
        b=y; 
    } 
} 
     
class Solution { 
 
    public int numEnclaves(int[][] grid) { 
        int one=0; 
        Queue<Pair> q=new LinkedList<>(); 

        for(int i=0;i<grid.length;i++){ 
            for(int j=0;j<grid[i].length;j++){ 
                if(grid[i][j]==1){ 
                    one++; 
                } 
            } 
        } 

        for(int i=0;i<grid.length;i++){ 
          
            if(grid[i][0]==1){ 
                one--; 
                q.offer(new Pair(i,0)); 
                grid[i][0]=-1; 
            } 
                 
            if(grid[i][grid[i].length-1]==1){ 
                one--; 
                q.offer(new Pair(i,grid[i].length-1)); 
                grid[i][grid[i].length-1]=-1; 
            } 
                 
        } 

        for(int i=0;i<grid[0].length;i++){ 
          
            if(grid[0][i]==1){ 
                grid[0][i]=-1; 
                one--; 
                q.offer(new Pair(0,i)); 
            } 

            if(grid[grid.length-1][i]==1){ 
                one--; 
                grid[grid.length-1][i]=-1; 
                q.offer(new Pair(grid.length-1,i)); 
            } 
        } 
         
        while(!q.isEmpty()){ 
            int i=q.peek().a; 
            int j=q.peek().b; 
            q.poll(); 
            
            if(isVlaid(i+1,j,grid)){ 
                q.offer(new Pair(i+1,j));
              one--; 
                grid[i+1][j]=-1;     
              
            } 

            if(isVlaid(i-1,j,grid)){
              one--; 
                
                grid[i-1][j]=-1;  
                q.offer(new Pair(i-1,j)); 
            } 

            if(isVlaid(i,j+1,grid)){ 
              one--; 
                grid[i][j+1]=-1;  
                
                q.offer(new Pair(i,j+1)); 
            } 

            if(isVlaid(i,j-1,grid)){ 
              one--;
                grid[i][j-1]=-1;  
                q.offer(new Pair(i,j-1)); 
            } 
        }  
         
        return one; 
         
    } 

    boolean isVlaid(int i,int j,int[][] grid){ 
        return i>0 && j>0 && i<grid.length-1 && j<grid[i].length-1 && grid[i][j]==1; 
    } 
}