import java.util.*;
class Twitter {
    Map<Integer,List<int[]>> tweets;
    Map<Integer,Set<Integer>> follow;
    int time;

    public Twitter() {
        tweets = new HashMap<>();
        follow = new HashMap<>();
        time =0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId,new ArrayList<>());
        tweets.get(userId).add(new int[]{time++,tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        if(tweets.containsKey(userId)){
            for(int[] tweet: tweets.get(userId)){
                pq.offer(tweet);
                if(pq.size()>10){
                    pq.poll();
                }
            }
        }
        if(follow.containsKey(userId)){
            for(int fol: follow.get(userId)){
                if(tweets.containsKey(fol)){
                    for(int[] tweet: tweets.get(fol)){
                        pq.offer(tweet);
                if(pq.size()>10){
                    pq.poll();
                }
                    }
                }
            }
        }
       LinkedList<Integer> arr = new LinkedList<>();
        while(!pq.isEmpty()){
            arr.addFirst(pq.poll()[1]);
        }
        return arr;
    }
    
    public void follow(int followerId, int followeeId) {
        follow.putIfAbsent(followerId,new HashSet<>());
        follow.get(followerId).add(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(follow.containsKey(followerId)){
            follow.get(followerId).remove(followeeId);
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