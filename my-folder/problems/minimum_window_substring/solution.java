class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())return "";
        HashMap<Character,Integer> need=new  HashMap<>();
        HashMap<Character,Integer> freq=new  HashMap<>();
        for(char ch:t.toCharArray())
        need.put(ch,need.getOrDefault(ch,0)+1);
        int min=Integer.MAX_VALUE;
        int matched=0;
        int startIndex=0;
        int l=0,r=0;
        while(r<s.length()){
            char ch=s.charAt(r);
            freq.put(ch,freq.getOrDefault(ch,0)+1);
            if(need.containsKey(ch)&&freq.get(ch)<=need.get(ch))matched++;
            r++;
            while(matched==t.length()){
                if(min>r-l+1){
                    startIndex=l;
                    min=r-l+1;
                }
                char c=s.charAt(l);
                freq.put(c,freq.getOrDefault(c,0)-1);
                if(need.containsKey(c)&&freq.get(c)<need.get(c))matched--;
                l++;
            }
        }
        return (min==Integer.MAX_VALUE)?"":s.substring(startIndex,startIndex+min-1);
    }
}