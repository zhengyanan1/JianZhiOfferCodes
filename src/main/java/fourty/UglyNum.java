package fourty;

/**
 * Created by Administrator on 2017/2/22.
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class UglyNum {
    /**
       @author zhengyanan
       @date 2017/2/22 @time 11:54
      version_2:
        核心思路：
            1.动态规划，根据前面计算出的n-1个丑数，求得当前第n个丑数；
            2.根据丑数性质易知：第n个丑数肯定是前面所有丑数分别*2或者*3或者*5中最小的那个丑数。
            3.可以额外加3个下标标记min2，min3，min5，分别记忆乘以2大于当前访问丑数的最小丑数下标，
            乘以3大于当前访问丑数的最小丑数下标，乘以5大于当前丑数的最小丑数下标。然后比较，其中最小的
            即为当前要求得第n个丑数，然后把所取的那个minX++值更新一下（要始终保持uglyNums[minX]*X >
            当前的最大一个丑数，而且是大于的里面最小的）
            4.不断迭代求出结果即可。
            5.用O(n)的空间，换取了时间效率
        复杂度：输入数值n，对应的时间O(n)；空间O(n)
       运行时间：36ms
       占用内存：654k
    */
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) return 0;

        int[] uglyNums = new int[index];
        uglyNums[0] = 1;
        int min2 = 0,min3 = 0,min5 = 0;
        for (int i = 1; i < index; i++) {
            uglyNums[i] = min(uglyNums[min2] * 2,uglyNums[min3] * 3,uglyNums[min5] * 5);

            if (uglyNums[i] == uglyNums[min2] * 2)  min2++;
            if (uglyNums[i] == uglyNums[min3] * 3)  min3++;
            if (uglyNums[i] == uglyNums[min5] * 5)  min5++;
        }
        return uglyNums[index - 1];
    }

    private int min(int a,int b,int c){
        int t = a < b ? a : b;
        return t < c ? t : c;
    }
    /**
       @author zhengyanan
       @date 2017/2/22 @time 10:54
     version_1:
        核心思路：
            1.从1往后遍历，每遇到一个数就判断它是不是丑数。
        缺点：
            1.复杂度太高，经测试，第1000个丑数是51018336，绝大部分情况都是在判断非丑数，效率太低。
    */
//    public int GetUglyNumber_Solution(int index) {
//        int num = 0;
//        while (index > 0){
//            num++;
//            if (isUglyNum(num)){
//                index--;
//            }
//        }
//        return num;
//    }
//    private boolean isUglyNum(int num){
//        while (num % 2 == 0) {
//            num /= 2;
//        }
//        while (num % 3 == 0) {
//            num /= 3;
//        }
//        while (num % 5 == 0) {
//            num /= 5;
//        }
//
//        if (num == 1)   return true;
//        return false;
//    }
    public static void main(String[] args){
        for (int i = 0; i < 1000; i++) {
            System.out.println(new UglyNum().GetUglyNumber_Solution(i));
        }
    }
}
