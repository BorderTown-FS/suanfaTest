package algorithmProblem;

import java.util.HashMap;
import java.util.Map;


/**
 * LeetCode第五题
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class LongestEchoSubstring {

    public static void mainTheLongestString() {
        String str = "acc";
        System.out.println("最长回文子串为："+getLongest(str));
    }

    private static String getLongest(String s) {
        String maxString = "";
        if(s.length() == 1 || s.length() == 0){
            return s;
        }
        for(int i=2;i <= s.length(); i++){
            String str = "";
            if(i == s.length()){
                str = getEchoSubstring(s);
            }else{
                System.out.println(s.substring(0,i));
                str = getEchoSubstring(s.substring(0,i));
            }
            if(str.length() > maxString.length()){
                maxString = str;
            }
        }
        if(maxString.equals("") && s.length() ==2){
            maxString = s.substring(0,1);
        }
        return maxString;
    }

    private static String getEchoSubstring(String s) {
        String maxString = "";
        char[] chars = s.toCharArray();
        int left = 0,right = 0;
        if(s.length()%2 == 0){
            left = s.length()/2 - 1;
            right = s.length()/2;
        }else{
            left = s.length()/2-1;
            right = s.length()/2+1;
        }
        s = s+"00000";
        while(left >= 0){
            System.out.println("right为"+right);
            if(right == chars.length){
                return maxString;
            }
            if(chars[left] == chars[right]){
                System.out.println("最长函数为："+s.substring(left,right+1));
                maxString = s.substring(left,right+1);
                left --;
                right++;
            }else{
                System.out.println("返回函数为："+s.substring(left+1,right));
                return s.substring(left+1,right);
            }
        }
        return maxString;
    }
}
