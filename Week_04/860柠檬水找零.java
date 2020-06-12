class Solution {
    public boolean lemonadeChange(int[] bills) {

        /*暴力法 
        如果存在5元钱那么放入map中计数
        否则 如果收到10元钱，那么放入map计数，将5元钱减一
        否则 如果收到20元钱，并且存在 10元 那么10元的减一 5元的减一

        否则 5元计数个数减三，这种相当于没有任何零钱，迁了用户15元，那么相当于三个5元，这时候减去3，可能就成了负数，再做如下判断
        如果不存在5元零钱那么 返回false




        */
        if(bills == null) return false;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(5,0);
        map.put(10,0);
        map.put(20,0);
        for(int i : bills){
            map.put(i,map.get(i)+1);           
            if(i == 10){                
                map.put(5,map.get(5)-1);
            }
            if(i == 20){  
                if( map.get(10)>0){
                    map.put(5,map.get(5)-1);
                    map.put(10,map.get(10)-1);
                }
                else{            
               
                     map.put(5,map.get(5) -3);               
                    }                
            }
            
            if(map.get(5) <0) return false;
        }
        return true;
        
    }
}