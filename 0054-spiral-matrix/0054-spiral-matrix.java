class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

int row = 0, col = 0;
int n = matrix.length-1;
int m = matrix[0].length-1;

while (row <= n && col <= m) {
    for(int i=col;i<=m;i++){
        list.add(matrix[row][i]);
        // matrix[row][i]=101;
    }
    row++;
    for(int i=row;i<=n;i++){
    list.add(matrix[i][m]);
        // matrix[i][m]=101;
    }
    m--;
        if(row<=n){
    for(int i=m;i>=col;i--){
        list.add(matrix[n][i]);
        // matrix[n][i]=101;
    }}
    n--;
if(col<=m){
    for(int i=n;i>=row;i--){
        list.add(matrix[i][col]);
        // matrix[i][col]=101;
    }}
    col++;
}
        return list;
    }
}