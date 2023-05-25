package leet.code;

/**
 * @author kxr
 * @date 2022/2/12 6:01 PM
 * @description
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_7 {


    /**
     * 首先   通过判断x的正负数，为负数做准备。将负号提出，然后就可以做为正数进行处理
     * 通过 %、/不断 从x的尾部提出数字（个位），提取出的数字不为0，则依次拼接
     * 就可以得到反转后的数字
     * @param x
     * @return
     */
    public static int reverse(int x) {
        StringBuilder s = new StringBuilder();
        boolean flag = false;
        if(x == 0)
            return 0;
        int posNum = x>0?1:-1;
        if(posNum == -1){
            x=0-x;
        }
        while (x>0){
            int t = x%10;
            if(t!=0)
                flag = true;
            x=x/10;
            if(flag)
                s.append(t);
        }
        try{
            return posNum>0?new Integer(s.toString()):0-new Integer(s.toString());
        }catch(Exception e){
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution_7.reverse(-120));
    }
}
