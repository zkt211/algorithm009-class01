class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        tmplist(n, k, 0,new ArrayList<>());
        return res;
    }

    //递归组合，并返回到数组中
    /*
    1.现将数字进行还原，分别总1开始得到数组
    2.在递归从第一个元素 去遍历所有元素，一次遍历得到一列新的数组

    */

    public  void  tmplist(int n,int k,int pre,List<Integer> list){
        //回溯递归的结束的条件
        if(list.size() == k){
            res.add(new ArrayList(list));
            return;
        }
        for(int i = pre+1; i <= n;i++){
            list.add(i);//数组的放入条件
            tmplist(n,k,i,list);//进入递归
            list.remove(list.size() -1);//清楚数组元素
        }
        

    }
}