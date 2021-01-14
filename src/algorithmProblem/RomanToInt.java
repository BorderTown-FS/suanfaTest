package algorithmProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转数字
 */
public class RomanToInt {

    public static void mainRomanToInt() {
        String rom = "III";
        System.out.println("结果为："+learnIntToRoman(rom));
    }

    /**
     * 借鉴14的算法不行
     */
    static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public static int intToRomanOwn(String str) {
        int result = 0;
        int j = 0;
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < str.toCharArray().length; i++) {
            // Repeat while the current symbol still fits into num.
            for(;j<symbols.length;){
                if(str.substring(i,symbols[j].length()+i).equals("I")){
                    result = result + 1;
                    break;
                } else if(str.substring(i,symbols[j].length()+i).equals(symbols[j])){
                    result = result + values[j];
                    j++;
                    break;
                }else{
                    j++;
                }
            }
        }
        return result;
    }

    public static int learnIntToRoman(String str) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int result = 0;
        for (int i = 0; i < str.toCharArray().length;) {
            if(i+1<str.length() && map.containsKey(str.substring(i,i+2))){
                result += map.get(str.substring(i,i+2));
                i+=2;
            }else{
                result += map.get(str.substring(i,i+1));
                i++;
            }
        }
        return result;
    }
}

