package leet.code;

import java.util.Arrays;

/**
 * @author kxr
 * @date 2022/2/18 9:55 PM
 * @description
 *
 * 求数组中最长递增子序列
 *
 * 子序列（Subsequence）：“子序列”并不要求是连续子序列，只要保证元素前后顺序一致即可，例如：序列 [4, 6, 5] 是 [1, 2, 4, 3, 7, 6, 5] 的一个子序列；
 * 上升：这里“上升”要求严格“上升”。例如一个序列 [2, 3, 3, 6, 7] ，由于 3 重复了，所以不是严格“上升”的，因此它不是题目要求的“上升”序列。
 *
 * 例
 *  输入：[3,2,1,5,4,7]
 *  返回：3
 */
public class Solution_f2 {



    public static int maxlength(int[] n,int i,int[] m){
        int maxLength = 0;
        if(i == n.length-1)
            return 1;
        for(int j=i+1;j<n.length;j++){
            if(n[j]>n[i]){
                if(m[j]==-1){
                    maxLength = Math.max(maxLength,maxlength(n,j,m)+1);
                    m[j] = maxLength;
                }else {
                    maxLength = Math.max(maxLength,m[j]+1);
                }
            }
        }
        return maxLength;
    }

    public static int max(int[] n){
        int max = 0;
        int[] m = new int[n.length];
        Arrays.fill(m,-1);

        for(int i=0;i<n.length;i++){
            max = Math.max(max,maxlength(n,i,m));
        }
        return max;
    }



    public static void main(String[] args) {
        System.out.println(max(new int[]{1,5,2,4,3}));
        System.out.println(bestMax(new int[]{1,5,2,4,3}));
    }

    /**
     * 采用的不是递归算法，而是使用迭代。
     */
    public static int bestMax(int[] n){
        int[] m = new int[n.length];
        Arrays.fill(m,1);
        for(int i=n.length-1;i>=0;i--){
            for(int j=i+1;j<n.length;j++){
                if(n[i]<n[j])
                    m[i] = Math.max(m[i],m[j]+1);
            }
        }
        int max = 0;
        for(int i:m)
            max = i>max?i:max;
        return max;
    }
}
