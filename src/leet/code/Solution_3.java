package leet.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author kxr
 * @date 2022/1/29 3:04 PM
 * @description
 *
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
class Solution_3 {

    public static int lengthOfLongestSubstring(String s) {
        char[] a = s.toCharArray();
        Map<Integer, Integer> map = new HashMap<>();
        int left =-1;
        int max =0;
        for(int i=0;i<a.length;i++){
            if(i!=0)
                map.remove((int)a[i-1]);
            for(int j=left+1; j<a.length && map.get((int)a[left+1])==null;j++){
                map.put((int)a[left+1],0);
                left+=1;
            }
            max = max < left-i+1? left-i+1:max;
        }

        return max;
    }

    public static int lengthOfLongestSubstring1(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)){
                start = Math.max(map.get(ch)+1,start);
            }
            max = Math.max(max,end - start + 1);
            map.put(ch,end);
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s){
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }




    public static void main(String[] args) {


        int m = lengthOfLongestSubstring1("adasdddeedcvbnm");
        System.out.println(m);
    }
}
