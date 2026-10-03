class Solution {
    public String majorityFrequencyGroup(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            arr[c - 'a']++;
        }
        HashMap<Integer, String> freq = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int x = entry.getValue();
            if (!freq.containsKey(x)) {
                freq.put(x, "" + c);
            } else {
                freq.put(x, freq.get(x) + c);
            }
        }
        Map.Entry<Integer, String> ans = null;
        for (Map.Entry<Integer, String> entry : freq.entrySet()) {
            if (ans == null) {
                ans = entry;
            } else {
                if (ans.getValue().length() < entry.getValue().length()) {
                    ans = entry;
                } else if (ans.getValue().length() == entry.getValue().length()) {
                    if (ans.getKey() < entry.getKey()) {
                        ans = entry;
                    }
                }
            }
        }
        return ans.getValue();
    }
}