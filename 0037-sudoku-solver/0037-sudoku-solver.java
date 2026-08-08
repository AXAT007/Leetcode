class Solution {
    public void solveSudoku(char[][] board) {
        solver(board,0,0);
    }
    boolean solver(char[][] board,int row,int col){
        if(row==board.length||  col==board[row].length&& row==board.length-1){
            return true;
        }
        if(col==board[row].length){
            col=0;
            row+=1;
        }
        
        if(board[row][col]!='.'){
            if(solver(board,row,col+1)){
                return true;
            }
        }
        else{
            for(char c='1';c<='9';c++){
                if(isValid(board,row,col,c)){
                    board[row][col]=c;
                     if(solver(board,row,col+1)){
                        return true;
                    }

                    board[row][col]='.';
                }
            }
        }
        return false;
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