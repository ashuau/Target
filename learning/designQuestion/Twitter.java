package learning.designQuestion;

import java.util.*;

public class Twitter {
    private Map <Integer, User1> map = new HashMap<>();
    /** Initialize your data structure here. */
    public Twitter() {

    }

    private User1 getUser(int userId) {
        User1 user = map.get(userId);
        if (user == null) {
            user = new User1(userId);
            map.put(userId, user);
        }
        return user;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        User1 user = getUser(userId);
        user.tweets.add(new Tweet(tweetId));
    }

    /** Retrieve the 10 most recent UserTweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. UserTweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feeds = new ArrayList<>(10);
        User1 user = getUser(userId);
        List<User1> users = new ArrayList<>();
        users.add(user);
        users.addAll(user.follows);
        PriorityQueue<Feed> heap = new PriorityQueue<>(new Comparator<Feed>() {
            @Override
            public int compare(Feed f1, Feed f2) {
                return f2.user.tweets.get(f2.pos).timestamp - f1.user.tweets.get(f1.pos).timestamp;
            }
        });

        for(User1 us : users) {
            if (us.tweets.isEmpty()) continue;
            Collections.sort(us.tweets, new Comparator<Tweet>() {
                @Override
                public int compare(Tweet t1, Tweet t2) {
                    return t1.timestamp - t2.timestamp;
                }
            });
            heap.offer(new Feed(us));
        }
        while (feeds.size() < 10 && !heap.isEmpty()) {
            Feed feed = heap.poll();
            feeds.add(feed.user.tweets.get(feed.pos).tweetId);
            if (--feed.pos >= 0) heap.offer(feed);
        }
        return feeds;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        User1 f1 = getUser(followerId);
        User1 f2 = getUser(followeeId);
        if (followerId == followeeId) return;
        f1.follows.add(f2);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        User1 f1 = getUser(followerId);
        User1 f2 = getUser(followeeId);
        if (followerId == followeeId) return;
        f1.follows.remove(f2);
    }
}
class User1 {
    int userId;
    List<Tweet> tweets = new ArrayList<>();
    Set<User1> follows = new HashSet<>();
    User1(int userId) {
        this.userId = userId;
    }
}
class Tweet {
    private static int count = 0;
    int tweetId;
    int timestamp;
    Tweet(int tweetId) {
        this.tweetId = tweetId;
        this.timestamp = count ++;
    }
}
class Feed {
    User1 user;
    int pos;
    Feed(User1 user) {
        this.user = user;
        this.pos = user.tweets.size()-1;
    }

}
class TwitterMain {
    public static void main(String[] args) {

          Twitter obj = new Twitter();
          obj.postTweet(1,5);
          List<Integer> param_2 = obj.getNewsFeed(1);
         obj.follow(1,2);
        // obj.unfollow(followerId,followeeId);
    }
}