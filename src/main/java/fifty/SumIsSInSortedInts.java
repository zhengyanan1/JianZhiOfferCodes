package fifty;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/28.
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class SumIsSInSortedInts {
    /**
       @author zhengyanan
       @date 2017/2/28 @time 10:26
      version_2:
        核心思路：
            1.取i = 0，j = array.length -1
                if array[i] + array[j] > sum:    j--;
                else if                ==   :    array[i],array[j]即为所求；
                else                        :    i++;
            2.如果多组就取乘积最小的，易知，乘积最小的就是差最大的，就是以上方式求得的第一组解即为所求
            3.按上述思路实现即可，这样就既不会遗漏，又能保证O(n)的效率
       复杂度：时间O(n)；空间O(1)。
       运行时间：30ms
       占用内存：629k
    */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int i = 0 , j = array.length - 1,t;
        while (i < j){
            t = array[i] + array[j];
            if (t > sum)        j--;
            else if (t == sum)  break;
            else                i++;
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        if (i < j) {
            result.add(array[i]);
            result.add(array[j]);
        }
        return result;
    }

    /**
       @author zhengyanan
       @date 2017/2/28 @time 10:26
      version_1:
        核心思路：
            1.直接2重循环，暴力求解，最坏情况O(n*n)
    */
}
