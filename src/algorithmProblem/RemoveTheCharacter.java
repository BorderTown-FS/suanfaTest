package algorithmProblem;

/**
 *
 *
 */
public class RemoveTheCharacter {

    /**
     * letcode第八题
     */
    public static void mainRemoveTheCharacter() {
        String str = "     -5-";
        System.out.println("最长回文子串为："+myAtoi(str));
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
     *
     * @param str
     * @return
     */
    public static int myAtoiImprovement(String str) {
        StringBuffer strBuf = new StringBuffer();//把数字放到strBuf中
        String regularExpression = "\\u3000|\\u0020|\\u00A0";

        if(null == str || "".equals(str)){
            return 0;
        }
        improvementRecursion(str,0);

        return 0;
    }

    /**
     * 判断字符类型
     * @param strChar
     * @return
     */
    public static int judge(char strChar){
        String str = strChar+"";
        if(str.equals(" ")){
            return 1;
        }else if(str.equals("-") || str.equals("+")){
            return 2;
        }else if(Character.isDigit(strChar)){
            return 3;
        }else{
            return 4;
        }
    }

    /**
     *  state：1为空格，2为+/-,3为数字，4为其他
     * @return
     */
    public static String  improvementRecursion(String str,int state){
        char num[] = str.toCharArray();
        String result = "";
        if(Character.isDigit(num[0]) && state == 0){
            return str;
        }else if(str.length() > 1){
            switch (state){
                case 1:
                    int ttt = judge(num[0]);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        }else if(state == 3 && Character.isDigit(num[0])) {
            return str;
        }else{
            return "";
        }
        return "";
    }
}
