package fourty;

/**
 * Created by Administrator on 2017/2/20.
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 */
public class TimesOfOneFromOneToN {



    /**
       @author zhengyanan
       @date 2017/2/20 @time 15:53
     version_1:
     核心思路：
        1.分别判断每一位上1出现过的次数，从个位往高位递推；
        2.对于当前处理的位，需要根据其值是0,1，还是>1 对应有不同的处理。
            例如，假设当前考虑百位：
            (1)如果百位>1,那么百位上1的次数 = (n/100 + 1) * 100;由高位和低位共同决定
            (2)如果百位=1，那么百位上1的数次 = (n/100) * 100 + (n%100 + 1)；由高位和低位共同决定
            (3)如果百位<1，那么百位上1的次数 = (n/100) * 100;由高位决定。
       3.按照上面举例的思路类推，即可求得结果。
     复杂度：时间O(lgN)；空间O(1)
       运行时间：30ms
       占用内存：503k

    */
    public int NumberOf1Between1AndN_Solution(int n) {
        int times = 0,current, addOne = 0,powerOfTen = 0,n2 = n;

        while (n > 0){
            current = n % 10;
            n /= 10;

            if (current > 1) {
                addOne = 1;
            }
            else if (current == 1){
                times += (n2 % Math.pow(10,powerOfTen)) + 1;
            }
            times += (n + addOne) * Math.pow(10, powerOfTen);

            powerOfTen++;
            addOne = 0;
        }

        return times;
    }
    public static void main(String[] args){
        System.out.println("TimesOfOneFromOneToN.main():" + (2 % 1));
    }
}
