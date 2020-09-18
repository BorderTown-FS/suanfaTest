package algorithmProblem;

import java.util.Arrays;

/**
 *  LeetCode第四题
 *  给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *  请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *  你可以假设 nums1 和 nums2 不会同时为空。
 */
public class FindMedianSortedArrays {
    public static void mainFindMedianSortedArrays() {
        int[] nums1 = {-3};
        int[] nums2 = {};
        System.out.println(findMedianSortedArrays2(nums1,nums2));
    }

    /**
     * 归并，合成一个数组然后直接求中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //创建一个新的数组用于合并这两个题干数组
        int[] result=new int[nums1.length+nums2.length];
        System.arraycopy(nums1,0,result,0,nums1.length);
        System.arraycopy(nums2,0,result,nums1.length,nums2.length);
        //传值并得到排序好的数组
        result = merge(result);
        //两个数组相加长度为偶数或者奇数时，中位值取法不同
        return result.length%2==0?(double) (result[result.length/2-1]+result[result.length/2])/2.0:result[result.length/2];
    }

    /**
     * 分割数组
     * @param arr
     * @return
     */
    public static int[] merge(int[] arr){
        //判断数组的长度是否小于2
        if (arr.length < 2) {
            return arr;
        }
        //求数组的中位值
        int middle = (int) Math.floor(arr.length / 2);
        //根据中位值把数组切割成两部分
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        //一直切割下去直到只有一个元素，然后返回开始左右合并排序
        return merge_sort(merge(left),merge(right));
    }

    /**
     * 将两个数组合并排序
     * @param left
     * @param right
     * @return
     */
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

    /**
     * 不需要合并两个有序数组，只要找到中位数的位置即可。由于两个数组的长度已知，
     * 因此中位数对应的两个数组的下标之和也是已知的。维护两个指针，
     * 初始时分别指向两个数组的下标 00 的位置，每次将指向较小值的指针后移一位
     * （如果一个指针已经到达数组末尾，则只需要移动另一个数组的指针），
     * 直到到达中位数的位置。
     * @param nums1
     * @param nums2
     * @return
     * 自己写的漏洞百出的代码
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int the_mid = (nums1.length+nums2.length-2) / 2;
        int numsInt1 = 0,numsInt2 = 0;
        if(nums1.length == 0){
            if(nums2.length%2 == 0){
                return (nums2[the_mid]+nums2[the_mid+1])/2.0;
            }else {
                return nums2[the_mid];
            }
        }else if(nums2.length == 0){
            if(nums1.length%2 == 0){
                return (nums1[the_mid]+nums1[the_mid+1])/2.0;
            }else{
                return nums1[the_mid];
            }
        }
        while(numsInt1 < nums1.length && numsInt2 < nums2.length){
            if(numsInt1 + numsInt2 == the_mid && (nums1.length+nums2.length)%2 == 0){
                return (nums1[numsInt1]+nums2[numsInt2])/2.0;
            }else if(numsInt1 + numsInt2 == the_mid && (nums1.length+nums2.length)%2 != 0){
                return nums1[numsInt1]<nums2[numsInt2]?nums2[numsInt2]:nums1[numsInt1];
            }
            if(nums1[numsInt1] < nums2[numsInt2]){
                numsInt1++;
            }else{
                numsInt2++;
            }
        }

        while(numsInt2 < nums2.length){
            if((numsInt1 - 1) + numsInt2 == the_mid && (nums1.length+nums2.length)%2 == 0){
                return (nums1[numsInt1]+nums2[numsInt2])/2.0;
            }else if((numsInt1-1) + numsInt2 == the_mid && (nums1.length+nums2.length)%2 != 0){
                if(nums1[numsInt1 - 1] < nums2[numsInt2-1]){
                    return nums2[numsInt2];
                }else{
                    return nums1[numsInt1 - 1];
                }
            }
            numsInt2++;
        }

        while(numsInt1 < nums1.length){
            if(numsInt1 + (numsInt2 - 1) == the_mid + 1 && (nums1.length+nums2.length)%2 == 0){
                return (nums1[numsInt1]+nums2[numsInt2])/2.0;
            }else if(numsInt1 + (numsInt2-1) == the_mid + 1 && (nums1.length+nums2.length)%2 != 0){
                if(nums2[numsInt2 - 1] < nums1[numsInt1-1]){
                    return nums1[numsInt1];
                }else{
                    return nums2[numsInt2 - 1];
                }
            }
            numsInt1++;
        }
        return 0.0;
    }

    /**
     * 不需要合并两个有序数组，只要找到中位数的位置即可。由于两个数组的长度已知，
     * 因此中位数对应的两个数组的下标之和也是已知的。维护两个指针，
     * 初始时分别指向两个数组的下标 00 的位置，每次将指向较小值的指针后移一位
     * （如果一个指针已经到达数组末尾，则只需要移动另一个数组的指针），
     * 直到到达中位数的位置。
     * @param A
     * @param B
     * @return
     * 网上别人写的代码
     */
    public static double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0) return (left + right) / 2.0;
        else return right;
    }

    public double standardAnswer(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

/*    public double imitationAnswer(int[] nums1, int[] nums2){
        int n = nums1.length;
        int m = nums2.length;

    }*/
}
