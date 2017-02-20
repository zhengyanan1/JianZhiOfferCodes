package thirty;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by Administrator on 2017/2/17.
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class SmallestKNumber {


    /**
       @author zhengyanan
       @date 2017/2/17 @time 17:15
      version_4:
        使用堆排序
        (待完成)
    */

    /**
       @author zhengyanan
       @date 2017/2/17 @time 17:05
      version_3:
        核心思路：
            使用TreeSet
            （PS:此种方式必须确保input中没有相等的数字）
    */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input.length < k)     return new ArrayList<Integer>();

        TreeSet<Integer> result = new TreeSet<Integer>();
        for (int num : input)   result.add(num);

        ArrayList<Integer> results = new ArrayList<Integer>();

        int i = 0;
        for (int sum : result){
            if (i == k) break;
            i++;
            results.add(sum);
        }
        return  results;
    }



    /**
       @author zhengyanan
       @date 2017/2/17 @time 16:32
      version_2:
        可对version_1进行一些稍微的优化：
            1.如果k>length/2,就冒泡找出最大的length-k个，剩下的就是所求；
            2.如果k<length/2,就冒泡找出最小的k个，即为所求。
        此处不予实现
    */

    /**
       @author zhengyanan
       @date 2017/2/17 @time 16:14
        version_1:
        核心思路:
        1.以冒泡方式进行，冒泡k遍，筛选出k个最小的数
       复杂度：时间O(k*n)； 空间O(1)
       运行时间：36ms
       占用内存：654k

    */
//    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
//        int length = input.length;
//        if (length < k)     return new ArrayList<Integer>();
//
//        for (int i = 0; i < k ; i++) {
//            for (int j = length - 1 ; j > i ; j--) {
//                int t;
//                if (input[j] < input[j-1]){
//                    t = input[j];
//                    input[j] = input[j-1];
//                    input[j-1] = t;
//                }
//            }
//        }
//
//        ArrayList<Integer> results = new ArrayList<Integer>();
//
//        for (int i = 0; i < k; i++) {
//            results.add(input[i]);
//        }
//        return results;
//    }
}
