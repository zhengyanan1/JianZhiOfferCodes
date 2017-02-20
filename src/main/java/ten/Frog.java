package ten;

/**
 * Created by Administrator on 2016/12/26.
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 */
public class Frog {
    public int JumpFloor(int target) {
        /**
           @author zhengyanan
           @date 2016/12/26 @time 11:15
           version_3:
           version_2改良版，不用那么多额外的空间，每次只记前2个并不断更新即可；
           运行时间：35ms
           占用内存：654k
        */
        if (target == 1)    return 1;
        if (target == 2)    return 2;
        int fn1 = 2,fn2 = 1;
        while (target > 2){
            fn1 += fn2;
            fn2 = fn1 - fn2;
            target--;
        }
        return fn1;

        /**
           @author zhengyanan
           @date 2016/12/26 @time 11:10
            version——2
          思路：
         verson_1改良版，在确定递推式没问题的前提下，改良为动态规划版
           运行时间：32ms
           占用内存：503k
        */
//        if (target == 1)    return 1;
//        if (target == 2)    return 2;
//        int[] result = new int[target + 1];
//        result[1] = 1;
//        result[2] = 2;
//        for (int i = 3; i <= target; i++) {
//            result[i] = result[i-1] + result[i-2];
//        }
//        return result[target];

        /**
           @author zhengyanan
           @date 2016/12/26 @time 11:06
          version_1
         思路：
         理解题意，发现result类似 斐波那契数列，递归即可
        */
//        if (target == 1)    return 1;
//        if (target == 2)    return 2;
//        return JumpFloor(target-1) + JumpFloor(target-2);
    }
}
