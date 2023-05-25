package leet.code;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kxr
 * @date 2022/4/3 3:59 PM
 * @description
 *
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数 myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 *
 *
 * 输入：s = "42"
 * 输出：42
 * 解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
 * 第 1 步："42"（当前没有读入字符，因为没有前导空格）
 *          ^
 * 第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 *          ^
 * 第 3 步："42"（读入 "42"）
 *            ^
 * 解析得到整数 42 。
 * 由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution_8 {

//    public static int myAtoi(String s) {
//        int result = 0;
//        byte[] bytes = s.getBytes();
//
//        boolean isPositive = true;
//        boolean isStart = false;
//        boolean hasFlag = false;
//        for(int i=0;i<bytes.length;i++){
//
//            int k = bytes[i];
//            if(k==32)
//                continue;
//            if(k==45){
//                isPositive = false;
//                if(!hasFlag){
//                    hasFlag = true;
//                    continue;
//                }
//            }
//            if(k==43){
//                if(!hasFlag){
//                    hasFlag = true;
//                    continue;
//                }
//            }
//
//            if(!isStart && k!=32)
//                isStart = true;
//            if(isStart){
//                if(48<=k && k<=58){
//                    try {
//                        //如果 result*10 大于 Integer.MAX_VALUE，会导致计算不准 出现问题,所以这里处理一下
//                        if(result>=Integer.MAX_VALUE/10-(k-48))
//                            throw new Exception();
//                        result=(result*10)+(k-48);
//                    }catch (Exception e){
//                        return isPositive==false?Integer.MIN_VALUE:Integer.MAX_VALUE;
//                    }
//                }else {
//                    return result;
//                }
//            }
//        }
//        return isPositive==false?0-result:result;
//    }

    public int myAtoi1(String s){

        boolean flag = true;
        Automation automation = new Automation();
        for(int i=0;i<s.length() && flag;i++){
            flag = automation.get(s.charAt(i));
        }
        return (int)(automation.sign * automation.result);
    }


    public static void main(String[] args) {
        System.out.println(new Solution_8().myAtoi1("+1"));;
    }

    class Automation{

        public int sign = 1;
        public long result = 0;
        private String status = "start";
        // 状态转化表
        private Map<String,String[]> table = new HashMap<String, String[]>(){{
               put("start",new String[]{"start","signed","in_number","end"});
               put("signed",new String[]{"end","end","in_number","end"});
               put("in_number",new String[]{"end","end","in_number","end"});
               put("end",new String[]{"end","end","end","end"});
        }};

        public boolean get(char a){
            status = table.get(status)[toStatus(a)];
            if(status.equals("in_number")){
                result = result * 10 + a - '0';
                result = sign == 1 ? Math.min(result, (long) Integer.MAX_VALUE) : Math.min(result, -(long) Integer.MIN_VALUE);
            }else if(status.equals("signed")){
                sign = (a == '+'?1:-1);
            }
            return status.equals("end")?false:true;

        }

        public int toStatus(char a){
            if(a == ' ')
                return 0;
            if(a == '+' || a=='-')
                return 1;
            if(Character.isDigit(a))
                return 2;
            return 3;
        }
    }

}
