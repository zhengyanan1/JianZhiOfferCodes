package fifty;

import java.util.ArrayList;

/**
 * Created by ASUS on 2017/2/25.
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class SumOfContinueIntsIsS {

    /**
       @author zhengyanan
       @date 2017/2/28 @time 17:40
      version_2:
        核心思路：
            1.参考 有序数组中找2个数的和为S的做法。
                可以先取 small = 1，big = 2，sum = small + (small+1) + ... +big;
                如果sum < s :big++;
                如果sum ==s :从small 到big 即为一组解；
                如果sum > s :small++
            不断循坏，直到small == S/2为止。(即判断完S是否可以拆成2个数为止)
            2.将以上思路实现即可。
       运行时间：30ms
       占用内存：629k
    */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        int small = 1,big = 2,total;
        while (small < big){
            total = (big - small + 1)*(small +big)/2;
            if (total < sum)    big ++;
            else if (total == sum){
                ArrayList<Integer> oneResult = new ArrayList<Integer>();
                for (int i = small; i <= big; i++) oneResult.add(i);
                results.add(oneResult);
                //以small开头的结果已被记下了，将small++继续往后找
                small++;
            }
            else {
                small++;
            }
        }
        return results;
    }


    /**
    @author zhengyanan
    @time 12:40
    @description
        verison_1:
        核心思路：
            1.假设S能被拆成i个连续数字，那这i个连续数字肯定是：
                x+0,x+1,x+2,...,x+i-1.
            先令extra = 0 + 1 + 2 + ... + (i-1).
            则：(S - extra)/i == x.
            那么:x+0,x+1,x+2,...,x+(i-1)即为一个满足要求的连续正数序列
            2.令i从2开始往后取，不断循环的求。直到求得的 x<1时，跳出循环。
            3.i越大，连续数字越多，对应的第一个数字越小，按题目要求，对应的结果就应该插入到结果中更靠前的位置。
            4.将上述思想实现即可
    运行时间：35ms
    占用内存：629k
     */
//    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
//        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
//        int extra,smallest;
//
//        for (int i = 2;; i++) {
//            extra = 0;
//            ArrayList<Integer> oneResult = new ArrayList<Integer>();
//
//            extra = (0 + i-1) * i / 2;
////            for (int j = 1; j < i; j++)     extra += j;   //求extra的更直白的方式
//            smallest = (sum - extra)/i;
//            if (smallest < 1)   break;
//            if (smallest * i == sum - extra)
//                for (int j = 0; j < i; j++)     oneResult.add(smallest+j);
//            else    continue;
//
//            results.add(0,oneResult);
//        }
//
//        return results;
//    }
}
