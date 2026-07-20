class Solution {
    public String removeDuplicates(String s) {
        StringBuilder ans=new StringBuilder();
        int i=0;
        while(i<s.length()){
            char c=s.charAt(i);
            int n=ans.length();
            if(n>0&&ans.charAt(n-1)==c){
                ans.deleteCharAt(n-1);
            }
            else{
                ans.append(c);
            }
            i++;
        }
        return ans.toString();
    }
}