package twenty;

/**
 * Created by Administrator on 2016/12/26.
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class int_power {
    public double Power(double base, int exponent) {

        return Math.pow(base,exponent);
        /**
           @author zhengyanan
           @date 2016/12/26 @time 17:17
          version_2:
            思路：直接调用java API：
           运行时间：37ms
           占用内存：503k
        */

        /**
           @author zhengyanan
           @date 2016/12/26 @time 17:16
            version_1 :
         思路：根据定义，分析各种情况并进行处理
           运行时间：38ms
           占用内存：528k
        */
//        double result = 1;
//        if (exponent > 0){
//            for (int i = 0; i < exponent; i++) {
//                result *= base;
//            }
//        }
//        else if (exponent == 0){
//            if (base != 0)  return 1;
//            else throw new RuntimeException("base is Zero!");
//        }
//        else {
//            if (base == 0)  {
//                throw new RuntimeException("base is Zero!");
//            }else {
//                for (int i = 0; i < -exponent; i++) {
//                    result *= base;
//                }
//            }
//            result = 1/result;
//        }
//        return result;
    }
}
