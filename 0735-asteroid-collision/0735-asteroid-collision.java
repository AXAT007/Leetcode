class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> st=new ArrayDeque<>();
        int i=0;
        while(i<asteroids.length){
            int x=asteroids[i];
            if(st.isEmpty()) {
                st.push(x);
                i++;
            }
            else{
                int y=st.peek();
                
                // both +
                
                if((y>0&&x>0 )|| y<0 || (y<0&&x<0)){
                    st.push(x);
                    i++;
                }


                // +,-
                else {
                // + == -
                    if(x==y*-1){
                        st.pop();
                        i++;
                    }

                    // st has + a
                    else if(x*-1>y){
                        st.pop();
                        // st.push(x);
                    } 
                    else{
                        i++;
                    }
                }
            }
        }
          i=st.size()-1;
        int [] ans=new int[st.size()];
        while(!st.isEmpty()){
            ans[i--]=st.pop();
        }
        return ans;
    } 
}
