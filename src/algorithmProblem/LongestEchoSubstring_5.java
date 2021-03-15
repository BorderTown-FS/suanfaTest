package algorithmProblem;

import java.util.HashMap;
import java.util.Map;


/**
 * LeetCode第五题
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class LongestEchoSubstring_5 {

    public static void mainTheLongestString() {
        String str = "cbbd";
        System.out.println("最长回文子串为："+centerExtension(str));
    }

    /**
     * 动态规划算法
     * @param s
     * @return
     */
    public static String dynamicPlanning(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }

    /**
     * 中心扩展方法
     * @param str
     * @return
     */
    public static String centerExtension(String str){
        if(str.length() == 0 || str.length() == 1){
            return str;
        }
        String maxStr = "";
        for(int i = 0;i<str.length();i++){
            String length1=expandAroundCenter(str,i,i+1);
            String length2=expandAroundCenter(str,i,i);
            String length = length1.length() >= length2.length()?length1:length2;
            maxStr = maxStr.length() >= length.length()?maxStr:length;
        }
        return maxStr;
    }
    public static String expandAroundCenter(String str, int left, int right) {
        while(left >=0 && right<str.length() && str.charAt(left) == str.charAt(right)){
            --left;
            ++right;
        }
        return str.substring(left+1,right);
    }
}
