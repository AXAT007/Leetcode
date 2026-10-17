class Solution {
    public boolean backspaceCompare(String s, String t) {
        ArrayDeque<Character> st=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='#')
            {
               if(!st.isEmpty()) st.pop();
            }
            else{
                st.push(c);
            }
        }
        StringBuilder sb1=new StringBuilder();
        while(!st.isEmpty()){
            sb1.append(st.pop());
        }
        // sb1.reverse();
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            if(c=='#' ){
                if(!st.isEmpty()) st.pop();
            }
            else{
                st.push(c);
            }
        }
        StringBuilder sb2=new StringBuilder();
        while(!st.isEmpty()){
            sb2.append(st.pop());
        }
        // sb2.reverse();
        // System.out.println(sb1);
        // System.out.println(sb2);
        return (sb1.toString().equals(sb2.toString()));
    }
}