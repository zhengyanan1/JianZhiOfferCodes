package fifty;

/**
 * Created by Administrator on 2017/3/2.
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 *
 * 输入一个字符串,包括数字字母符号,可以为空
 *
 * 如果是合法的数值表达则返回该数字，否则返回0
 */
public class TranslateStringIntoInt {


    /**
       @author zhengyanan
       @date 2017/3/2 @time 17:30
      version_1:
        核心思路：
            1.一个个字符遍历即可。
            如果遇到数字就处理；
            如果遇到‘-’，判断下标是不是i，是就标记下符号；（默认为正）
            如果遇到其他字符的话，判断当前result值：
                result！=0，说明已经访问过数字了，此时又有非数字型字符，显然不对，直接返回0即可。

        （PS：像这种不考察具体算法，而重在考查逻辑严密性的题目中，应该题目严谨+测试样例多；
        遗憾的是，牛客网这一题显然做的很不到位，我完全是试出需求的-_-||）
    */
    public int StrToInt(String str) {
        if (str.length() == 0 || str == null)   return 0;

        int result = 0;
        boolean isPositive = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)>='0' &&  str.charAt(i)<= '9'){
                result = result * 10 + (str.charAt(i) - '0');
            }
            else if (str.charAt(i) == '-' && i == 0){
                isPositive = false;
            }
            else{
                if (result != 0)    return 0;
            }
        }

        return isPositive?result:-result;
    }
    public static void main(String[] args){
        System.out.println(new TranslateStringIntoInt().StrToInt("-fdsa123"));
    }
}
