package sixty;

/**
 * Created by ASUS on 2017/3/12.
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。 '表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字
 * 符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class RegularExpression {


    /**
    @author zhengyanan
    @time 22:32
    @description
    version_1
    核心思路：
    1.当模式中的第二个字符不是“*”时：
        1)、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，
        然后匹配剩余的。
        2)、如果字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。
    2.而当模式中的第二个字符是“*”时：
        1)如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。
        2）如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
            （1）、字符串不移，     模式后移2字符，相当于x*被忽略； 即*匹配0次；
         ## （2）、字符串后移1字符，模式后移2字符；即*正好匹配1次；（PS:此情况可以省略，因为其可由（1）与（3）组合出来）
            （3）、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
    3.需要注意的是：Java里，要时刻检验数组是否越界。

     */
    public boolean match(char[] str, char[] pattern){
        return matchDetail(str,0,pattern,0);
    }

    public boolean matchDetail(char[] str,int sStart,char[] pattern,int pStart){
        if (str.length == sStart && pattern.length == pStart)   return true;
        if (str.length > sStart && pattern.length == pStart)    return false;

        if (pStart + 1 < pattern.length && pattern[pStart + 1] == '*'){
            if (sStart < str.length && (str[sStart] == pattern[pStart] || pattern[pStart] == '.')){
                return matchDetail(str,sStart,pattern,pStart + 2)
//                        || matchDetail(str,sStart + 1,pattern,pStart + 2)  此句可以省略
                        || matchDetail(str,sStart + 1,pattern,pStart);
            }
            else
                return matchDetail(str,sStart,pattern,pStart + 2);
        }
        if (sStart < str.length && (str[sStart] == pattern[pStart] || pattern[pStart] == '.')){
            return matchDetail(str,sStart + 1,pattern,pStart + 1);
        }
        return false;
    }
    public static void main(String[] args){
        char[] a = "aaa".toCharArray();
        char[] b = "ab*ac*a".toCharArray();

        System.out.println(new RegularExpression().match(a,b));
    }
}
