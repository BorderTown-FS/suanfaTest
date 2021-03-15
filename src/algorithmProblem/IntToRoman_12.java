package algorithmProblem;

/**
 * 12. 整数转罗马数字
 */
public class IntToRoman_12 {

    public static void mainIntToRoman() {
        int height = 3;
        System.out.println("结果为："+intToRoman(height));
    }

    /**
     * 自己写的递归 简单但是复杂代码冗余
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        if(num / 1000 != 0){
            return splicingStr(num / 1000,"M")+intToRoman(num%1000);
        }else if(num / 900 != 0){
            return "CM"+intToRoman(num%900);
        }else if(num / 500 != 0){
            return "D"+intToRoman(num%500);
        }else if(num / 400 != 0){
            return "CD"+intToRoman(num%400);
        }else if(num / 100 != 0){
            return splicingStr(num / 100,"C")+intToRoman(num%100);
        }else if(num / 90 != 0){
            return "XC"+intToRoman(num%90);
        }else if(num / 50 != 0){
            return "L"+intToRoman(num%50);
        }else if(num / 40 != 0){
            return "XL"+intToRoman(num%40);
        }else if(num / 10 != 0){
            return splicingStr(num / 10,"X")+intToRoman(num%10);
        }else if(num / 9 != 0){
            return "IX"+intToRoman(num%9);
        }else if(num / 5 != 0){
            return "V"+intToRoman(num%5);
        }else if(num / 4 != 0){
            return "IV"+intToRoman(num%4);
        }else{
            return splicingStr(num ,"I");
        }
    }

    public static String splicingStr(int num,String index){
        String mid = "";
        for(int i=0;i<num;i++){
            mid = mid+index;
        }
        return mid;
    }

    public enum Roman {
        RomanI(1,"I"),
        RomanIX(4, "IX"),
        RomanV(5, "V"),
        RomanIV(9, "IV"),
        RomanX(10,"X"),
        RomanXL(40,"XL"),
        RomanL(50,"L"),
        RomanXC(90,"XC"),
        RomanC(100,"C"),
        RomanCD(400,"CD"),
        RomanD(500,"D"),
        RomanCM(900,"CM"),
        RomanM(1000,"M");

        public int value;
        public String valueName;

        private Roman(int value,String valueName){
            this.value = value;
            this.valueName = valueName;
        }

        public static String valOf(int val){
            for(int i = 0; i< values().length;i++){
                if(values()[i].value==val){
                    return values()[i].valueName;
                }
            }
            return "";
        }
    }

    /**
     * 贪心算法
     */
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intToRomanOffical(int num) {
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values.length && num >= 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 硬编码数字
     * @param num
     * @return
     */
    public String intToRomanOffical1(int num) {

        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 / 10] + ones[num % 10];
    }
}

