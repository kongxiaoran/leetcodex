package leet.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kxr
 * @date 2022/2/18 12:06 AM
 * @description
 *
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * 示例 1:
 *
 *
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 *
 * 作者：字节校园
 * 链接：https://leetcode-cn.com/leetbook/read/bytedance-c01/eiqm25/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution_105 {

    private Map<Integer,Integer> map = new HashMap<>();
    private int[] pre;
    private int preIndex=0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder == null || preorder.length==0 || inorder==null || inorder.length == 0)
            return null;
        pre = preorder;

        //可以通过节点值，获取节点在中序数组中的下标
        for(int i=0;i<preorder.length;i++){
            map.put(inorder[i],i);
        }
        //构建树
        return dfs(0,preorder.length-1);
    }

    public TreeNode dfs(int left, int right){
        if(left>right)
            return null;
        //前序序列 为 根-左子树-右子树 ，所以第一个节点为左右子树的分界点
        TreeNode node = new TreeNode(pre[preIndex++]);
        int index = map.get(node.val);              //取得根节点的下表
        //以根节点的下标来划分左右子树区间，分别再求的 左子树的根节点和右子树的根节点
        node.left = dfs(left,index-1);
        node.right = dfs(index+1,right);
        return node;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
}