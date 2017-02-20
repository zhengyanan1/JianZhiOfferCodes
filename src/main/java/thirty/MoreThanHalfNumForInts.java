package thirty;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/2/17.
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNumForInts {


    /**
       @author zhengyanan
       @date 2017/2/17 @time 11:39
       version_4：（同version_3）
      核心思路：
        剑指offer中推荐的解法二，同version_3思想是一样的。
        1.用一个count初始值设为0.还有一个num值
        2.遍历数组：
            if count== 0 :      num 记下当前遍历值，count++；
            else if count>0:    比较num和当前是否相同，相同就count++；不相同就count--；
        3.遍历完留下的num的值即为可能的结果。
        4.再遍历一遍，判断num是否为所求：是就返回num；否则就返回0；
        相比version_3的改进：
            去掉了繁杂的add remove操作，优化了时间空间复杂度
       复杂度： 时间O(n);空间O(1)
       运行时间：38ms
       占用内存：528k

     */

    public int MoreThanHalfNum_Solution(int [] array) {
        int level = array.length/2 + 1;
        int count = 0,goal = -1;

        for (int num:array){
            if (count == 0){
                goal = num;
                count++;
            }
            else if (goal == num){
                    count++;
            }
            else {
                    count--;
            }
        }

        count = 0;
        for (int num:array){
            if (num == goal)    count++;
        }
        if (count >= level) return goal;

        return 0;
    }


    /**
       @author zhengyanan
       @date 2017/2/17 @time 10:48
        version_3:
        核心思路：
            1.题目要找的是超过数组长度的一般的数字，也就是说，每次从数组中去掉2个不一样的数字，
            最后剩下的数字就可能是要找的数字，如果不是，那就没有。
            2.用一个栈实现本题思想。
       复杂度： 时间O(n);空间O(n)
       运行时间：29ms
       占用内存：629k
    */

//    public int MoreThanHalfNum_Solution(int [] array) {
//        int level = array.length/2 + 1,count = 0;
//        LinkedList<Integer> results = new LinkedList<Integer>();
//        for (int num:array){
//            if (results.isEmpty()){
//                results.addFirst(num);
//            }
//            else if (results.getFirst() != num){
//                    results.removeFirst();
//            }
//            else {
//                    results.addFirst(num);
//            }
//        }
//
//        if (results.isEmpty())  return 0;
//        else {
//            int goal = results.getFirst();
//            for(int num:array){
//                if (num == goal)    count++;
//            }
//            if (count >= level) return goal;
//            else                return 0;
//        }
//    }

    /**
       @author zhengyanan
       @date 2017/2/17 @time 10:27
       version_2:
        核心思路：
            1.类比计数排序的处理方式，新创建一个数组，用数组下标 记忆 原数组中的值。
            （PS：此种情况需要明确的保证原数组中的值处于一个相对较小的范围才可以。）
        复杂度：时间：O(n+k)，空间 O(k)
    */
//    public int MoreThanHalfNum_Solution(int [] array) {
//        int level = array.length/2 + 1;
//        int[] result = new int[100];
//        for (int num:array){
//            result[num] ++;
//        }
//        for (int i = 0; i < result.length; i++) {
//            if (result[i] >= level) return i;
//        }
//        return 0;
//    }


    /**
       @author zhengyanan
       @date 2017/2/17 @time 9:57
       version_1：
        核心思路：
            1.用一个HashMap,key中记下num值，value记下num出现的次数；
            2.遍历完一遍原数组，填好Map中的数据；再遍历一遍Map，看是否存在满足条件的数即可
        复杂度：时间 O(n); 空间O(n)
       运行时间：33ms
       占用内存：528k
    */
//    public int MoreThanHalfNum_Solution(int [] array) {
//        int level = array.length/2 + 1;
//        HashMap<Integer,Integer> results = new HashMap<Integer, Integer>();
//
//        for (int num:array){
//            int value = (results.get(num) == null ? 0:results.get(num));
//            value++;
//            results.put(num,value);
//        }
//
//        for (int key:results.keySet()){
//            if (results.get(key) >= level)  return key;
//        }
//
//        return 0;
//    }
    public static void main(String[] args){
        System.out.println("MoreThanHalfNumForInts.main():" +
                new MoreThanHalfNumForInts().MoreThanHalfNum_Solution(
                        new int[]{2,2,2,2,2,1,3,4,5}));
    }
}
