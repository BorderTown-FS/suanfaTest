package algorithm;

import java.util.Arrays;

/**
 归并排序
 平均时间复杂度：O(nlogn)
 最佳时间复杂度：O(n)
 最差时间复杂度：O(nlogn)
 空间复杂度：O(n)
 排序方式：In-place
 稳定性：稳定

 归并排序是用分治思想，分治模式在每一层递归上有三个步骤：
 分解（Divide）：将n个元素分成个含n/2个元素的子序列。
 解决（Conquer）：用合并排序法对两个子序列递归的排序。
 合并（Combine）：合并两个已排序的子序列已得到排序结果。
 */
public class MergeSort {
    public static void mainMergeSort(){
        int[] arr = {0, 3, 2, 5, 1, -5, 9, 7, 21, -15, 10, -11, 31, 13};
        int[] arrBegin = Arrays.copyOf(arr, arr.length);
        int[] arrEnd = merge(arrBegin);
        for (int i = 0; i < arrEnd.length; ++i) {
            System.out.println(arrEnd[i]);
        }
    }

    public static int[] merge(int[] arr){
        if (arr.length < 2) {
            return arr;
        }
        int middle = (int) Math.floor(arr.length / 2);
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        return merge_sort(merge(left),merge(right));
    }

    private static int[] merge_sort(int[] left, int[] right){
        int[] arr = new int[left.length+right.length];
        int i = 0,j = 0,k = 0;
        while(left.length > i && right.length > j){
            if(left[i] < right[j]){
                arr[k++] = left[i++];
            }else{
                arr[k++] = right[j++];
            }
        }
        while(left.length > i){
            arr[k++] = left[i++];
        }
        while(right.length > j){
            arr[k++] = right[j++];
        }
        return arr;
    }
}
