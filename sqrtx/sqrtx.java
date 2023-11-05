class Solution {
    public int mySqrt(int x) {
        
        long left=1,right=x/2+1;
      
        while(left<=right){
            long mid=right+(left-right)/2;
            
            long sqr=mid*mid;
            
            if(sqr<=x)left=mid+1;
            else right=mid-1;
                
            
        }
        
        return (int)right;
        
    }
}