package leet.code;

import java.util.Scanner;

/**
 * @author kxr
 * @date 2022/2/18 2:58 PM
 * @description
 *
 * 古生物血缘远近判定
 * DNA 是由 ACGT 四种核苷酸组成，例如 AAAGTCTGAC，假定自然环境下 DNA 发生异变的情况有：
 *
 * 基因缺失一个核苷酸
 * 基因新增一个核苷酸
 * 基因替换一个核苷酸
 * 且发生概率相同。
 * 古生物学家 Sam 得到了若干条相似 DNA 序列，Sam 认为一个 DNA 序列向另外一个 DNA 序列转变所需的最小异变情况数可以代表其物种血缘相近程度，异变情况数越少，血缘越相近，请帮助 Sam 实现获取两条 DNA 序列的最小异变情况数的算法。
 *
 * 作者：字节校园
 * 链接：https://leetcode-cn.com/leetbook/read/bytedance-c01/eug83v/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution_f1 {

    private static int minNum(String pre, String cur){
        int preLen = pre.length(), curLen = cur.length();
        if(preLen == 0 || curLen == 0)
            return preLen == 0? curLen : preLen;
        int[][] dp = new int[preLen + 1][curLen + 1];
        dp[0][0] = 0;
        for(int i = 1; i <= preLen ; i ++)
            dp[i][0] = i;
        for(int j =1 ; j <= curLen ; j ++)
            dp[0][j] = j;
        for(int i = 1; i <= preLen; i++){
            for(int j = 1; j <= curLen; j++){
                if(pre.charAt(i-1) != cur.charAt(j-1))
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                else
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1],dp[i-1][j]) + 1);
            }
        }
        return dp[preLen][curLen];
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String input = "";
        if (scan.hasNext()) {
            input = scan.nextLine();
        }
        scan.close();
        String[] array = input.split(",");
        System.out.println(minNum(array[0] , array[1]));
    }

/*    作者：GCRoots不可达
    链接：https://leetcode-cn.com/leetbook/read/bytedance-c01/eug83v/?discussion=18PgtX
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
