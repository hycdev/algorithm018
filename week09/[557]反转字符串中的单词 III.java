//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 字符串 
class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j;
        for (int k = 0; k <= chars.length; k++) {
            if (k == chars.length || chars[k] == ' ' ) {
                j = k - 1;
                // swap
                while (i < j) {
                    char tmp = chars[i];
                    chars[i++] = chars[j];
                    chars[j--] = tmp;
                }
                i = k + 1;
            }
        }
        return new String(chars);
    }
}