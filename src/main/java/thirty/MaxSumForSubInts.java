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


      /**
    @author zhengyanan
    @time 22:35
    @description
     version_3:
     核心思路：动态规划
        1.新建一个f[]数组，f[i]表示以a[i]结尾的最大的子段和
        2.f[i] = max{f[i-1] + a[i],a[i]};
        3.f[0] = a[0];
        4.f[]求得后，遍历一遍即可得所求
    复杂度；时间O(n)；空间O(n)
    运行时间：30ms
    占用内存：503k
    */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 1)  return array[0];

        int length = array.length, max;
        int[] result = new int[length];

        result[0] = array[0];
        for (int i = 1; i < length; i++) {
            if (result[i-1] > 0)    result[i] = result[i-1]+array[i];
            else                    result[i] = array[i];
        }

        max = result[0];
        for (int i = 0; i < length; i++) {
            if (max < result[i])    max = result[i];
        }

        return max;
    }


    /**
    @author zhengyanan
    @time 22:28
    @description
    version_2
    核心思路：
        1.version_1改进版，优化了一些
        复杂度：时间O(n*n) 空间O(1)
    运行时间：27ms
    占用内存：503k

     */
//    public int FindGreatestSumOfSubArray(int[] array) {
//        int length = array.length;
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < array.length; i++) {
//            int sum = 0;
//            for (int j = i; j < array.length; j++) {
//                sum += array[j];
//                if (sum > max)  max = sum;
//            }
//        }
//        return max;
//    }


    /**
    @author zhengyanan
    @time 22:19
    @description
    version_1:
    核心思路：
        1.3重循环法(遍历所有情况)
    复杂度：时间O(n*n*n) 空间O(1)
    运行时间：29ms
    占用内存：629k
     */
//    public int FindGreatestSumOfSubArray(int[] array) {
//        int length = array.length;
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < array.length; i++) {
//            for (int j = i; j < array.length; j++) {
//                int sum = 0;
//                for (int k = i; k <= j ; k++) {
//                    sum += array[k];
//                }
//                if (sum > max)  max = sum;
//            }
//        }
//        return max;
//    }
}
