package algorithm.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 示例1：
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 *
 * 示例2：
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 * */
public class CountCharacters {

    public static void main(String[] args) {
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";
        int result = countCharacters(words, chars);
        System.out.println(result);
    }

    public static int countCharacters(String[] words, String chars) {
        int result = 0;
        Map<Character, Integer> charsMap = new HashMap<>();
        for (char c : chars.toCharArray()) {
            charsMap.put(c, charsMap.getOrDefault(c, 0) + 1);
        }

        for (String word : words) {
            Boolean flag = true;
            Map<Character, Integer> wordsMap = new HashMap<>();
            for (char w : word.toCharArray()) {
                wordsMap.put(w, wordsMap.getOrDefault(w, 0) + 1);
                if (!charsMap.containsKey(w) || wordsMap.get(w) > charsMap.get(w)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result = result + word.length();
            }
        }
        return result;
    }
}
