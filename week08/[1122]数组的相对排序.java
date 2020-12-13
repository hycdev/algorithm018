//给你两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 
//输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
// Related Topics 排序 数组 
    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            // x,y都在arr2中，则比较x,y在arr2中的下标
            // x,y都不在arr2中，则比较x,y本身
            // x,y只有一个在arr2中，出现在arr2中的那个元素较小

            Map<Integer, Integer> indexs = new HashMap<>();
            for (int i = 0; i < arr2.length; i++)
                indexs.put(arr2[i], i);

            List<Integer> list = Arrays.stream(arr1).boxed().collect(Collectors.toList());
            list.sort((x, y) -> {
                if (indexs.containsKey(x))
                    return indexs.containsKey(y) ? indexs.get(x) - indexs.get(y) : -1;
                else
                    return indexs.containsKey(y) ? 1 : x - y;
            });

            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }