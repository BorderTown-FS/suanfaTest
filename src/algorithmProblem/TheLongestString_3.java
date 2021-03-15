package algorithmProblem;

import java.util.HashMap;
import java.util.Map;


/**
 * LeetCode第三题
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 */
public class TheLongestString_3 {
    public static void mainTheLongestString() {
        String str = "aab";
        System.out.println(getNEWLogestString2(str));
    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
     * @param str
     * @return
     */
    private static int getLogestString(String str) {
        char[] chars = str.toCharArray();
        Map map = null;
        //不重复的最长子字符串长度
        int max = 0;
        //长度是否为整个数组长度的标记
        boolean result;
        for (int i = 0; i < chars.length; i++) {
            //如果剩下的长度不及子字符串长度就返回
            if(max > chars.length-i){
                return max;
            }
            //内循环每循环一次就重置数组
            map = new HashMap<String,Integer>();
            result = true;
            for (int j = i; j < chars.length; j++) {
                //判断数组里面是否有重复字符串有的话就退出内循环并且记录集合长度
                if (map.containsKey(chars[j])){
                    max = max<map.size()?map.size():max;
                    result = false;
                    System.out.println("i为: "+i+"   j为："+j);
                    break;
                }
                map.put(chars[j],null);
            }
            //万一整个字符串里面都没有重复的字符
            if(result){
                return max<map.size()?map.size():max;
            }
        }
        return max;
    }

    /**
     * 标准答案
     我们不妨以示例一中的字符串 abcabcbb}abcabcbb 为例，找出 从每一个字符开始的，
     不包含重复字符的最长子串，那么其中最长的那个字符串即为答案。对于示例一中的字符串，
     我们列举出这些结果，其中括号中表示选中的字符以及最长的字符串：
     * 以 (a)bcabcbb 开始的最长字符串为 (abc)abcbb；
     * 以 a(b)cabcbb 开始的最长字符串为 a(bca)bcbb；
     * 以 ab(c)abcbb 开始的最长字符串为 ab(cab)cbb；
     * 以 abc(a)bcbb 开始的最长字符串为 abc(abc)bb；
     * 以 abca(b)cbb 开始的最长字符串为 abca(bc)bb；
     * 以 abcab(c)bb 开始的最长字符串为 abcab(cb)b；
     * 以 abcabc(b)b 开始的最长字符串为 abcabc(b)b；
     * 以 abcabcb(b) 开始的最长字符串为 abcabcb(b)。
     * @param str
     * @return
     */
    private static int getNEWLogestString2(String str) {
        char[] chars = str.toCharArray();
        Map map = new HashMap<String,String>();
        int max = 0,temp = 0;
        for (int i = 0; i < chars.length; i++) {
            //开始新的一轮循环就去掉开头重复的字符
            if(i !=0){
                map.remove(chars[i]);
            }
            while (temp + 1 < chars.length && !map.containsKey(chars[temp + 1])) {
                // 不断地移动右指针
                map.put(chars[temp + 1],null);
                ++temp;
            }
            // 第 i 到 temp 个字符是一个极长的无重复字符子串
            max = max < map.size() ? map.size() : max;
        }
        return max;
    }
}
