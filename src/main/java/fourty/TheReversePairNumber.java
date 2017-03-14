package fourty;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/3/13.
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class TheReversePairNumber {

    /**
       @author zhengyanan
       @date 2017/3/13 @time 17:59
      version_2:
        核心思路：
            1.参考《剑指offer》一书中的方法，基本类似归并排序的过程。
            2.就是进行了一次归并排序，但跟归并排序不同的地方在于：
                1）.在merge的时候，left和right是从高位往低位扫描的：
                2）.如果left[i] > right[j],说明right里下标小于等于j的都小于left[i]，所以逆序对数目要+(j+1);
                    然后把left[i]放到array里正确的位置，i--,继续扫描......
                3）.如果left[i] < right[j],就把right[j]放到array里正确的位置，j--，继续扫描......
       复杂度：时间O(n*lgn)；空间O(n)
       运行时间：367ms
       占用内存：4745k
    */
    private int count = 0;
    public int InversePairs(int [] array) {
        mergeSort(array,0,array.length - 1);

        return count;
    }

    public void mergeSort(int[] array,int start,int end){
        if (start < end){
            int middle = (start + end) / 2;
            mergeSort(array,start,middle);
            mergeSort(array,middle + 1,end);

            merge(array,start,middle,end);
        }
    }
    public void merge(int[] array,int start,int middle,int end){
        int leftSize = middle - start + 1;
        int rightSize = end - (middle + 1) + 1;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];


        for (int i = start; i <= middle ; i++)  left[i - start] = array[i];
        for (int i = middle + 1; i <= end ; i++)  right[i - (middle + 1)] = array[i];



        int i = middle - start,j = end - (middle + 1),k = end;
        while (i >= 0 && j >= 0){
            if (left[i] > right[j]){
                array[k] = left[i];

                count += j + 1;
                count -= count > 1000000007 ? 1000000007 : 0;

                k--;
                i--;
            }
            else{
                array[k] = right[j];

                k--;
                j--;
            }
        }
        while (i >= 0){
            array[k] = left[i];
            k--;
            i--;
        }
        while (j >= 0){
            array[k] = right[j];
            k--;
            j--;
        }
    }


    /**
       @author zhengyanan
       @date 2017/3/13 @time 16:10
      version_1:
        核心思路：
            1.直接冒泡排成升序，交换位置的次数即为逆序对的数目；
            (或者根据定义，直接遍历寻找当前值之后有多少个数值小于当前值)

     复杂度：时间O(n*n) (PS:经测试，发现复杂度太高，程序运行超时)
    */
    public int InversePairsColne(int [] array) {
        int count = 0;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i])    count++;
            }
        }

        return count % 1000000007;
    }

    public static void main(String[] args){
        int[] a = new int[]{
                364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575
        };
        int[] b = new int[]{
                2,4,3,1,5,8,7,6
        };
        System.out.println(Arrays.toString(b));
        System.out.println(new TheReversePairNumber().InversePairs(b));
        System.out.println(Arrays.toString(b));
//        System.out.println(new TheReversePairNumber().InversePairsColne(a));
    }
}
