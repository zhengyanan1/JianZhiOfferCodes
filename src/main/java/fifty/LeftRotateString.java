package fifty;

/**
 * Created by Administrator on 2017/2/27.
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class LeftRotateString {

    /**
       @author zhengyanan
       @date 2017/2/27 @time 19:52
       verison_2:
        核心思路：
            1.转置：向左循环n位，就可以把原字符串分成 左边的n%str.length的部分和右边 str.length-左边的部分，
            假设它们分别为 A和B，我们需要的结果就是BA，而当前的原自付出是AB。
            易知：(A*B*)* == (B*)*(A*)* == BA.(假设*表示转置操作)
            那么：只需将原字符串分成两部分，转置3次即可。
            2.将上面的思想用代码实现即可。
       运行时间：34ms
       占用内存：510k
    */
    public String LeftRotateString(String str,int n) {
        if (str.length() == 0)  return str;

        n = n % str.length();

        StringBuilder left = new StringBuilder(str.substring(0,n));
        left.reverse();

        StringBuilder right = new StringBuilder(str.substring(n,str.length()));
        right.reverse();

        left.append(right);
        return left.reverse().toString();
    }


    /**
       @author zhengyanan
       @date 2017/2/27 @time 15:05
      version_1:
        核心思路：
            1.根据题意，循环左移n位就是先令 n = n % str.length(),然后把原String的前n个字符移
            到末尾即可。
            2.用代码实现这一思路即可。
    */
//    public String LeftRotateString(String str,int n) {
//        if (str.length() == 0)  return str;
//
//        n = n % str.length();
//        return str.substring(n) + str.substring(0,n);
//    }
    public static void main(String[] args){
        System.out.println(
                new LeftRotateString().LeftRotateString("1",3)
        );
    }
}
