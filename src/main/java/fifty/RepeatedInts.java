package fifty;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/3/2.
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
 * 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
 *
 *
 */
public class RepeatedInts {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false



    /**
       @author zhengyanan
       @date 2017/3/2 @time 19:38
      version_1:
        核心思路：
            1.已知所有数字都在0~n-1范围内，可以采用计数排序中的处理思路,创建一个长度为n的数组results，
            用results[i]表示数组中数字i出现的次数。
            2.循环一遍原数组，当访问到某个数字i时：
                如果results[i] == 0,说明之前没访问过i，就results[i]++；
                如果results[i] != 0,说明之前已经访问过i，i出现了至少两次，即为所求，直接返回即可。
    */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        System.out.println(Arrays.toString(numbers));
        if (numbers == null || numbers.length == 0) return false;
        System.out.println("********");
        int[] results = new int[numbers.length];

        for (int num:numbers){
            if (results[num] == 0)  results[num]++;
            else{
                duplication[0] = num;
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[] a = new int[2];
        int[] b = new int[1];
        System.out.println(new RepeatedInts().duplicate(a,5,b));
    }
}
