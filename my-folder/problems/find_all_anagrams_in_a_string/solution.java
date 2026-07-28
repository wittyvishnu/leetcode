class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> need=new HashMap<>();
        HashMap<Character,Integer> freq=new HashMap<>();
        List<Integer> ans=new ArrayList<>();
        for(char ch:p.toCharArray())
        need.put(ch,need.getOrDefault(ch,0)+1);
        int len=p.length();
        int l=0,r=0;
        int match=0;
        if(s.length()<len)return ans;
        for(int i=0;i<len;i++){
            char ch=s.charAt(i);
            freq.put(ch,freq.getOrDefault(ch,0)+1);
            if(need.containsKey(ch)&&freq.get(ch)<=need.get(ch))match++;
            r++;
            if(match==len)ans.add(0);
        }
        
        while(r<s.length()){
            char ch=s.charAt(l);
            if(need.containsKey(ch)&&freq.get(ch)<=need.get(ch))match--;
            freq.put(ch,freq.getOrDefault(ch,0)-1);
            l++;
            ch=s.charAt(r);
            r++;
            freq.put(ch,freq.getOrDefault(ch,0)+1);
            if(need.containsKey(ch)&&freq.get(ch)<=need.get(ch))match++;
            if(match==len)ans.add(l);
        }
        return ans;

    }
}