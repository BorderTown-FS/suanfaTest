package algorithmProblem;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/***
 * @Author fengshuoa
 * @Description 生成括号
 * @Date 16:39 2021/4/29
 * @Param
 * @return
 */
public class GenerateParenthesis_22 {
    public static void mainGenerateParenthesis() {
        int n = 3;
        new GenerateParenthesis_22().generateParenthesis(n).forEach(e ->{
            System.out.println("结果为："+e);
        });
        System.out.println("结果为："+new GenerateParenthesis_22().generateParenthesis(n).size());
    }

    //private Integer sum = 0;

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        //sum = n;
        //this.listAllGenerate(n,n,result,new StringBuilder());
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    /***
     * @Author fengshuoa
     * @Description n代表左括号剩余，m代表右括号生成，x代表剩余能生成的右括号数
     * @Date 16:15 2021/5/31
     * @Param [n, m, x]
     * @return java.lang.String
     */
    private void listAllGenerate(int n, int m,List<String> result , StringBuilder oneResult) {
        //n = sum-this.getNum(oneResult,"\\(");
        //m = sum-this.getNum(oneResult,"\\)");
        if(n > 0 && m > 0 && n <= m){
            oneResult =oneResult.append("(");
            listAllGenerate(n-1,m,result,oneResult);
            oneResult =oneResult.append(")");
            listAllGenerate(n,m-1,result,oneResult);
        }
        if(n == 0 && m == 0 && !result.contains(oneResult)){
            result.add(oneResult.toString());
            return;
        }
    }

    private Integer getNum(StringBuilder oneResult,String str){
        int a = oneResult.toString().length();
        int b = oneResult.toString().replaceAll(str,"").length();
        return a-b;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
