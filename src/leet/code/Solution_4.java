package leet.code;

/**
 * @author kxr
 * @date 2022/2/7 3:59 PM
 * @description
 *
 * 达到时间复杂度要求，难度较大
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0,j=0;
        int sum = nums1.length+ nums2.length;
        if(nums1.length == 0){
           if(sum%2 == 0)
               return (nums2[nums2.length/2-1]+nums2[nums2.length/2])/2.0;
           else {
               return nums2[nums2.length/2];
           }
        }else if(nums2.length == 0){
            if(sum%2 == 0)
                return (nums1[nums1.length/2-1]+nums1[nums1.length/2])/2.0;
            else {
                return nums1[nums1.length/2];
            }
        }
        while (i<nums1.length && j<nums2.length){

            if(sum%2==0 && (i+j+2-1) == sum/2){
                return (nums1[i]+nums2[j])/2.0;
            }
            if(sum%2==1 && (i+j+2-1 == sum/2)){
                return nums1[i] > nums2[j] ? nums1[i]:nums2[j];
            }

            if(nums1[i]<nums2[j]){
                i++;
            }else {
                j++;
            }

        }

        while (i<nums1.length){
            if(sum%2==0 && (i+j+2-1) == sum/2){
                return (nums1[i-1]+nums2[i])/2.0;
            }
            if(sum%2==1 && (i+j+2-1 == sum/2)){
                return nums1[i] > nums2[j] ? nums1[i]:nums2[j];
            }
            i++;
        }
        while (j<nums2.length){
            if(sum%2==0 && (i+j+2-1) == sum/2){
                return (nums1[j-1]+nums2[j])/2.0;
            }
            if(sum%2==1 && (i+j+2-1 == sum/2)){
                return nums1[i] > nums2[j] ? nums1[i]:nums2[j];
            }
            j++;
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{3},new int[]{-2,-1}));





    }

}
