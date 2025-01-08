class Twitter {

    private static class Tweet {
        int id;
        int time;
        
        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }
    
    private Map<Integer, Set<Integer>> following; // Tracks follow relationships
    private Map<Integer, List<Tweet>> tweets;     // Tracks tweets by users
    private int timestamp;                        // Global timestamp for tweets

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);
        
        // Add user's tweets to the heap
        if (tweets.containsKey(userId)) {
            maxHeap.addAll(tweets.get(userId));
        }

        // Add followees' tweets to the heap
        if (following.containsKey(userId)) {
            for (int followeeId : following.get(userId)) {
                if (tweets.containsKey(followeeId)) {
                    maxHeap.addAll(tweets.get(followeeId));
                }
            }
        }

        // Retrieve the 10 most recent tweets
        List<Integer> result = new ArrayList<>();
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            result.add(maxHeap.poll().id);
            count++;
        }
        
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // A user cannot follow themselves
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
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