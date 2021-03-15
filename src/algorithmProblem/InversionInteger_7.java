package algorithmProblem;

/**
 * letcode第七题
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class InversionInteger_7 {
    public static void mainInversionInteger() {
        int str = 1534236469;
        System.out.println("结果为："+reverse(str));
    }

    /**
     * 先转Sring反转再转int 很麻烦还容易出错
     * @param x
     * @return
     */
    public static int reverse(int x) {
        String str = "";
        if(x < 0){
            str = x+"";
            str = str.substring(1);
        }else if(x == 0 || x == 1){
            return x;
        }else{
            str = x+"";
        }
        StringBuilder builder = new StringBuilder();
        int index = -1;
        for(int i =0;i<str.length();i++){
            if("0".equals(str.charAt(str.length()-1-i)) && i == 0){
                index = 0;
            }else if("0".equals(str.charAt(str.length()-1-i)) && i-index == 1){
                index = i;
            }else{
                builder.append(str.charAt(str.length()-1-i));
            }
        }
        int returnInt = 0;
        try{
            returnInt = Integer.parseInt(builder.toString());
        }catch (NumberFormatException e){
            return 0;
        }
        if(x < 0){
            String excessive = "-"+builder.toString();
            returnInt = Integer.parseInt(excessive);
        }
        return returnInt;
    }

    /**
     * 弹出一个拼装一个，效率更快
     * @param x
     * @return
     */
    public int reverse1(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
