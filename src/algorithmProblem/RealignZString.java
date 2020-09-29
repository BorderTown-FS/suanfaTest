package algorithmProblem;

import java.util.ArrayList;
import java.util.List;

public class RealignZString {
    /**
     * LETCODE第六题
     */
    public static void mainRealignZString() {
        String str = "LEETCODEISHIRING";
        System.out.println("最长回文子串为："+convert1(str,4));
    }

    /**
     * 自己最开始的想法找出每一层的规律然后一层一层的拼接
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if(null == s || "".equals(s)){
            return s;
        }
        //先算出字符串可以被分割成多少个小块
        int m = s.length()%((numRows-1)*2)==0?s.length()/((numRows-1)*2):s.length()/((numRows-1)*2)+1;
        //一块有多少个字符
        int y = (numRows-1)*2;
        //如果除不尽则补上※
        if(s.length()%((numRows-1)*2)!=0){
            int numX = (numRows-1)*2 - s.length()%((numRows-1)*2);
            for(;numX>0;numX--){
                s = s+"※";
            }
        }
        //新的字符串
        String newStr = "";
        //开始重续拼装
        for(int n=1;n<=numRows;n++){
            for(int j=1;j<=m;j++){
                if(n==1 || n==numRows){
                    newStr = newStr+s.charAt(y*(j-1)+n-1);
                }else{
                    newStr = newStr+s.charAt(y*(j-1)+n-1)+s.charAt(y*(j-1)+(y+1)-(n-1)-1);
                }
            }
        }
        return newStr.replaceAll("※","");
    }

    /**
     * 官方方法顺应规律直接顺着层数赋值然后倒回来重新赋值，简单明了
     * 按行排序
     * @param s
     * @param numRows
     * @return
     */
    public static String convert1(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++){
            rows.add(new StringBuilder());}

        int curRow = 0;
        boolean goingDown = false;


        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            //把开始和结尾作为转折点，从1-n,再从n-1.
            if (curRow == 0 || curRow == numRows - 1) {goingDown = !goingDown;}
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {ret.append(row);}
        return ret.toString();
    }

    /**
     * 跟我的方法思路一样，但是更简洁 我思路走了弯路，多了一些步骤
     * 按行访问
     * * @param s
     * @param numRows
     * @return
     */
    public String convert2(String s, int numRows) {

        if (numRows == 1) {return s;}

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n){
                    ret.append(s.charAt(j + cycleLen - i));}
            }
        }
        return ret.toString();
    }
}
