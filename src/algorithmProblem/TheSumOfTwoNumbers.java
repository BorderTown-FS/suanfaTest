package algorithmProblem;
import	java.util.HashMap;

import java.util.Map;

/**
 * LeetCode第一题
   给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出
   和为目标值的那 两个 整数，并返回他们的数组下标。
 */
public class TheSumOfTwoNumbers {
    public static void mainTheSumOfTwoNumbers() {
        int[] nums={3,1,5,9,13,16};
        //int[] nums1 = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int target=29;
        /*int[] result = twoSum(nums,target);
        System.out.print("乱序情况下标为：");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
        System.out.print("顺序情况下标为：");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }*/
        int[] result=twoSumByHash(nums,target);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }

    /**
     * 数组为乱序情况   渐进复杂度为O（n2）
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++){
            for (int j = i; j < nums.length; j++) {
                if(target == nums[i] + nums[j]){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    /**
     * 数组为顺序情况:思路二分法
     * 但是排序的复杂度就已经很高了 nlogn-n2; 所以如果不是给定排好序的数组此方法暂时放弃
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumByOrder(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++){
            if(nums[i]+nums[nums.length/2] > target){
                for (int j = i+1; j < nums.length/2+1; j++) {
                    if(target == nums[i] + nums[j] &&i!=j){
                        result[0] = i;
                        result[1] = j;
                    }
                }
            }else if(nums[i]+nums[nums.length/2] < target){
                for (int j = nums.length/2+1; j < nums.length; j++) {
                    if(target == nums[i] + nums[j]&&i!=j){
                        result[0] = i;
                        result[1] = j;
                    }
                }
            }else{
                if(target == nums[i] + nums[nums.length/2]&&i!=nums.length/2){
                    result[0] = i;
                    result[1] = nums.length/2;
                }
            }
        }
        return result;
    }

    /**
     * 用hash表特性渐进复杂度为O（n）
     */
    public static int[] twoSumByHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<> ();
        for (int i = 0; i < nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
