class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[0] ,b[0]) );
        int j=0;
        int [] temp=points[0];
        int count=1;

        for(int i=1;i<points.length;i++){
            if(temp[1]<points[i][0]){
                count++;
                temp=points[i];
            }
            else{
                temp[0]=Math.max(temp[0],points[i][0]);
                temp[1]=Math.min(temp[1],points[i][1]);
            }
        }
        return count;
    }
}