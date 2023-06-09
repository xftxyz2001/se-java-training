/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * 
 *  
 * 
 * 示例 1：
 * 
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为5。
 * 示例 2：
 * 
 * 输入：s = " fly me to the moon "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为4。
 * 示例 3：
 * 
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * 解释：最后一个单词是长度为6的“joyboy”。
 *  
 * 
 * 提示：
 * 
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 * s 中至少存在一个单词
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int lengthOfLastWord1(String s) {
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }

    public int lengthOfLastWord2(String s) {
        s = s.trim();
        int lastIndexOfSpace = s.lastIndexOf(" ");
        return s.length() - lastIndexOfSpace - 1;
    }

    public int lengthOfLastWord3(String s) {
        char[] charArray = s.toCharArray();
        int count = 0;
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (charArray[i] == ' ') {
                if (count > 0) {
                    return count;
                } else {
                    count = 0;
                }
            } else {
                count++;
            }
        }
        return count;
    }

    public int lengthOfLastWord4(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (count > 0) {
                    return count;
                } else {
                    count = 0;
                }
            } else {
                count++;
            }
        }
        return count;
    }

    // 官方
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        int wordLength = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            wordLength++;
            index--;
        }
        return wordLength;
    }

}