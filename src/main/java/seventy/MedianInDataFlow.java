package seventy;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by Administrator on 2017/3/9.
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class MedianInDataFlow {
    /**
       @author zhengyanan
       @date 2017/3/9 @time 16:26
      version_2:
        核心思路：
            1.维护一个大顶堆，一个小顶堆，且保证两点：
                1）小顶堆里的全大于 大顶堆里的；
                2）2个堆个数的差值小于等于1
            2.当insert的数字个数为奇数时：使小顶堆个数比大顶堆多1；
              当insert的数字个数为偶数时，使大顶堆个数跟小顶堆个数一样。
            3.那么当总数字个数为奇数时，中位数就是小顶堆堆头；
                  当总数字个数为偶数时，中卫数就是 2个堆堆头平均数
       运行时间：43ms
       占用内存：699k
    */
    private PriorityQueue<Integer> min = new PriorityQueue<Integer>();
    private PriorityQueue<Integer> max = new PriorityQueue<Integer>(15,new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    private int count = 0;
    public void Insert(Integer num) {
        count++;
        if (count % 2 == 1){
            max.offer(num);//先从大顶堆过滤一遍
            min.offer(max.poll());
        }else {
            min.offer(num);//先从小顶堆过滤一遍
            max.offer(min.poll());
        }
    }

    public Double GetMedian() {
        if (count % 2 == 0)     return (min.peek() + max.peek())/2.0;
        else                    return (double)min.peek();
    }


    /**
       @author zhengyanan
       @date 2017/3/9 @time 16:08
      version_1:
        核心思路：
            1.直接维护一个链表，每次加入时，用直接插入的思想，放置在合适的位置。
    */
//    LinkedList<Integer> data = new LinkedList<Integer>();
//    public void Insert(Integer num) {
//        for (int i = data.size() - 1; i >= 0 ; i--) {
//            if (num >= data.get(i)){
//                data.add(i+1,num);
//                return;
//            }
//        }
//        data.addFirst(num);
//    }
//
//    public Double GetMedian() {
//        int size = data.size();
//        if (size% 2 == 1)   return (double)data.get(size/2);
//        else                return (data.get(size/2) + data.get(size/2 - 1))/2.0;
//    }
    public static void main(String[] args){
        LinkedList<Integer> test = new LinkedList<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(3,9);

        System.out.println(test);
    }
}
