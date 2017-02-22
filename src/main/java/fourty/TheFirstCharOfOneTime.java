package fourty;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/2/21.
 * 在一个字符串(1<=字符串长度<=10000，全部由大写字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class TheFirstCharOfOneTime {



    /**
       @author zhengyanan
       @date 2017/2/21 @time 11:26
      version_1:
        核心思路：（PS：测试数据跟题目不匹配，经测试，题目意思应该是：在一个字符串（全部由字母组成，可大写可小写），
       中找到第一个只出现一次的字符，返回它在字符串中的位置，字符串长度可能为0。）
        1.采用类似计数排序中的技巧，用str.charAt(i) - ‘A’ 作为下标：
            其中：发现字符串中都是字母，A~Z对应的ASCII 码值：65~90；a~z对应97~122
            故，只需取了一个数组的长度为122-65 + 1= 58即可，不必取256.

        2.遍历字符串，每访问一个字符，times[str.charAt(i) - 'A']++;与此同时，
            用一个lastIndex[str.charAt(i) - 'A'] = i,记下最后一次访问此字符时对应的下标值。

        3.遍历完一遍后，只需再遍历times，找出其中值等于1的字符中，lastIndex最小的那个，即为所求。
            相比于通常解法中最后再遍历整个一遍str，找到第一个times等于1的字符，这里至多遍历58个，
            对于特别大的数据，无疑会更高效一些；但如果str很短，直接遍历str，
            找到第一个times等于1的字符就会更划算一点。

       复杂度：时间O(n)；空间O(1)
       运行时间：40ms
       占用内存：654k
    */
    public int FirstNotRepeatingChar(String str) {
        int[] times = new int[58];
        int[] lastIndex = new int[58];
        int resultIndex = str.length() - 1;

        for (int i = 0; i < str.length(); i++) {
            times[str.charAt(i) - 'A']++;
            lastIndex[str.charAt(i) - 'A'] = i;
        }

        for (int i = 0; i < times.length; i++) {
            if (times[i] == 1 && lastIndex[i] < resultIndex){
                resultIndex = lastIndex[i];
            }
        }
        return resultIndex;
    }
    public static void main(String[] args){
        System.out.println((int)'a' + ";"+ (int)'z');
        System.out.println((int)'A' + ";"+ (int)'Z');
        System.out.println(new TheFirstCharOfOneTime().FirstNotRepeatingChar("google"));
        System.out.println(new TheFirstCharOfOneTime().test("google"));
    }

    public int test(String str) {
        char[] c = str.toCharArray();
        int[] a = new int['z'];
        for (char d : c)
            a[(int) d]++;
        for (int i = 0; i < c.length; i++)
            if (a[(int) c[i]] == 1)
                return i;
        return -1;
    }
}
