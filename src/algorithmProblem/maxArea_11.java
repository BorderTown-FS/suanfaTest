package algorithmProblem;

/**
 * letcode第十一题
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
public class maxArea_11 {
    public static void mainMaxArea() {
        int[] height = {3,6,7,4,1,5,8,3,4};
        System.out.println("结果为："+doublePointerMaxArea(height));
    }

    /**
     * 暴力算法
     * @param height
     * @return
     */
    public static int maxArea(int[] height){
        int max = 0;
        for(int i=0;i<height.length-1;i++){
            for(int j=i+1;j<height.length;j++){
                int hig = height[i]>height[j]?height[j]:height[i];
                max = hig*(j-i)>max?hig*(j-i):max;
            }
        }
        return max;
    }

    /**
     * 双指针算法
     * @param height
     * @return
     */
    public static int doublePointerMaxArea(int[] height){
        int max= 0;
        int j = height.length-1;
        int i = 0;
        while(i<j){
            if(height[i]>height[j]){
                max = height[j]*(j-i)>max?height[j]*(j-i):max;
                --j;
            }else{
                max = height[i]*(j-i)>max?height[i]*(j-i):max;
                ++i;
            }
        }
        return max;
    }
}
