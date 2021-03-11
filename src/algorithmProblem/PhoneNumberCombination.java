package algorithmProblem;

import java.util.*;

/**
 * 17. 电话号码的子母组合
 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class PhoneNumberCombination {
    public static void mainPhoneNumberCombination() {
        String digits = "234";
        System.out.println("结果为："+new PhoneNumberCombination().letterCombinations(digits));
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) {
            return list;
        }
        Map<Character, String> exm = new HashMap<>();
        exm.put('2',"abc");
        exm.put('3',"def");
        exm.put('4',"ghi");
        exm.put('5',"jkl");
        exm.put('6',"mno");
        exm.put('7',"pqrs");
        exm.put('8',"tuv");
        exm.put('9',"wxyz");
        recall(list, exm, digits, 0, new StringBuffer());
        return list;
    }
    public void recall(List<String> list,Map<Character, String> exm,String digits,int index, StringBuffer strBuf){
        if(digits.length() == index){
            list.add(strBuf.toString());
        }else{
            char digit = digits.charAt(index);
            String letters = exm.get(digit);
            for(int i = 0;i<letters.length();i++){
                strBuf.append(letters.charAt(i));
                recall(list, exm, digits, index + 1, strBuf);
                strBuf.deleteCharAt(index);
            }
        }
    }
}
