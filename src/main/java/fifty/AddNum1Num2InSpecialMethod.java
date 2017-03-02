package fifty;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/3/2.
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class AddNum1Num2InSpecialMethod {



    /**
       @author zhengyanan
       @date 2017/3/2 @time 16:42
      verison_1:
        核心思路：
            1.两个数字num1，num2。异或的结果为a，与的结果为b。
            在a中，bit = 1的位表示：num1，num2中只有一个数字这一位为1；
            在b中，bit = 1的位表示：num1，num2两个数字在这一位都为1.（所以相加的话，这一bit应该进位）
            故：num1 + num2 == a + b*2 == a + b <<1;
            2.再取 num1 = a, num2 = b<<1,按1步骤不断循环地处理，直到 b == 0为止。
            3.当b == 0 时，说明num1，num2 没有哪一bit同时为1，即:说明num1+num2没有进位（按二进制进行求和时）
            若没有进位，那么此时：num1，num2异或的结果---a,即为需要求得的和。
    */
    public int Add(int num1,int num2) {
        int sum,add;
        while (true){
            sum = num1 ^ num2;
            add = (num1 & num2)<<1;

            if (0 == add)   break;
            num1 = sum;
            num2 = add;
        }
        return sum;
    }





//    public int Add(int num1,int num2) {
//        int[] bits1 = new int[33];
//        int[] bits2 = new int[33];
//
//        for (int i = 0; i < 32; i++) {
//            bits1[i] = (num1 & (1<<i)) == 0? 0:1;
//            bits2[i] = (num2 & (1<<i)) == 0? 0:1;
//            bits1[i] += bits2[i];
//        }
//        for (int i = 0; i < 32; i++) {
//            if (bits1[i] > 1){
//                bits1[i] %= 2;
//                bits1[i+1]++;
//            }
//        }
//        System.out.println(Arrays.toString(bits1));
//        StringBuilder sb = new StringBuilder("");
//        for (int sum:bits1) sb.append(sum);
//        sb.reverse();
//
//        return Integer.parseInt(sb.toString(),2);
//    }
    public static void main(String[] args){
        System.out.println(
                new AddNum1Num2InSpecialMethod().Add(-1,2)
        );
        System.out.println(Integer.toBinaryString(-1));
    }
}
