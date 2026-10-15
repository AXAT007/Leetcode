class Solution {
    public int minAddToMakeValid(String s) {
        
        ArrayDeque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' ) {
                st.push(s.charAt(i));
            } else {
                if (s.charAt(i)==')' &&  !st.isEmpty() && st.peek()=='(' ) {
                    st.pop();
                } 
                 else {
                    st.push(s.charAt(i));
                }
            }
        }
        return st.size() ;
    }
}