//���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ����ĸ��λ�ʡ� 
//
// ʾ�� 1: 
//
// ����: s = "anagram", t = "nagaram"
//���: true
// 
//
// ʾ�� 2: 
//
// ����: s = "rat", t = "car"
//���: false 
//
// ˵��: 
//����Լ����ַ���ֻ����Сд��ĸ�� 
//
// ����: 
//��������ַ������� unicode �ַ���ô�죿���ܷ������Ľⷨ��Ӧ����������� 
// Related Topics ���� ��ϣ�� 

//https://leetcode-cn.com/problems/valid-anagram/
// 
// ���˼·:
// �����ж������ַ��������Ƿ���ȣ��������ֱ�ӷ��� false
// ����ȣ����ʼ�� 26 ����ĸ��ϣ�������ַ��� s �� t, s �����ڶ�Ӧλ�����ӣ�t �����ڶ�Ӧλ�ü���
// �����ϣ���ֵ��Ϊ 0�����������ĸ��λ��
// 
// ʱ�临�Ӷ�:O(n),���ʼ���������һ���̶���ʱ�����
// 
// �ռ临�Ӷ�:O(1),��������ʹ���˶���Ŀռ䣬���ǿռ�ĸ������� O(1)O(1)����Ϊ���� NN �ж�󣬱�Ĵ�С�����ֲ��䡣

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int[] table = new int[26];

        for (char c : sChars)
            table[c - 'a']++;
        for (char c : tChars)
            table[c - 'a']--;

        for (int value : table)
            if (value != 0)
                return false;

        return true;
    }
}