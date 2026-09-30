class Solution {
    public boolean isSubsequence(String s, String t) {
        // for(int i=0;i<s.length;i++){
        //     if(is(s,t,)){

        //     }
        // }
if(s.length()==0) return true;;
        int j=0;
        for(int i=0;i<t.length();i++){
            if(s.charAt(j)==t.charAt(i)){
                j++;
            }
            if(j==s.length()) return true;
        }
        return false;
    }
    // boolean is(String s,String t,int i,int j){
    //     if(i==t.length()&& j!=s.length()) return false;

    //     if()
    // }
}