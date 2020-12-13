学习笔记

## 选择排序

. 寻找最小值放到待排序数组的起始位置

```
    public static void selectionSort(int[] array) {
        int len = array.length;
        int minIndex, temp;
        for (int i = 0 ; i < len - 1; i++) {
            minIndex = i;

            // 寻找最小数
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[minIndex])
                    minIndex = j;
            }

            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;

        }
    }

```

## 插入排序

. 从前到后逐步构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入

```
    public static void insertionSort(int[] array) {
        int cur, preIndex;
        for (int j = 1; j < array.length; j++) {
            cur = array[j];
            preIndex = j - 1;
            while (preIndex >= 0 && array[preIndex] > cur) {
                array[preIndex + 1] = array[preIndex--];
            }
            array[preIndex + 1] = cur;
        }
    }
```

## 冒泡排序

. 嵌套循环，每次查看相邻的的元素，如果逆序则交换。
. 越小的元素会经由交换，慢慢浮到数列的顶端。

```
    public static void bubbleSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

```
