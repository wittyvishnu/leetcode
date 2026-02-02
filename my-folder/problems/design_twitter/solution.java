class Twitter {
    HashMap<Integer,HashSet<Integer>> followers;//userid,follows
    HashMap<Integer,List<int[]>> posts;//userid,[timestamp,tweetid]
    int count=0;
    public Twitter() {
        followers=new HashMap<>();
        posts=new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        List<int[]> tweets=posts.getOrDefault(userId,new ArrayList<>());
        tweets.add(new int[]{count++,tweetId});
        posts.put(userId,tweets);

    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
         if (posts.containsKey(userId))
         for (int[] tweet : posts.get(userId))
        pq.offer(tweet);
        if (followers.containsKey(userId))
        for(int user:followers.get(userId)){
            if(posts.containsKey(user))
            for (int[] tweet : posts.get(user))
            pq.offer(tweet);
        }
        List<Integer> ans=new ArrayList<>();
        int size=10;
        while(!pq.isEmpty()&&size>0){
            ans.add(pq.poll()[1]);
            size--;
        }      
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!followers.containsKey(followerId)) 
        followers.put(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) 
        followers.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */