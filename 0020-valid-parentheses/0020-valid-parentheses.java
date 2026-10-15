// class Solution {
//     public boolean isValid(String s) {
//         ArrayDeque<Character> st = new ArrayDeque<>();
//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
//                 st.push(s.charAt(i));
//             } else {
//                 if (s.charAt(i)==')' &&  !st.isEmpty() && st.peek()=='(' ) {
//                     st.pop();
//                 }
//                 else if (s.charAt(i)==']' &&  !st.isEmpty() &&st.peek()=='[' ) {
//                     st.pop();
//                 }
//                 else if (s.charAt(i)=='}'  && !st.isEmpty() && st.peek()=='{' ) {
//                     st.pop();
//                 }
//                  else {
//                     st.push(s.charAt(i));
//                 }
//             }
//         }
//         return st.size() == 0;
//     }
// }
class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {

                if (st.isEmpty()) {
                    return false;
                }
                char top = st.peek();

                if (ch == ')' && top != '(') {
                    return false;

                } else if (ch == ']' && top != '[') {
                    return false;
                } else if (ch == '}' && top != '{') {
                    return false;
                } else {
                    st.pop();
                }
            }
        }

        return st.isEmpty();
    }
}