class Solution {
    public String decodeString(String s) {
        String ss="1["+s+"]";
        return solve(ss).toString();
    }
    StringBuilder solve(String s) { 
    Stack<StringBuilder> st = new Stack<>();

    for (char c : s.toCharArray()) {
        

        if (c == ']') {
            StringBuilder curr = new StringBuilder();
             StringBuilder t = new StringBuilder();
            while (!st.isEmpty()&&st.peek().charAt(0) !='[') {
                t.insert(0,st.pop());
            }
            st.pop();

            int count = 0;
            int dec=1;
            while(!st.isEmpty()&&st.peek().charAt(0)>='0'&&st.peek().charAt(0)<='9'){
                int temp=(int)(st.pop().charAt(0)-'0');
                temp*=dec;
                count+=temp;
                dec*=10;
            }
            // curr.reverse();
            while (count > 0) {
                curr.append(t);
                count--;
            }
            st.push(curr);
        }
        else {
            st.push(new StringBuilder(String.valueOf(c)));
        }
    }
        return st.pop();
    }
}