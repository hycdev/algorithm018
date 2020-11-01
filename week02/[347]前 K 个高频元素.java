//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 

// https://leetcode-cn.com/problems/top-k-frequent-elements/
// 
// 解题思路：
// 用map记录每个元素出现次数
// 以元素出现次数为下标，将对应元素集合存入数组
// 从数组倒序取前k个高频元素
// 
// 时间复杂度：O(n),遍历nums统计元素出现频率的时间复杂度为O(n)，插入排序数组的时间复杂度也为O(n),总的时间复杂度为O(n).  

// 空间复杂度：O(n),没有线性增长

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.putIfAbsent(num, 1);
            if (count != null) map.put(num, count + 1);
        }

        List<Integer>[] table = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (table[count] == null)
                table[count] = new ArrayList<>();
            table[count].add(num);
        }

        int[] result = new int[k];
        for (int i = table.length - 1, j = 0; i >=0 && j < k; i--) {
            if (table[i] != null) {
                for (Integer num : table[i]) {
                    result[j++] = num;
                }
            }
        }

        return result;
    }
}