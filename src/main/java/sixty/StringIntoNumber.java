package sixty;

/**
 * Created by Administrator on 2017/3/13.
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class StringIntoNumber {

    /**
       @author zhengyanan
       @date 2017/3/13 @time 11:13
      version_1:
        核心思路：
            1.先抽象出模式：[+/-]num[.num][e|E[+/-]num]
            2.根据这个pattern，逐部分地进行扫描处理。
            3.感觉本题主要考察了逻辑的严密性，而并没有考察什么数据结构之类的东西；
            4.如果在实际应用中，对于这种模式匹配的问题，直接采用String的正则表达式进行处理比较好。
            5.本题采用了《剑指offer》一书中的思路。
    */
    private int index = 0;
    public boolean isNumeric(char[] str) {
        boolean isNumber;
        if (str.length == 0 || str == null) return false;

        if (str[index] == '+' || str[index] == '-') index ++;
        if (index == str.length)    return false;

        isNumber = true;

        scanDigits(str);


        if (index < str.length){
            if (str[index] == '.'){
                index ++;
                if (index == str.length)    return false;
                scanDigits(str);

                if (index < str.length && (str[index] == 'e' || str[index] == 'E')){
                    isNumber = scanScientificNotation(str);
                }
            }
            else if (str[index] == 'e' || str[index] == 'E'){
                isNumber = scanScientificNotation(str);
            }
            else{
                isNumber = false;
            }
        }

        return index == str.length && isNumber;
    }
    public void scanDigits(char[] str){
        while (index < str.length && str[index] >= '0' && str[index] <= '9')    index ++;
    }
    public boolean scanScientificNotation(char[] str){
        index++;
        if (index < str.length && (str[index] == '+' || str[index] == '-')){
            index ++;
        }
        if (index == str.length)    return false;
        scanDigits(str);

        return str.length == index ;
    }



    public static void main(String[] args){
        char[] a = "+.".toCharArray();
        System.out.println(new StringIntoNumber().isNumeric(a));
    }
}
