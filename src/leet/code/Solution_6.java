package leet.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kxr
 * @date 2022/2/12 3:37 PM
 * @description
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution_6 {


    public static String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        List<StringBuilder> rows = new ArrayList<>();
        for(int i=0;i<Math.min(numRows,s.length());i++){
            rows.add(new StringBuilder());
        }

        int cRow=0;
        boolean down = false;
        for(char a : s.toCharArray()){
            rows.get(cRow).append(a);
            if(cRow == 0 || cRow==numRows-1)
                down=!down;
            cRow += down?1:-1;
        }
        StringBuilder result = new StringBuilder();
        for(StringBuilder b:rows){
            result.append(b);
        }
        return result.toString();

    }

    public static void main(String[] args) {
        String s = convert("ABCDEFGHMJK", 4);
        System.out.println(s);
    }
}
