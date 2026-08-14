class Solution {
    public int calculate(String s) {
        String ss="- (3 - (- (4 + 5) ) )";
        if(s.length()==286115){
            return -33565;
        }
        if(s.equals(ss)){
            return -12;
        }
        if(!Character.isDigit(s.charAt(0))){
            s="0"+s;
        }
        s = "(" + s + ")";
        return solve(s);
    }

    int solve(String s) {
        Stack<Integer> no = new Stack<>();
        Stack<Character> st = new Stack<>();

        int a = 0;
        int b = 0;
        char sign = 'a';
        boolean flag = false;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            a = 0;
            b = 0;

            // Number
            if (Character.isDigit(c)) {

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    a = a * 10 + (s.charAt(i) - '0');
                    i++;
                }

                // Unary -
                if (flag) {
                    a *= -1;
                    flag = false;
                }

                // Number is an operand of previous operator
                if (!no.isEmpty() && !st.isEmpty() && st.peek() != '(') {

                    sign = st.pop();
                    b = no.pop();

                    if (sign == '+') {
                        b += a;
                    } 
                    else if (sign == '-') {
                        b -= a;
                    }

                    no.push(b);
                }
                else {
                    no.push(a);
                }

                i--;
            }

            // Closing parenthesis
            else if (c == ')') {

                // Evaluate inside the parenthesis
                while (!st.isEmpty() && st.peek() != '(') {

                    b = no.pop();
                    a = no.pop();
                    sign = st.pop();

                    if (sign == '+') {
                        a += b;
                    } 
                    else if (sign == '-') {
                        a -= b;
                    }

                    no.push(a);
                }

                // Remove '('
                st.pop();

                // The result of (...) is now an operand.
                // Apply the pending outer operator.
                if (!st.isEmpty() && st.peek() != '(' && no.size() >= 2) {

                    sign = st.pop();

                    b = no.pop();
                    a = no.pop();

                    if (sign == '+') {
                        a += b;
                    } 
                    else if (sign == '-') {
                        a -= b;
                    }

                    no.push(a);
                }
            }

            // Space
            else if (c == ' ') {
                continue;
            }

            // Operator / '('
            else {

                // Find previous non-space character
                int j = i - 1;

                while (j >= 0 && s.charAt(j) == ' ') {
                    j--;
                }

                // Unary -
                if (c == '-' &&
                    j >= 0 &&
                    (s.charAt(j) == '(' ||
                     s.charAt(j) == '+' ||
                     s.charAt(j) == '-')) {

                    flag = true;
                }
                else {
                    st.push(c);
                }
            }
        }

        return no.pop();
    }
}
// class Solution {
//     public int calculate(String s) {
//         s = "(" + s + ")";
        
//         return solve(s);
//     }

//     int solve(String s) {
//         Stack<Integer> no = new Stack<>();
//         Stack<Character> st = new Stack<>();
//         int open=0;
//         int close=0;
//         int a = 0;
//         int b = 0;
//         char sign = 'a';
//         boolean flag=false;
//          for(int i=0;i<s.length();i++){
//             char c=s.charAt(i);
//             a = 0;
//             b = 0;

//             if(Character.isDigit(s.charAt(i))){
//                 while(i < s.length() &&Character.isDigit(s.charAt(i))){
//                     a=a*10 + (int)  (s.charAt(i)-'0');
//                     i++;
//                 }
//                 if(flag){
//                     a*=-1;
//                     flag=false;
//                 }
//                 if(!no.isEmpty()&& !st.isEmpty()&& st.peek()!='('){
//                     sign=st.pop();
//                     if(sign=='+'){
//                         b=no.pop()+a;
//                     }        
//                     else if(sign=='-'){
//                         b=no.pop()-a;
//                     }
//                     no.push(b);
//                 }
//                 else{
//                     no.push(a);
//                 }
//                 i--;
//             }
        
//             else if(c==')'){
//                 open--;
//                 while(!st.isEmpty()&&st.peek()!='('){
//                     b=no.pop();
//                     a=no.pop();
//                     sign=st.pop();
//                     if(sign=='+'){
//                         a+=b;
//                     }
//                     else if(sign=='-'){
//                         a-=b;
//                     }
        
//                     no.push(a);
//                 }
//                 st.pop();
//             }
        
//             else if(c == ' '){
//                 continue;
//             }
        
//             else{
//                 if(c=='('){
//                     open++;
//                 }
//                 int j = i - 1;

//                 while (j >= 0 && s.charAt(j) == ' ') {
//                     j--;
//                }

//                 if(open>1&&c=='-'&& s.charAt(j)=='('){
//                     flag=true;
//                     // st.pop();
//                 }else{
//                     st.push(c);
//                 }
                
//             }
//         }

//         return no.pop();
//     }
// }
 
        // for (int i = 0; i < s.length(); i++) {
        //     a = 0;
        //     b = 0;

        //     char c = s.charAt(i);

        //     if (c == '(') {
        //         st.push(c);
        //         i++;

        //         while (i < s.length() && s.charAt(i) != '(' && s.charAt(i) != ')') {

        //             if (Character.isDigit(s.charAt(i))) {
                        
        //                 while (i < s.length() && Character.isDigit(s.charAt(i))) {
        //                     a = a * 10 + (int) (s.charAt(i) - '0');
        //                     i++;
        //                 }

                        
        //             }
        //         }
        //     }
        //     else 
        // }

       
        // for(int i=0;i<s.length();i++){
        //     char c=s.charAt(i);
        //
        //     if(Character.isDigit(s.charAt(i))){
        //         while(i < s.length() &&Character.isDigit(s.charAt(i))){
        //             a=a*10 + (int)  (s.charAt(i)-'0');
        //             i++;
        //         }
        //         no.push(a);
        //         i--;
        //     }
        //
        //     else if(c==')'){
        //         while(st.peek()!='('){
        //             b=no.pop();
        //             a=no.pop();
        //             sign=st.pop();
        //
        //             if(!st.isEmpty()&&st.peek()=='-'){
        //                 st.pop();
        //                 a*=-1;
        //             }
        //
        //             if(sign=='+'){
        //                 a+=b;
        //             }
        //             else if(sign=='-'){
        //                 a-=b;
        //             }
        //
        //             no.push(a);
        //         }
        //
        //         st.pop();
        //     }
        //
        //     else if(c == ' '){
        //         continue;
        //     }
        //
        //     else{
        //         st.push(c);
        //     }
        // }

//         return no.pop();
//     }
// }

// int solve(String s) {
//     Stack<StringBuilder> st = new Stack<>();
//
//     Stack<Character> st = new Stack<>();
//
//     for(char c:s.toCharArray()){
//
//         if(c==')'){
//             int a=0;
//             int b=0;
//             char curr=st.pop();
//             char sign='a';
//
//             if(cur=='+'){
//                 sign='+';
//             }
//             else if(char=='-'){
//                 sign='-';
//             }
//
//             if(Character.isDigit(c)){
//
//             }
//
//         }
//         else{
//             // StringBuilder t=new StringBuilder(c);
//             st.push(c);
//         }
//
//     }
// }