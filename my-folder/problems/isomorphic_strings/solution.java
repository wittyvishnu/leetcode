class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map=new HashMap<>(); //(SCHAR,TCHAR)
        if(s.length()!=t.length())return false;
        char[] sArray=s.toCharArray();
        char[] tArray=t.toCharArray();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(sArray[i]) && map.get(sArray[i])!=tArray[i]) return false;
            else if(!map.containsKey(sArray[i]) && map.containsValue(tArray[i])) return false;
            else
            map.put(sArray[i],tArray[i]);

        }
        return true;
    }
}