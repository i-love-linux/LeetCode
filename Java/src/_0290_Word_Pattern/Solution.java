package _0290_Word_Pattern;

import java.util.HashMap;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strArray = str.split(" ");  // 分割字符串

        if (pattern.length() != strArray.length)
            return false;

        HashMap<Character, String> hashMap1 = new HashMap<>();
        HashMap<String, Character> hashMap2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            if (!hashMap1.containsKey(pattern.charAt(i)))  // 不包含键值对(pattern[i], strArray[i])
                hashMap1.put(pattern.charAt(i), strArray[i]);
//            else if (hashMap.get(pattern.charAt(i)) != strArray[i])  // 包含键值对(pattern[i], strArray[i])，但不匹配
            else if (!hashMap1.get(pattern.charAt(i)).equals(strArray[i]))   // 包含键值对(pattern[i], strArray[i])，但不匹配
                return false;

            if (!hashMap2.containsKey(strArray[i]))
                hashMap2.put(strArray[i], pattern.charAt(i));
            else if (!hashMap2.get(strArray[i]).equals(pattern.charAt(i)))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).wordPattern("abba", "dog cat cat dog"));
        System.out.println((new Solution()).wordPattern("abba", "dog cat cat fish"));
        System.out.println((new Solution()).wordPattern("aaaa", "dog cat cat dog"));
        System.out.println((new Solution()).wordPattern("abba", "dog dog dog dog"));
    }
}