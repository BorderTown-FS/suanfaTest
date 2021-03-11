package algorithmProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * letcode第八题
 * 字符串转化为整数
 */
public class RemoveTheCharacter {

    public static void mainRemoveTheCharacter() {
        String str = "     -5-";
        System.out.println("转化为："+myAtoi(str));
    }

    /**
     * 自己写的暴力解法  繁琐 容易漏掉特例
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        char num[] = str.toCharArray();
        StringBuffer strBuf = new StringBuffer();//把数字放到strBuf中
        String regularExpression = "\\u3000|\\u0020|\\u00A0";
        boolean fushu = false;
        if(null == str || "".equals(str)){
            return 0;
        }
        try{
            if((str.substring(0,1).equals("-") || str.substring(0,1).equals("+")) && str.length() != 1){
                if(str.substring(0,1).equals("-")){
                    fushu = true;
                }
                for(int i=1;i<str.length();i++){
                    if(!Character.isDigit(num[i])){
                        if(null == strBuf || "".equals(strBuf.toString())){
                            return 0;
                        }else if(fushu){
                            return Integer.parseInt("-"+strBuf.toString());
                        }
                        return Integer.parseInt(strBuf.toString());
                    }
                    strBuf.append(num[i]);
                }
                if(fushu){
                    return Integer.parseInt("-"+strBuf.toString());
                }
                return Integer.parseInt(strBuf.toString());
            }else if(Character.isDigit(num[0])){
                for(int i=0;i<str.length();i++){
                    if(!Character.isDigit(num[i])){
                        return Integer.parseInt(strBuf.toString());
                    }
                    strBuf.append(num[i]);
                }
                return Integer.parseInt(strBuf.toString());
            }else if(str.substring(0,1).matches(regularExpression) && str.length() != 1){
                for(int i=1;i<str.length();i++){
                    if(Character.isDigit(num[i])) {
                        if(i+1 < str.length() && Character.isDigit(num[i+1])){
                            strBuf.append(num[i]);
                        }else{
                            strBuf.append(num[i]);
                            if(fushu){
                                return Integer.parseInt("-"+strBuf.toString());
                            }
                            return Integer.parseInt(strBuf.toString());
                        }
                    }else if((num[i]+"").equals("-") || (num[i]+"").equals("+")){
                        if((num[i]+"").equals("-")){
                            fushu = true;
                        }
                        if(i+1 < str.length() && Character.isDigit(num[i+1])){
                            continue;
                        }else if(i+1 >= str.length()){
                            return 0;
                        }else {
                            if(null == strBuf || "".equals(strBuf.toString())){
                                return 0;
                            }else if(fushu){
                                return Integer.parseInt("-"+strBuf.toString());
                            }
                            return Integer.parseInt(strBuf.toString());
                        }
                    }else if((num[i]+"").matches(regularExpression)){
                        continue;
                    }else{
                        return 0;
                    }
                }
                if(null == strBuf || "".equals(strBuf.toString())){
                    return 0;
                }
                return Integer.parseInt(strBuf.toString());
            }else{
                return 0;
            }
        }catch(Exception e){
            if(fushu){
                return -2147483648;
            }else{
                return 2147483647;
            }
        }
    }

    /**
     * 官方解法
     * @param str
     * @return
     */
    public static int myAtoiOfficial(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }
}

class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    /**
     * 判断字符类型
     * @param c
     * @return
     */
    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}