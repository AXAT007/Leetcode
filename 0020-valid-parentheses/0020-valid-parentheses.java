class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            } else {
                if (s.charAt(i)==')' &&  !st.isEmpty() && st.peek()=='(' ) {
                    st.pop();
                }
                else if (s.charAt(i)==']' &&  !st.isEmpty() &&st.peek()=='[' ) {
                    st.pop();
                }
                else if (s.charAt(i)=='}'  && !st.isEmpty() && st.peek()=='{' ) {
                    st.pop();
                }
                 else {
                    st.push(s.charAt(i));
                }
            }
        }
        return st.size() == 0;
    }
}