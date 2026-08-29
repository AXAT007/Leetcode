class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        char bcol='a';
        char tcol='a';
        if((source[0] + source[1]) %2 != (target[0]+target[1])%2 ){ return -1;}
        if(Math.abs(source[0]-target[0])==Math.abs(source[1]-target[1])) return 1;
        return 2;
        
        // if((source[0]%2==0 &&source[1]%2==0 )|| (source[0]%2==1 &&source[1]%2==1 ) ){
        //      bcol='W';
        // }
        
        // if((target[0]%2==0 &&target[1]%2==0 )|| (target[0]%2==1 &&target[1]%2==1 ) ){
        //       tcol='W';
        // }

        // if(bcol!=tcol) return -1;

        // int lvl=1;
        // while(true){
        // int rows=source[0];
        // int cols=source[1];
        // int rowe=target[0];
        // int cole=target[1];

        //     if(dia(rows,cols,rowe,cole)) return lvl;
        // }
    }

    // boolean dia(int rs,int cs,int re,int ce ){
    //     int tr=rs;
    //     int tc=cs;
    //     if(rs>re ){
            
    //     while(tr<=re && tc<=ce){
    //          if(tr==re && tc==ce ){
    //              return true;
    //          }
            
    //     }
    //     }
    // }
}