/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {     
        
        return tmpTree(preorder,0,preorder.length,inorder,0,inorder.length);
    }

    //新增一个辅助函数，用于递归,分别包含 前序、起、止，中序 、起、止。
    public TreeNode tmpTree(int[] preorder,int p_start,int p_end,int[] inorder,int i_start,int i_end){
        //必须先声明递归的退出条件
        if(p_start == p_end){
            return null;
        }

        //初始化找到根节点，根节点就是前序的起始节点
        int root_val = preorder[p_start];

        //声明一个存储树结构的变量
        TreeNode root = new TreeNode(root_val);
        //循环找到根节点在中序遍历中的位置
        int i_root_index = 0;
        for(int i = i_start;i<i_end;i++){
            if(inorder[i] == root_val){
                i_root_index = i;
                break;
            }
        }
        
       
        //z找到中序遍历的左子树
        int left_num = i_root_index - i_start;  
        //进入递归流程 分别从左右递归进行  
        root.left =  tmpTree(preorder,p_start+1,p_start + left_num +1,inorder,i_start,i_root_index);//起始位置是从下标为1开始，因为第一个元素是根节点
        root.right = tmpTree(preorder,p_start + left_num +1,p_end,inorder,i_root_index+1,i_end);
        return root;
    }
}