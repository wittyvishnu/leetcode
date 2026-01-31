class Node {
    Node[] links = new Node[26];
    boolean flag = false;

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public Node get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

     public void setEnd() {
        flag = true;
    }

    public boolean isEnd() {
        return flag;
    }
}

class Trie {
    Node root;
    public Trie() {
        root=new Node();
    }
    
   public void insert(String word) {
    Node temp = root;

    for (char ch : word.toCharArray()) {
        if (!temp.containsKey(ch)) {
            temp.put(ch, new Node());
        }
        temp = temp.get(ch); 
    }

    temp.setEnd(); 
}

    
    public boolean search(String word) {
         Node temp = root;
        for(char ch:word.toCharArray()){
            temp=temp.get(ch);
            if(temp==null)
            return false;
        }
        if(temp.isEnd())return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
         Node temp = root;
        for(char ch:prefix.toCharArray()){
            temp=temp.get(ch);
            if(temp==null)
            return false;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */