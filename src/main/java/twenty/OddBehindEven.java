package twenty;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/26.
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class OddBehindEven {
    public void reOrderArray(int [] array) {

        int left = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1){
                int temp = array[i];
                for (int j = i; j > left; j--) {
//                    System.out.println("OddBehindEven.reOrderArray():" + j +";"+ (j - 1));
                    array[j] = array[j-1];
                }
                array[left ++] = temp;
                System.out.println(Arrays.toString(array));
            }
        }
        /**
           @author zhengyanan
           @date 2016/12/26 @time 20:43
          version_4:
            思路：还是移位的方式，但一次移动多个元素。
            * 1.要想保证原有次序，则只能顺次移动或相邻交换。
            * 2.i从左向右遍历，找到第一个偶数。
            * 3.j从i+1开始向后找，直到找到第一个奇数。
            * 4.将[i,...,j-1]的元素整体后移一位，最后将找到的奇数放入i位置，然后i++。
            * 5.終止條件：j向後遍歷查找失敗。
            参考官方答案
           运行时间：34ms
           占用内存：629k
        */
        // @author zyn 20:45 2016/12/26
        //            待完成


        /**
           @author zhengyanan
           @date 2016/12/26 @time 20:42
          version_3:
            思路：可以利用 直接插入 的思想来处理
        */


//        ArrayList<Integer> odd = new ArrayList<Integer>();
//        ArrayList<Integer> even = new ArrayList<Integer>();
//        for (int num :
//                array) {
//            if (num % 2 == 0){
//                even.add(num);
//            }else {
//                odd.add(num);
//            }
//        }
//        for (int i = 0; i < odd.size(); i++) {
//            array[i] = odd.get(i);
//        }
//        for (int i = odd.size(); i < array.length; i++) {
//            array[i] = even.get(i - odd.size());
//        }

        /**
           @author zhengyanan
           @date 2016/12/26 @time 20:08
          version_2
           Time: O(n)
           Space:O(n)
          思路：
          可以先把奇数 筛 出来放一起，偶数筛出来放一起，再重置回原数组

        */


        /**
           @author zhengyanan
           @date 2016/12/26 @time 20:02
          version_1
           运行时间：33ms   O(n^2)
           占用内存：503k    O(1)
          思路：类比 冒泡排序
            如果前一个是偶数，后一个是奇数，把它俩交换顺序。(交换它俩并木有改变所有奇数的相对顺序和 所有偶数的相对顺序)
            至多循环n-1遍，就能把数组换成 先 奇数 再 偶数，且奇数的相对位置不变；偶数的相对位置不变。
          如果某一趟一次交换都没发生，说明已完成，跳出循环即可。
        */
//        for (int i = 0; i < array.length - 1; i++) {
//            int temp = -1;
//            for (int j = 0; j < array.length - i - 1; j++) {
//                if (array[j] % 2 == 0 && array[j+1] % 2 == 1){
//                    temp = array[j];
//                    array[j] =array[j+1];
//                    array[j+1] = temp;
//                }
//            }
//            if (temp == -1) break;
//        }
    }
    public static void main(String[] args){
        int[] data = new int[]{1,2,3,4,5,6,7,8,9};
        new OddBehindEven().reOrderArray(data);
        System.out.println(Arrays.toString(data));
    }
}
