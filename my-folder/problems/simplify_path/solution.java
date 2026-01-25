class Solution {
    public String simplifyPath(String path) {
       String[] parts = path.split("/");
       Deque<String> dq=new ArrayDeque<>();
       for(String ch:parts){
        if(ch.equals("")||ch.equals("."))continue;
        else if(ch.equals("..")){
            if(!dq.isEmpty())dq.pollLast();
        }else
            dq.offerLast("/"+ch);
       }
    StringBuilder sb=new StringBuilder();
    while(!dq.isEmpty())
    sb.append(dq.pollFirst());
    return sb.length()>0?sb.toString():"/" ;
    }
}