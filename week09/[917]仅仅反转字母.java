//给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入："ab-cd"
//输出："dc-ba"
// 
//
// 示例 2： 
//
// 输入："a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
// 
//
// 示例 3： 
//
// 输入："Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 提示： 
//
// 
// S.length <= 100 
// 33 <= S[i].ASCIIcode <= 122 
// S 中不包含 \ or " 
// 
// Related Topics 字符串 
class Solution {
    public String reverseOnlyLetters(String S) {

        char[] chars = S.toCharArray();
        int k = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (c >= 'a' && c <='z' || c>='A'  && c <= 'Z') {
                while (k < chars.length) {
                    char target = chars[k];
                    if (target >= 'a' && target <='z' || target>='A'  && target <= 'Z') {
                        chars[k++] = c;
                        break;
                    }
                    k++;
                }
            }
        }

        return new String(chars);
    }
}