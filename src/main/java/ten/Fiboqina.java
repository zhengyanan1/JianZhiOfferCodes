package ten;

/**
 * Created by Administrator on 2016/12/26.
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项。n<=39
 *
 */
public class Fiboqina {


    public int Fibonacci(int n) {

        /**
           @author zhengyanan
           @date 2016/12/26 @time 10:49
           思路：
           类似version——2，但省去了额外占用的内存
           运行时间：30ms
           占用内存：503k
        */
        int fn1 = 1,fn2 = 1;
        if (0 == n) return 0;
        else if (n == 1 || n == 2)  return 1;

        while (n > 2){
            fn1 += fn2;
            fn2 = fn1 - fn2;
            n--;
        }
        return fn1;


        /**
           @author zhengyanan
           @date 2016/12/26 @time 10:24
          version——2
         思路：存在重叠子问题，最优子结构，所以采用简易版动态规划法；
           运行时间：31ms
           占用内存：688k
        */
//        if (0 == n) return 0;
//        else if (n == 1 || n == 2)  return 1;
//        int[] result = new int[n + 1];
//        result[1] = result[2] = 0;
//        for (int i = 3; i <= n ; i++) {
//            result[i] = result[i-1] + result[i-2];
//        }
//        return result[n];

        /**
         @author zhengyanan
         @date 2016/12/26 @time 10:11
         version_1 :
         思路：根据定义即可
         运行时间：873ms
         占用内存：629k
         */
//        if (0 == n) return 0;
//        else if (n == 1)    return 1;
//        else if (n == 2)    return 1;
//        else return Fibonacci(n-1)+Fibonacci(n-2);
    }

    public static void main(String[] args){
        System.out.println("Fiboqina.main():" + new Fiboqina().Fibonacci(39));
    }
}
