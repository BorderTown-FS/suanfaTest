package algorithmProblem;

/**
 * 13. 罗马数字转数字
 */
public class RomanToInt {

    public static void mainRomanToInt() {
        String rom = "V";
        System.out.println("结果为："+romanToInt(rom));
    }

    /**
     * 暴力破解
     */
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public int romanToInt(String rom) {
        int sum = 0;
        char[] romChar = rom.toCharArray();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i <romChar.length; i++) {
            // Repeat while the current symbol still fits into num.
            for(int j = 0;j<symbols.length;j++){
                String c = romChar[i]+"";
                if(c.equals(symbols[j])){
                    sum = sum+values[j];
                }
            }
        }
        return sum;
    }
}

