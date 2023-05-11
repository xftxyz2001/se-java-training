package leetcode.p1002;

class Solution {

    // public List<String> commonChars(String[] words) {
    //     Map<Character, Integer> map = new HashMap<>(26);
    //     for (int i = 0; i < 26; i++) {
    //         map.put((char) ('a' + i), Integer.MAX_VALUE);
    //     }
    //     for (int i = 0; i < words.length; i++) {
    //         Map<Character, Integer> map2 = new HashMap<>();
    //         for (int j = 0; j < words[i].length(); j++) {
    //             map2.put(words[i].charAt(j), map2.getOrDefault(words[i].charAt(j), 0) + 1);
    //         }
    //         for (Map.Entry<Character, Integer> e : map.entrySet()) {
    //             if (map2.getOrDefault(e.getKey(), 0) < e.getValue()) {
    //                 map.put(e.getKey(), e.getValue());
    //             }
    //         }
    //     }
    //     List<String> res = new ArrayList<>();
    //     for (Map.Entry<Character, Integer> e : map.entrySet()) {
    //         for (int i = 0; i < e.getValue(); i++) {
    //             res.add(e.getKey() + "");
    //         }
    //     }
    //     return res;
    // }
}