class Solution {
    public int maxDistance(int[] pos, int m) {
        Arrays.sort(pos);
        int s=1;
        int e=pos[pos.length-1]-pos[0];
        int ans=0;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(isValid(pos,m,mid)){
                s=mid+1;
                ans=mid;
            }
            else{
                e=mid-1;
            }
        }
        return ans;
    }
    boolean isValid(int [] pos,int m,int mid){
        int i=1;
        int j=0;
        int c=1;
        while(i<pos.length){
            if(pos[i]-pos[j]>=mid){
                j=i;
                c++;
            }
            i++;
            if(c==m) return true;
        }
        return false;
    }
}