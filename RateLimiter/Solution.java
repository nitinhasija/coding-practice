package RateLimiter;

import RateLimiter.strategy.impl.FixedWindowCounter;
import RateLimiter.strategy.impl.LeakyBucket;
import RateLimiter.strategy.impl.SlidingWindowLog;
import RateLimiter.strategy.impl.TokenBucket;
import RateLimiter.strategy.interfaces.RateLimiterStrategy;

public class Solution {
    private static RateLimiterStrategy getInstance(String strategy, int capacity, int intervals) {
        switch (strategy) {
            case "leaky bucket":
                return new LeakyBucket(capacity, intervals);
            case "fixed window":
                return new FixedWindowCounter(capacity, intervals);
            case "sliding window":
                return new SlidingWindowLog(capacity, intervals);
            case "token bucket":
            default:
                return new TokenBucket(capacity, intervals);
        }

    }

    public static void main(String[] args) {
        RateLimiterStrategy strategy = getInstance("token bucket", 1, 5);

        for (int i = 0; i < 10; i++) {
            boolean allowed = strategy.allowRequest();
            System.out.println(allowed);
            try {
                Thread.sleep(1000); // Try a request every 500 ms
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
