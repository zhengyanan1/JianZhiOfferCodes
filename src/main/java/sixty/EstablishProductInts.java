package sixty;

/**
 * Created by Administrator on 2017/3/3.
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class EstablishProductInts {


    /**
       @author zhengyanan
       @date 2017/3/3 @time 15:36
      version_3:
        核心思路：
            1.不用动态规划，直接乘。
        复杂度：时间O(n*n)；空间O(1)。
       运行时间：32ms
       占用内存：629k
    */
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = 1;
            for (int j = 0; j < A.length; j++) {
                if (j == i) continue;
                B[i] *= A[j];
            }
        }
        return B;
    }

    /**
       @author zhengyanan
       @date 2017/3/3 @time 15:25
      version_2:
        核心思路:
            1.在version_1代码的基础上进一步优化。
            2.动态规划：用C[i]记下从A[0]乘到A[i-1]的值；D[i]记下从A[i+1]乘到A[n-1]的值；
            3.那么b[i] = C[i] * D[i]
       复杂度：时间O(n)；空间O(n)
       运行时间：34ms
       占用内存：528k
    */
//    public int[] multiply(int[] A) {
//        int[] B = new int[A.length];
//        int[] C = new int[A.length];
//        int[] D = new int[A.length];
//
//        C[0] = 1;
//        D[A.length - 1] = 1;
//
//        for (int i = 1; i < A.length; i++)      C[i] = C[i-1] * A[i-1];
//        for (int i = A.length -2;i >= 0;i--)    D[i] = D[i+1] * A[i+1];
//        for (int i = 0; i < A.length; i++)      B[i] = C[i] * D[i];
//
//        return B;
//    }


    /**
       @author zhengyanan
       @date 2017/3/3 @time 15:20
      verison_1:
        核心思路：
            1.动态规划：用C[i]记下从A[0]乘到A[i]的值；D[i]记下从A[i]乘到A[n-1]的值；
            2.那么b[i] = C[i-1] * D[i+1];(C[-1] = 1;D[n] = 1).

       复杂度：时间O(n)；空间O(n)
       运行时间：31ms
       占用内存：528k
    */
//    public int[] multiply(int[] A) {
//        int[] B = new int[A.length];
//        int[] C = new int[A.length];
//        int[] D = new int[A.length];
//
//        for (int i = 0; i < A.length; i++) {
//            C[i] = 1;
//            D[i] = 1;
//        }
//
//        for (int i = 0; i < A.length; i++) {
//            if (i == 0) C[i] = A[i];
//            else        C[i] = C[i-1] * A[i];
//        }
//        for (int i = A.length - 1; i >= 0; i--) {
//            if (i == A.length - 1)  D[i] = A[i];
//            else                    D[i] = A[i] * D[i+1];
//        }
//        for (int i = 0; i < A.length; i++) {
//            if (i == 0)                 B[i] = D[1];
//            else if (i == A.length - 1) B[i] = C[i-1];
//            else                        B[i] = C[i-1] * D[i+1];
//        }
//
//        return B;
//    }
    public static void main(String[] args){
        int[] a = new int[]{1,2,3,4,5};
        System.out.println(new EstablishProductInts().multiply(a));
    }
}
