class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
       
        
        
        int n=s.length();
        int ans=0;
        
        int idx=0;
        while(idx<n){
            if (idx + 1 < n && map.get(s.charAt(idx)) < map.get(s.charAt(idx + 1))) {
                ans += map.get(s.charAt(idx + 1)) - map.get(s.charAt(idx));
                idx += 2; 
            } else {
                ans += map.get(s.charAt(idx));
                idx++; 
            }
                
            
        }
        return ans;
        
        
    }
    
}