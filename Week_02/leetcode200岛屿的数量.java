//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集


//leetcode submit region begin(Prohibit modification and deletion)
/*
1.深度优先算法 DFS
类似于 岛屿的数量 岛屿的周长 岛屿的最大面积 最大人工岛

网格结构的，类似于二叉树的遍历，左右子节点：访问相邻的节点：左子节点 右子节点

有两个关键要素：
第一要素就是访问邻结点
第二要素是判断basecase，也就是遍历退出的条件

那么网格结构中的邻结点，有四个上下左右，用r和c分别代表格子的行和列，那么对应的四个方向的邻结点分别为
上：r-1,c
下：r+1,c
左：r,c-1
右：r,c+1
basecase：超出格子的范围 就返回

需要一个辅助函数dfs完成递归
在递归中包含 元素的遍历方向 以及岛屿个数的总和，
 */
class Solution {
    public int numIslands(char[][] grid) {
        //基本判断，为空或者长度为空 直接返回0个岛屿
        if(grid == null || grid.length == 0){
            return 0;
        }
        //初始化岛屿计数器变量
        int island = 0;
        //遍历两次，分别从行 列进行两个循环
        for(int r =0;r<grid.length;++r){
            for(int c =0;c < grid[0].length;++c){
                if(grid[r][c] != '0'){
                    island++;
                    dfs(grid,r,c);
                }
            }
        }
        return island;

    }

    public void dfs(char[][] grid,int r,int c){
        //basecase1，超出格子的范围
        if(r < 0 || r>=grid.length || c<0 || c>=grid[0].length)
        {
            return;
        }
        //basecase2，将遍历过的1，统统改为0，遇到0直接返回，避免重复遍历
        if (grid[r][c] == '0') {

            return;
        }
        grid[r][c]= '0';
        //遍历的四个方向
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);

    }

}
//leetcode submit region end(Prohibit modification and deletion)
