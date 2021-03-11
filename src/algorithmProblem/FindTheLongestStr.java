package algorithmProblem;

/**
 * 14.最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""
 */
public class FindTheLongestStr {
    public static void mainFindTheLongestStr() {
        String[] rom = {"flower","flow","flight"};
        System.out.println("结果为："+new FindTheLongestStr().longestCommonPrefixOffical(rom));
    }

    public static String longestCommonPrefix(String[] strs) {
        String longestStr = "";
        if(strs == null ||strs.length == 0){
            return longestStr;
        }else if(strs.length == 1){
            return strs[0];
        }else{
            int j = 1;
            for(int i = 1;i<strs.length;i++){
                if(strs[i].length() == 0){
                    return "";
                }
                while(j<=strs[i-1].length() && j<=strs[i].length()){
                    if(i == 1){
                        if(strs[0].substring(0,j).equals(strs[1].substring(0,j))){
                            longestStr = strs[0].substring(0,j);
                        }else{
                            break;
                        }
                    }else{
                        if(j<=longestStr.length() && longestStr.substring(0,j).equals(strs[i].substring(0,j))){
                            longestStr = longestStr.substring(0,j);
                        }else{
                            if(j == 1){
                                return "";
                            }else{
                                return longestStr;
                            }
                        }
                    }
                    j++;
                }
                j=1;
            }
        }
        return longestStr;
    }

    public String longestCommonPrefixOffical(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2){
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
}
