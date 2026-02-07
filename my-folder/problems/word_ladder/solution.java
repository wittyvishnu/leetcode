class Solution {
    class Pair{
        String s;
        int count;
        Pair(String s,int count){
            this.s=s;
            this.count=count;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();
        int n=wordList.size();
        for(String s:wordList)
        set.add(s);
        Queue<Pair> q=new ArrayDeque<>();
        q.offer(new Pair(beginWord,1));
        set.remove(beginWord);
        while(!q.isEmpty()){
            Pair temp=q.poll();
            String word=temp.s;
            if(word.equals(endWord))return temp.count;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] replaceChar=word.toCharArray();
                    replaceChar[i]=ch;
                    String replacedWord=new String(replaceChar);
                    if(set.contains(replacedWord)){
                        q.offer(new Pair(replacedWord,temp.count+1));
                        set.remove(replacedWord);
                    }

                }
            }

        }
        return 0;
    }
}