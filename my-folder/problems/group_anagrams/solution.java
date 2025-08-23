class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(String text:strs){
            char[] chars=text.toCharArray();
            Arrays.sort(chars);
            String element=new String(chars);
            if(!map.containsKey(element))
            map.put(element,new ArrayList<>());
            map.get(element).add(text);

        }
        return new ArrayList<>(map.values());
    }
}