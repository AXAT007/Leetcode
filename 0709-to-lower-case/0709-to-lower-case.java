class Solution {
    public String toLowerCase(String s) {
StringBuilder sb=new StringBuilder();

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c<='Z' && c>='A') sb.append((char)(c-'A'+'a'));
            else sb.append(c);
        }
 return sb.toString();
    }
}