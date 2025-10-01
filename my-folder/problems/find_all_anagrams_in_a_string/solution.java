class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m=s.length(),n=p.length();
        List<Integer> ans=new ArrayList<>();
        if (m < n) return ans;
        int left=0,right=0;
        int[] map=new int[26];
        for(char c:p.toCharArray())
        map[c-'a']++;
        int count_chars=n;
        while(right< m){
            if(map[s.charAt(right)-'a']>0) count_chars--;
            map[s.charAt(right)-'a']--;
            right++;
            if(right-left==n){
                if( count_chars==0)
                ans.add(left);
                 map[s.charAt(left) - 'a']++;
                if (map[s.charAt(left) - 'a'] > 0) count_chars++;
                left++;
                
            }
        }
        return ans;
    }
}