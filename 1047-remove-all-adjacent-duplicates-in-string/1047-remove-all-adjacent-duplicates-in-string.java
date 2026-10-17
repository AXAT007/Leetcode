class Solution {

    // this lines makes the jit warm up 
    //  static{
    //     for(int i=1;i<10000;i++)removeDuplicates("");
    // }
    public static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder(s.length()); // Initial capacity: 100
        int i = 0;
        // sb.append(s.charAt(0));
        while (i < s.length()) {
            if (sb.length() > 0 && s.charAt(i) == sb.charAt(sb.length() - 1)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(s.charAt(i));
            }
            i++;
        }
        return sb.toString();

        // return stack(s);    
    }

    static String stack(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!st.isEmpty() && s.charAt(i) == st.peek()) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder(st.size()); // Initial capacity: 100
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.toString();
    }
}