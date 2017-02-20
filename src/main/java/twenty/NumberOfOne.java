package twenty;

/**
 * Created by Administrator on 2016/12/26.
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOfOne {
    public int NumberOf1(int n) {

        int count = 0;
        while(n!= 0){
            count++;
            n = n & (n - 1);
        }
        return count;
        /**
           @author zhengyanan
           @date 2016/12/26 @time 18:29
          version_3:
         官网答案：
           运行时间：31ms
           占用内存：629k
        */


//        int result = 0;
//        int flag = 1;
//        while (flag != 0){
//            if ((flag & n) != 0){
//                result++;
//            }
//            flag <<= 1;
//        }
//        return result;
        /**
           @author zhengyanan
           @date 2016/12/26 @time 18:05
          version_2 :
           思路：使用移位操作
        */


        /**
           @author zhengyanan
           @date 2016/12/26 @time 17:36
          version_1
           运行时间：30ms
           占用内存：688k
            思路：调用java的API，Integer.toBinaryString(n)返回的就是n的补码表示的字符串
        */
//        String num = Integer.toBinaryString(n);
//        int result = 0;
//        for (char c:num.toCharArray()) {
//            if (c == '1')   result ++;
//        }
//
//        return result;
    }
    public static void main(String[] args){
        System.out.println("NumberOfOne.main():" + Integer.bitCount(-5));
        System.out.println("NumberOfOne.main():" + Integer.bitCount(5));
    }
}
