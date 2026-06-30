//  import java.util.*;
// import java.util.stream.*;

 
// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         List<List<String>> ans=Arrays.stream(strs);
//                 .collect(Collectors.groupingBy(word ->{
//                     char [] c=word.toCharArray();
//                     Arrays.sort(c);
//                     return new String(c);
//                 }))
//                 .values()
//                 .stream()
//                 .toList();
//         return ans;
//    }
// }
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        return Arrays.stream(strs)
                .collect(Collectors.groupingBy(word -> {
                    char[] c = word.toCharArray();
                    Arrays.sort(c);
                    return new String(c);
                }))
                .values()
                .stream()
                .toList();
    }
}