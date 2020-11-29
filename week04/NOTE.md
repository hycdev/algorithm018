学习笔记

## 二分查找
每次通过跟区间中的中间元素对比，将待查找的区间缩小为一半，直到找到要查找的元素，或者区间被缩小为0。

## 贪心算法


## 使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

### 解题思路

. 要查找的元素大于前一个元素并且小于后一个元素。
. 如果中间元素比最后一个元素大，说明目标元素在中间元素之后，否则在中间元素之前。

```
public int searchFirst(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (mid > 0 && nums[mid] < nums[mid - 1] && (mid == nums.length - 1 || nums[mid] < nums[mid + 1]))
                return mid;
            else if (nums[mid] > nums[nums.length - 1])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
```