class Solution {
    public boolean checkValid(int[][] matrix) {
        int n=matrix.length;
        // int sum=n*(n+1)/2;
       
        int sum1=0;
        int sum2=0;
        for(int i=1;i<=n;i++){
            sum1^=i;
            sum2^=i;
        }
        for(int i=0;i<matrix.length;i++){
            // int curr1=0;
            // int curr2=0;
             HashSet<Integer> set1=new HashSet<>();
        HashSet<Integer> set2=new HashSet<>();
            int curr1=sum1;
            int curr2=sum2;
            for(int j=0;j<matrix[i].length;j++){
                if(!set1.add(matrix[i][j])||!set2.add(matrix[j][i])){
                    return false;
                }
                curr1^=matrix[i][j];
                curr2^=matrix[j][i];
            }
            // if(curr1!=sum||curr2!=sum){
            //     return false;
            // }
            if(curr1!=0||curr2!=0){
                return false;
            }
        }
        return true;
    }
}