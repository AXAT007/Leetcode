class Solution {

    // this lines makes the jit warm up 
    //  static{
    //     for(int i=1;i<10000;i++)removeDuplicates("");
    // }
    public static String removeDuplicates(String s) {
        return stack(s);    
    }

    static String stack(String s){
        ArrayDeque<Character> st=new ArrayDeque<>();
        for(int i=s.length()-1;i>=0;i--){
            if(!st.isEmpty() && s.charAt(i) == st.peek()){
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder(st.size()); // Initial capacity: 100
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.toString();
    }
}