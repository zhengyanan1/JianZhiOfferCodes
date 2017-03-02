package fourty;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Administrator on 2017/2/27.
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 */
public class TwoOnlyOnceIntInInts {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果

    /**
       @author zhengyanan
       @date 2017/2/27 @time 20:15
       version_2:
       核心思路：异或
            1.易知，2个相同的数字异或的结果是0，0和n异或的结果是n。
            所以：如果有2n+1个数字，其中只有一个数字出现了一次，其他的数字都出现了2次，则将这些数字异或，
            所得结果即为那个只出现了一次的数字。
            2.这里，将所有数字异或，所得结果r就是所求的2个数字异或的结果。因为这2个数字不同，所以r不为0.
            从右往左找到r的第一个不为0的位，根据这一位可以将原数组分成2部分（0或1）。
            3.从而将这2个只出现一次的数字恰好分到这两部分中。
            4.然后再根据1，分别异或这两部分 ，所得的2个结果即为所求。
    */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int r = 0,level;
        num1[0] = num2[0] = 0;
        for (int num : array) {
            r ^= num;
        }

        for (level = 0; level < 32; level++) {
            if ((r & (1 << level)) != 0)    break;
        }

        for (int num:array){
            if ((num & (1 << level)) != 0)  num1[0] ^= num;
            else                            num2[0] ^= num;
        }
    }


    /**
     @author zhengyanan
     @time 11:50
     @description
     version_1:
     核心思路：
     1.利用Set，遍历一遍数组，如果Set里包含这个元素，就删掉；否则就加入。
     2.一趟遍历下来，Set里只剩下了那2个只出现一次的数字。

     */
//    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
//        //num1,num2分别为长度为1的数组。传出参数
//        //将num1[0],num2[0]设置为返回结果
//        Set<Integer> results = new HashSet<Integer>();
//        for (int num:array){
//            if (results.contains(num))  results.remove(num);
//            else                        results.add(num);
//        }
//        Iterator<Integer> re = results.iterator();
//        num1[0] = re.next();
//        num2[0] = re.next();
//    }

}
