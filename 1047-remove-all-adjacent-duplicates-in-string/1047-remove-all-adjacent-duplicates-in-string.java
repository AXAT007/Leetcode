class Solution {
    public String removeDuplicates(String s) {
        ArrayDeque<Character> stack=new ArrayDeque<>();
        int i=s.length()-1;
        while(i>=0){
            char c=s.charAt(i);
            if(stack.isEmpty()){
                stack.push(c);
                i--;
            }
            else{
                if(stack.peek()!=c){
                    stack.push(c);
                    i--;
                }
                else{
                    stack.pop();
                    i--;

                }
            }
        }
        StringBuilder ans=new StringBuilder();
        int n=stack.size();
        for(  i=0;i<n;i++){
            ans.append(stack.pop());
        }
        return ans.toString();
    }
}