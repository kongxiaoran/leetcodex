package leet.code;

import java.lang.reflect.Parameter;

/**
 * @author kxr
 * @date 2022/2/9 7:54 PM
 * @description
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */

public class Solution_5 {

    public static String longestPalindrome(String s) {
        if(s == null || s.length()<1)
            return "";

        int start=0,end=0;
        for(int i=0;i<s.length();i++){

            //当回文长度为奇数个时 ***
            int n1 = Palindrome(s,i,i);

            //当回文长度为偶数个时 ***
            int n2 = Palindrome(s,i,i+1);
            int len = Math.max(n1,n2);

            if(len>end-start){
                // *** 重点【综合考虑奇数和偶数情况】
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }

    public static int Palindrome(String s,int start,int end){
        while (start>=0 && end<s.length() && s.charAt(start) == s.charAt(end)){
            --start;
            ++end;
        }
        return end-start-1;
    }

    public static void main(String[] args) {
        longestPalindrome("ababada");
    }
}
