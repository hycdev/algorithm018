//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 

//https://leetcode-cn.com/problems/group-anagrams/

// 解决思路:
// 当且仅当它们的排序字符串相等时，两个字符串是字母异位词
// 
// 时间复杂度:
// O(NKlogK))，其中 N 是 strs 的长度，而 K 是 strs 中字符串的最大长度。
// 当我们遍历每个字符串时，外部循环具有的复杂度为 O(N)。然后，我们在 O(Klog K) 的时间内对每个字符串排序。

// 
// 空间复杂度:
// O(NK)，排序存储在 ans 中的全部信息内容。

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!result.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                result.put(key, list);
            } else {
                result.get(key).add(strs[i]);
            }
        }
        return new ArrayList<>(result.values());
    }
}
