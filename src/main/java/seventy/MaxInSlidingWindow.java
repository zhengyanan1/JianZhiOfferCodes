package seventy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/3/10.
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}
 * 及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}
 * 的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，{2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class MaxInSlidingWindow {

    /**
     @author zhengyanan
     @time 16:43
     @description
     version_2:
     核心思路：
     1.用一个双端队列，队列第一个位置保存当前窗口的最大值的下标，当窗口滑动一次
     1).判断当前最大值是否过期
     2).新增加的值从队尾开始比较，把所有比他小的值丢掉
     （PS：每一个索引都会加入队列，不过在加入前会将队列中小于当前值的都删掉）
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        LinkedList<Integer> maxQueue = new LinkedList<Integer>();

        if (size == 0 || num.length == 0)   return result;
        for (int i = 0; i < num.length; i++) {
            int windowsIndex = i - size + 1;//当前窗口的索引，取窗口的索引为其中第一个元素的下标(窗口里元素必须是满的)

            if (maxQueue.isEmpty())                         maxQueue.addLast(i);//如果最大值队列为空，直接加入
            else if (maxQueue.getFirst() < windowsIndex)    maxQueue.removeFirst();//判断当前最大值是否出了窗口

            while (!maxQueue.isEmpty() && num[maxQueue.getLast()] <= num[i])
                maxQueue.removeLast();
            maxQueue.addLast(i);
            //当前访问到了num[i],也就是说，num[i]肯定在窗口内，那么最大值队列中小于Num[i]的都可以移除掉了

            System.out.println(maxQueue+"---");
            if (windowsIndex >= 0)  result.add(num[maxQueue.getFirst()]);
        }

        return result;
    }

    /**
       @author zhengyanan
       @date 2017/3/10 @time 11:16
      version_1:
        核心思路：
            1.从头开始遍历，每次从当前位置往后扫size个数字，用简单选择的方式找到对应的max值即可。
       复杂度：时间O(size*n);空间O(1)
       运行时间：34ms
       占用内存：503k
    */
//    public ArrayList<Integer> maxInWindows(int [] num, int size){
//        ArrayList<Integer> result = new ArrayList<Integer>();
//        if (0 == size)  return result;
//
//        for (int i = 0; i <= num.length - size; i++) {
//            int max = num[i];
//            for (int j = i + 1; j < size + i; j++) {
//                if (max < num[j])   max = num[j];
//            }
//            result.add(max);
//        }
//
//        return result;
//    }
    public static void main(String[] args){
        HashMap<Integer,Integer> data = new HashMap<Integer, Integer>();
        data.put(1,32);
    }
}
