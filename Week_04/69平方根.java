class Solution {
    public int mySqrt(int x) {
//这道题求平方根，如果不用数据函数，那么可以使用y=x^2 求出x的中间位置mid，那么mid*mid只要等于x，那么mid就是最终的解
        if(x ==0 || x ==1 )return x;
        long left = 0,right = x;
        long mid =1;
        while(left <= right){
            mid = left + (right - left)/2;
            if(mid * mid > x){
                right = mid -1;
            }
            else{
                left = mid + 1;
            }
        }
        return (int)right;
    }
}