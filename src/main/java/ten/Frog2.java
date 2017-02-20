package ten;

/**
 * Created by Administrator on 2016/12/26.
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 */
public class Frog2 {
    public int JumpFloorII(int target) {
        /**
           @author zhengyanan
           @date 2016/12/26 @time 11:38
          version_2:
           运行时间：28ms
           占用内存：629k
         思路：
         分析递推式，发现可以进一步化简
         f(n) = 2 * f(n-1) = 2^n-2 *　f(2) = 2^n-1 * f(1) = 2^n-1;
        */
//        if (target == 1)    return 1;
//        if (target == 2)    return 2;

        return (int)Math.pow(2,target - 1);
        /**
           @author zhengyanan
           @date 2016/12/26 @time 12:03
           return 1<<target-1;以移位方式 *2 ，更简洁高效
           运行时间：27ms
           占用内存：503k
         */

        /**
           @author zhengyanan
           @date 2016/12/26 @time 11:31
          version_1
           运行时间：31ms
           占用内存：629k
           时间复杂度：O(n*n)
           空间复杂度:O(n)
         思路：理解题意，变态是什么意思。
         f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(1) + 1;
         然后进行递归或者动态规划达成此效果即可。

           但鉴于此处拆开的项太多，若递归，重复计算的太多。
         所以此处使用动态规划的方法，减少一些重复计算，但需要额外空间 O(n)。
         时间复杂度O(n*n).

        */
//        if (target == 1)    return 1;
//        else if (target == 2)   return 2;
//        int[] result = new int[target + 1];
//        result[1] = 1;
//        result[2] = 2;
////        result[3] = 4;
//        for (int i = 3; i <= target; i++) {
//            for (int j = 1; j < i; j++) {
//                result[i] += result[j];
//            }
//            result[i] ++;
//        }
//        return  result[target];
    }
}
