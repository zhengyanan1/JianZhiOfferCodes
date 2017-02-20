package thirty;

import java.util.*;

/**
 * Created by Administrator on 2017/2/15.
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
   输入描述:
   输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class ArrangeString {




    /**
       @author zhengyanan
       @date 2017/2/15 @time 17:08
        version_3:（沿袭version-1，version-2而来：）
        核心思路：
            1.version—2里对于String，StringBuilder的操作，可以把其转换成对Char[]数组的操作
            应该能再减小一些时间、空间复杂度。
            2.基本思路同前，此处不予实现。
    */

    /**
       @author zhengyanan
       @date 2017/2/15 @time 17:04
       version_2:
        核心思路：基本同version_1,还是暴力解法（此题是求得全排列，必须暴力解法，无非看你具体怎么实现这个暴力法的）
        优化：减少了version_1中创建的大量中间变量，采用swap的方式，空间复杂度应该得到了优化。
       运行时间：147ms
       占用内存：1985k
    */
    private SortedSet<String> results = new TreeSet<String>();
    private StringBuilder source = null;

    public ArrayList<String> Permutation(String str) {
        if (str.length() >= 1){
            source = new StringBuilder(str);
            totalArrange(0,str.length() - 1);
        }
        return new ArrayList<String>(results);
    }

    private void totalArrange(int start,int end){
        if (start == end){
            results.add(source.toString());
        }
        else {
            String sameState = source.toString();
            System.out.println("ArrangeString.totalArrange():" + sameState);
            for (int i = start; i <= end; i++) {
                source = new StringBuilder(sameState);
                swap(start,i);
                totalArrange(start+1,end);
            }
        }
    }
    private void swap(int i,int j){
        char t = source.charAt(i);
        source.setCharAt(i,source.charAt(j));
        source.setCharAt(j,t);
    }



    /**
       @author zhengyanan
       @date 2017/2/15 @time 15:39
        version_1:
        核心思路：暴力求解法
            1.不断地将问题 f(n)递归转换为n*f(n-1)问题，直到n=1为止；
        缺点：
            1.太暴力，并且中间创建了大量的中间String对象，时间、空间复杂度太大。
                时间：O(n!)
                空间：O(n!)
       运行时间：140ms
       占用内存：2616k
    */
//    public ArrayList<String> Permutation(String str) {
//        if (str.length() == 0){
//            return new ArrayList<String>();
//        }
//        if (str.length() == 1)  {
//            ArrayList<String> results = new ArrayList<String>();
//            results.add(str);
//            return results;
//        }
//        else{
//            ArrayList<String> results = new ArrayList<String>();
//
//            for (int i = 0; i < str.length(); i++) {
//                StringBuilder sb = new StringBuilder(str);
//                sb.deleteCharAt(i);
//
//                ArrayList<String> resultSmallOne = Permutation(sb.toString());
//                for (String s : resultSmallOne) {
//                    String newString = str.substring(i, i + 1) + s;
//                    if (!results.contains(newString))   results.add(newString);
//                }
//            }
//            return results;
//        }
//    }
    public static void main(String[] args){
        System.out.println("ArrangeString.main():" + new ArrangeString().Permutation("aab"));
    }
}
