package algorithmProblem;

/**
 * letcode第十题
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 */
public class IsMatch_10 {

    public static void mainIsMatch() {
        String strS = "aabc";
        String strP = "aaa*bc";
        System.out.println("结果为："+isMacthOfficial(strS,strP));
    }

    /**
     * 自己的写法 漏洞颇多 看了解析才知道又要用动态规划
     * @param strS
     * @param strP
     * @return
     */
    public static boolean isMacth(String strS,String strP){
        char[] s=strS.toCharArray();
        char[] p=strP.toCharArray();
        char[] c="*.".toCharArray();
        int j=0;
        int i=0;
        for(;i<p.length;){
            for(;j<s.length;j++){
                if(s[j]==p[i]){
                    i++;
                    j=i;
                    break;
                }else if(p[i]==c[1]){
                    if(i+1<p.length && p[i+1] == c[0]){
                        return true;
                    }
                    i++;
                    j=i;
                    break;
                }else if(p[i]==c[0] && j-1>=0 && s[j]==s[j-1]){
                    continue;
                }else if(p[i]==c[0] && j-1>=0 && s[j]!=s[j-1]){
                    i++;
                    j=i;
                    break;
                }else if(p[i] != s[j] && i+1<p.length && p[i+1]==c[0]){
                    i++;
                    i++;
                    break;
                }else{
                    return false;
                }
            }
        }
        if(p.length < s.length && !strP.contains("*")){
            return false;
        }
        return true;
    }

    /**
     * 官方推荐  动态规划
     * @param s
     * @param p
     * @return
     */
    public static boolean isMacthOfficial(String s,String p){
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                }
                else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public static boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    /**
     * 最贴合我自己想法的  就是太费时费力
     * @param s
     * @param p
     * @return
     */
    public boolean isMatchLikeMine(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        boolean match = !s.isEmpty() && ((s.charAt(0) == p.charAt(0)) || p.charAt(0) == '.');
        if(p.length() >= 2 && p.charAt(1) == '*') return isMatchLikeMine(s, p.substring(2)) || (match && isMatchLikeMine(s.substring(1), p));
        return match && isMatchLikeMine(s.substring(1), p.substring(1));
    }
}
