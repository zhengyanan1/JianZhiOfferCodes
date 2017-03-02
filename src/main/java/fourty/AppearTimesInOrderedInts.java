package fourty;

/**
 * Created by Administrator on 2017/2/23.
 * 统计一个数字在排序数组中出现的次数。
 */
public class AppearTimesInOrderedInts {


    /**
       @author zhengyanan
       @date 2017/2/23 @time 10:46
      verison_2:
        核心思路：
            1.继续优化version_1，不用二分+递归，而是直接采用纯二分法。
            2.先二分找到第一个k下标first，再二分找到最后一个k下标last，
            3.last-first+1即为所求。
            4.复杂度，O(lgN) + O(lgN) = O(lgN)
       复杂度：时间：O(lgN)；空间O(1)
       运行时间：34ms
       占用内存：528k
    */
    public int GetNumberOfK(int [] array , int k) {
        int first,last;
        first = getFirstKIndex(array,0,array.length - 1, k);
        if (first < 0)     return 0;
        else last = getLastIndex(array,0,array.length - 1,k);
        return last - first + 1;
    }

    private int getLastIndex(int [] array, int start,int end,int k){
        int current;
        while (start <= end){
            current = (start + end)/2;
            if (k == array[current]){
                if (current == end){
                    return current;
                }else if (array[current + 1] != k){
                    return current;
                }else {
                    start = current + 1;
                }
            }
            else if (k < array[current]){
                end = current - 1;
            }
            else {
                start = current + 1;
            }
        }

        return -1;
    }

    private int getFirstKIndex(int [] array, int start,int end,int k){
        int current;
        while (start <= end){
            current = (start + end)/2;
            if (k == array[current]){
                if (current == start){
                    return current;
                }
                else if (array[current - 1] != k){
                    return current;
                }
                else{
                    end = current - 1;
                }
            }
            else if (k < array[current]){
                end = current - 1;
            }
            else {
                start = current + 1;
            }
        }

        return -1;
    }


    /**
       @author zhengyanan
       @date 2017/2/23 @time 10:39
      version_1:
        核心思路：
            1.直接可以想到的一种方式是：直接遍历整个数组，时间复杂度O(n)；
            2.但题目说了是有序的，有序+查找，我们很自然的想到二分查找。
            3.此处的思路就出来了：
                1）先根据二分查找，找到第一个跟k相等的数array[current]；
                2）分别从current往前和往后遍历，计数即可。
        缺点：
            1.虽然用了二分查找，平均时间复杂度应该是小于O(n)的；但最坏情况下，
            假如整个array里每个数都是k的话，时间复杂度达到了O(n)。
       运行时间：28ms
       占用内存：629k
    */
//    public int GetNumberOfK(int [] array , int k) {
//        int start = 0,end = array.length - 1,current,result = 0;
//        while (start <= end){
//            current =(start + end)/2;
//            if (array[current] == k){
//                result++;
//                for (int i = current + 1;i < array.length && array[i] == k; i++)    result++;
//                for (int i = current - 1;i >= 0 && array[i] == k; i--)   result++;
//                return result;
//            }
//            else if (array[current] > k){
//                end = current - 1;
//            }
//            else {
//                start = current + 1;
//            }
//        }
//
//        return result;
//    }
}
