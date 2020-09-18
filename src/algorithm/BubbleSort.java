package algorithm;

/**
起泡排序（递增）>>>>有点像冒泡排序
渐进时间复杂度：O(f(n)*g(n))=O(n2)
 */
public class BubbleSort {
    public static void mainBubbleSort() {
        bubbleSortArrayTest();
    }
    private static void bubbleSortArrayTest(){
        int[] bs={8,4,1,6,2,3,5,7};
        for (int i = 0; i < bs.length; i++){
            for (int j = bs.length-1; j > i; j--) {
                if(bs[j] < bs[j-1]){
                    int temp = bs[j];
                    bs[j] = bs[j-1];
                    bs[j-1] = temp;
                }
            }
        }
        for (int j = 0; j < bs.length; ++j) {
            System.out.print(bs[j]);
        }
    }
}
