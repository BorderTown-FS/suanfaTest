package algorithmProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 16. 最接近的三数之和
 给定一个包括 n 个整数的数组nums和
 一个目标值target。找出nums中的三个整数，
 使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 */
public class ApproachTheSum {
    public static void mainApproachTheSum() {
        int[] rom = {-1,2,1,-4};
        int target = 2;
        System.out.println("结果为："+new ApproachTheSum().threeSum(rom,target));
    }

    public int threeSum(int[] nums,int target) {
        int n = nums.length;
        int best = 1000000;
        Arrays.sort(nums);
        for(int first = 0;first<n;first++){
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = n - 1;
            int second = first+1;
            while(second < third){
                int endResult = nums[first] + nums[second] + nums[third];
                if(endResult == target){
                    return target;
                }
                if (Math.abs(endResult - target) < Math.abs(best - target)) {
                    best = endResult;
                }
                if (endResult > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = third - 1;
                    // 移动到下一个不相等的元素
                    while (second < k0 && nums[k0] == nums[third]) {
                        --k0;
                    }
                    third = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = second + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < third && nums[j0] == nums[second]) {
                        ++j0;
                    }
                    second = j0;
                }
            }
        }
        return best;
    }
}
