package algorithmProblem;

/**
 * letcode第九题
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class IsPalindrome {

    public static void mainIsPalindrome() {
        int num = -121;
        System.out.println("结果为："+isPalindromeOther(num));
    }

    /**
     * 自己写的比较普通的  空间占用率太大  效率不高
     * @param theNumber
     * @return
     */
    public static boolean isPalindrome(int theNumber){
        String theNum = theNumber+"";
        char[] charNum = theNum.toCharArray();
        if(theNumber < 0){
            return false;
        }if(theNumber == 0){
            return true;
        }else {
            for(int i = 0; i<charNum.length/2;i++){
                if(charNum[i] != charNum[charNum.length-1-i]){
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 官方方法，不用转字符串
     * @param theNumber
     * @return
     */
    public static boolean isPalindromeOther(int theNumber){
        if(theNumber < 0){
            return false;
        }if(theNumber == 0){
            return true;
        }else {
            int i=0;
            while(theNumber>i){
                i = 10*i+theNumber%10;
                theNumber = theNumber/10 ;
            }
            return true;
        }
    }
}
