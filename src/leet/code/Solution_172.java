package leet.code;

/**
 * @author kxr
 * @date 2022/2/18 9:38 AM
 * @description
 *
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 *
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 *
 * 作者：字节校园
 * 链接：https://leetcode-cn.com/leetbook/read/bytedance-c01/ei6om6/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution_172 {


    public static int trailingZeroes(int n) {
        if(n == 0)
            return 0;
        int i=1;
        int t = 0;
        while (i<=n){
            int j = i;
            while (j%5==0){
                j=j/5;
                t++;
            }
            i++;
        }
        return t;

    }

    /**
     * 因为阶乘的尾部0的个数，是由 2*5 产生的。所以尾部0的个数是由 2*5 的个数决定的。
     * 然而 n！中 含2的因子个数 一定多于 5的因子数，所以算 1*2*3 -- *n 中含因子5的个数即可
     * @param n
     * @return
     */
    public int trailingZeroes1(int n) {
        int count = 0;
        while (n > 0){
            count += n / 5;
            n /= 5;
        }
        return count;
    }


    public static void main(String[] args) {
        trailingZeroes(5);
    }
}
