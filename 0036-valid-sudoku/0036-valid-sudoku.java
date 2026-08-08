class Solution {
    public boolean isValidSudoku(char[][] board) {
     for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){
            if(board[i][j]!='.'){
                char c=board[i][j];
                board[i][j]='.';
                if(!isValid(board,i,j,c)){
                    return false;
                }
                board[i][j]=c;
            }
        }
     }
     return true;   
    }
    boolean isValid(char[][] board,int row,int col,char c){
        for(int i=0;i<9;i++){
            if(board[row][i]==c||board[i][col]==c ){
                return false;
            }
        }
        for(int i=row/3*3;i<row/3*3+3;i++){
            for(int j=col/3*3;j<col/3*3+3;j++){
                if(board[i][j]==c){
                    return false;
                }
            }
        }
        return true;
    }
}