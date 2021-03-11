package algorithmProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 15. 三数之和
 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 注意：答案中不可以包含重复的三元组。
 */
public class ThreeNumbersSum {
    public static void mainThreeNumbersSum() {
        int[] rom = {-1,0,1,2,-1,-4};
        System.out.println("结果为："+new ThreeNumbersSum().threeSumOffical(rom));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listEndResult = new ArrayList<>();
        List<List<Integer>> listSuccessResult = new ArrayList<>();
        List<Integer> listMidResult = null;
        if(nums.length < 3){
            return listEndResult;
        } else{
            for(int i = 0;i<nums.length;i++){
                int m = i+1;
                while(m<nums.length){
                    int n = i+2;
                    while(n<nums.length) {
                        listMidResult = new ArrayList<>();
                        listMidResult.add(nums[i]);
                        listMidResult.add(nums[m]);
                        listMidResult.add(nums[n]);
                        Collections.sort(listMidResult);
                        if (nums[i] + nums[m] + nums[n] == 0
                                && !listSuccessResult.contains(listMidResult)) {
                            listEndResult.add(listMidResult);
                            listSuccessResult.add(listMidResult);
                        }
                        n++;
                    }
                    m++;
                }
            }
            return listEndResult;
        }
    }

    public List<List<Integer>> threeSumOffical(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> listEndResult = new ArrayList<>();
        if(n < 3){
            return listEndResult;
        } else{
            for(int first = 0;first<n;++first){
                if (first > 0 && nums[first] == nums[first - 1]) {
                    continue;
                }
                int third = n - 1;
                int target = -nums[first];
                for(int second = first+1;second<n;++second){
                    // 需要和上一次枚举的数不相同
                    if (second > first + 1 && nums[second] == nums[second - 1]) {
                        continue;
                    }
                    // 需要保证 b 的指针在 c 的指针的左侧
                    while (second < third && nums[second] + nums[third] > target) {
                        --third;
                    }
                    // 如果指针重合，随着 b 后续的增加
                    // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                    if (second == third) {
                        break;
                    }
                    if (nums[second] + nums[third] == target) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        listEndResult.add(list);
                    }
                }
            }
            return listEndResult;
        }
    }
}
