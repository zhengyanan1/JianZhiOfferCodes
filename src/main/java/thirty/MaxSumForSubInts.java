package thirty;

/**
 * Created by Administrator on 2017/2/20.
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,
 * 当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
 * 并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class MaxSumForSubInts {

    /**
       @author zhengyanan
       @date 2017/2/20 @time 15:07
       version_4:
       核心思路：
            1.在version-3动态规划的基础上进一步优化，去掉动态规划用到的辅助数组
       复杂度：时间O(n)；空间O(1)
       运行时间：29ms
       占用内存：629k
    */
    public int FindGreatestSumOfSubArray(int[] array) {
        int maxSum = Integer.MIN_VALUE,currentSum = 0;
        for (int a:array){
            if (currentSum <= 0)    currentSum = a;
            else                    currentSum += a;

            if (currentSum > maxSum)    maxSum = currentSum;
        }

        return maxSum;
    }
}
