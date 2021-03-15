package algorithmProblem;

import java.util.*;

/**
 * 20. 有效的括号
 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 有效字符串需满足：
 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 */
public class IsValid_20 {
    public static void mainIsValid() {
        String valid = "{[()]}";
        System.out.println("结果为："+new IsValid_20().isValid(valid));
    }

    public boolean isValid(String valid) {
        Map<Character,Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
        Deque<Character> stack = new LinkedList<Character>();;
        for(int i = 0;i<valid.length();i++){
            if(!map.containsKey(valid.charAt(i))){
                stack.push(valid.charAt(i));
            }else{
                if(map.get(valid.charAt(i)) == stack.peek()){
                    stack.pop();
                    continue;
                }else{
                    return false;
                }
            }
        }
       return stack.isEmpty();
    }
}
