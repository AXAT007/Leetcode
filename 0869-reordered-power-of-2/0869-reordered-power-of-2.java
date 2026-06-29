class Solution {
    public boolean reorderedPowerOf2(int n) {
        int pow=1;
        List<String> list=new ArrayList<>();
        do{
            char[] c1=Integer.toString(pow).toCharArray();
            Arrays.sort(c1);
            String s1=new String(c1); 
            list.add(s1);
            pow*=2;
        }
        while(pow<=Integer.MAX_VALUE&&pow>0);
        
        String curr=Integer.toString(n);
        char[] c=curr.toCharArray();
        Arrays.sort(c);
        String s=new String(c);
        return list.contains(s);
    }
}