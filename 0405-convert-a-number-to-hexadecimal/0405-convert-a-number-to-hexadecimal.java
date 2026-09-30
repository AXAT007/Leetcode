class Solution {
    public String toHex(int num) {
        int hex = 0;
        int i = 0;
        if(num==0) return "0";
        
        long x=num;
        if(num<0){
             x=(long) Math.pow(2,32)+num;
        }
        char[] arr = new char[8];
        for (i = 7; i >= 0; i--) {
            if (x == 0)
                break;
            long rem = x % 16;
            x /= 16;
            char c = getC(rem);
            arr[i] = c;

        }
        String s = "";

        for (i = i + 1; i < 8; i++) {

            s += arr[i];
        }
        return s;
    }

    char getC(long r) {
        if (r < 10)
            return (char) ('0'+r);
        return (char) ('a' - 10 + r);
    }
}