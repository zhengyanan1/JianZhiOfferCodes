package fourty;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/2/20.
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class SortIntsMinInt {

    /**
       @author zhengyanan
       @date 2017/2/20 @time 18:08
      version_1:
        核心思路：
            1.本题可抽象为一个排序问题，把数组按从小到大排好序，然后遍历，小的放前面，大的放后面，即得所求。
            2.问题就在于：这个排序问题中，两个数之间比较的时候，怎么算大，怎么算小。
            3.可以将数字转换成字符串再借用compareTo()进行比较，但又有问题了：
                "456"跟"123","456"应该放后面,而"456">"123",没问题 ；
                而 "3"跟"321","3"应该放后面，但"321">"3",这个是有问题。
                类似的 "12"和"123","12321"和"123","54345"和"543"等
                如果逐个访问字符来处理这种情况，太繁琐，不妥。
            4.借用比较a+b 和 b+a的大小，就消解了这个问题。
            5.进一步分析，其实：如果a.startWith(b)和b.startWith(a)都为false的话，其实直接调用compareTo()
            方法即可；但如果其中有一个为true的话，为了避免遍历单个字符处理这种繁杂的方式，采用比较a+b和b+a
            这种方式就nice的多。
       复杂度：时间O(n*n)；空间O(n)
       运行时间：41ms
       占用内存：654k
    */

    public String PrintMinNumber(int [] numbers) {
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = ""+numbers[i];
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0 ; j < numbers.length - i - 1; j++) {
                if (myCompareTo(nums[j],nums[j+1]) > 0){
                    String t = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = t;
                }
            }
        }

        String result="";
        for (String s:nums) result += s;
        return result;
    }
    private int myCompareTo(String a,String b){
        if (a.startsWith(b) || b.startsWith(a)){
            String big = a + b,small = b + a;
            return big.compareTo(small);
        }
        else
            return a.compareTo(b);
    }

    public static void main(String[] args){
        System.out.println(new SortIntsMinInt().PrintMinNumber(new int[]{3,32,321}));
//        System.out.println("SortIntsMinInt.main():" + "123".compareTo("12"));
//        System.out.println("SortIntsMinInt.main():" + "321".compareTo("32"));
//        System.out.println("SortIntsMinInt.main():" + "23".compareTo("5"));
    }
}
